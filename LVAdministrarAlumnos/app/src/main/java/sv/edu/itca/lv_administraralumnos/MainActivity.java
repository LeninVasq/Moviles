package sv.edu.itca.lv_administraralumnos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2,et3,et4;

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
        et1= findViewById(R.id.editTextText);
        et2= findViewById(R.id.editTextText2);
        et3= findViewById(R.id.editTextText3);
        et4= findViewById(R.id.editTextText4);
    }


    private void MessageBox(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void agregar(View view) {
        ControladorBD controladorBD = new ControladorBD(this, "DBColegio", null,1);
        SQLiteDatabase bd = controladorBD.getWritableDatabase();
        String carnet = et1.getText().toString();
        String nombres = et2.getText().toString();
        String apellidos = et3.getText().toString();
        int edad = Integer.parseInt(et4.getText().toString());
        ContentValues registro = new ContentValues();
        registro.put("carnet", carnet);
        registro.put("nombres", nombres);
        registro.put("apellidos", apellidos);
        registro.put("edad", edad);
        bd.insert("alumnos", null, registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        MessageBox("Se cargaron los datos del Alumno");
    }

    public void consulta(View view) {

    }

    public void eliminar(View view) {
    }

    public void modificar(View view) {
    }
}