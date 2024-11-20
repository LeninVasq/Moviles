package sv.edu.itca.lv_lpginusuarios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    //private EditText usuario, clave;
    private TextInputEditText usuario, clave;

    private String user, pass, url, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usuario = findViewById(R.id.username);
        clave = findViewById(R.id.password);
    }

    public void VerificarDatos(View view) {


        user = usuario.getText().toString();
        pass = clave.getText().toString();

        url = "http://192.168.0.4/databasedoggy/login";

        RequestParams parametros = new RequestParams();
        parametros.put("usu",user);
        parametros.put("pas",pass);

        AsyncHttpClient cliente = new AsyncHttpClient();
        cliente.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    String respuesta = new String(responseBody);
                    try {
                        JSONObject MiJson = new JSONObject(respuesta);
                        if (MiJson.names().get(0).equals("exito")) {
                            resultado = MiJson.getString("usuario");
                            if (MiJson.getString("tipo").equals( "1")) {
                                Intent ventana2 = new Intent( MainActivity.this, AdminActivity.class);
                                startActivity(ventana2);
                            }else {
                                Intent ventana2 = new Intent( MainActivity.this, UserActivity2.class);
                                startActivity(ventana2);

                            }
                        }else {
                            resultado = MiJson.getString("error");
                        }
                    Toast.makeText(MainActivity.this, resultado, Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, "Erro en JSON", Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(MainActivity.this, "Error en la conexion", Toast.LENGTH_SHORT).show();

            }
        });

    }
}