package sv.itca.lv_comunicaractividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pantalla2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.disenio2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle extras = getIntent().getExtras();
        //String Datosrecibidos = extras.getString("dato2") + extras.getString("dato1") ;
        String Datosrecibidos = extras.getString("dato1")+ getString(R.string.pregunta);
        TextView datos = findViewById(R.id.tvdatos);
        datos.setText(Datosrecibidos);

    }

    public void ProcesoSi(View view) {
        Intent resp= new Intent();
        resp.putExtra("respuesta",getString(R.string.Respuesta_positiva));
        setResult(RESULT_OK,resp);
        finish();
    }

    public void ProcesoNo(View view) {
        Intent resp= new Intent();
        resp.putExtra("respuesta",getString(R.string.Respuesta_Negativa));
        setResult(RESULT_OK,resp);
        finish();
    }
}