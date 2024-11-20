package sv.itca.lv_comunicaractividades;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pantalla1 extends AppCompatActivity {

    private EditText Nombre ;
    private TextView resultado;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.disenio1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn = findViewById(R.id.btnEnviar);
        Nombre = findViewById(R.id.etNombre);
        resultado = findViewById(R.id.Resultador);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Forma 1: Capturar y enviar  a otro Viem dentrod de la misma pantalla
                //resultado.setText(Nombre.getText().toString());
                // Forma 2
                /*
                Intent ventana2 = new Intent(Pantalla1.this, Pantalla2.class);
                ventana2.putExtra("dato1", Nombre.getText().toString());
                ventana2.putExtra("dato2", "Hola ");
                startActivity(ventana2);
                */


                // Forma 2

                Intent ventana2 = new Intent( Pantalla1.this, Pantalla2.class);
                ventana2.putExtra("dato1", Nombre.getText().toString());
                ventana2.putExtra("dato2", "Hola ");
                startActivityForResult(ventana2, 777);


            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 777 && resultCode== RESULT_OK && data!= null){
            resultado.setText(data.getExtras().getString("respuesta"));

        }
    }

    public void ProcesoSalir(View v){
        finish();
    }

    public void Procesoacercade(View x){
        Intent ventana3= new Intent( Pantalla1.this, Pantalla3.class);
        startActivity(ventana3);
    }

}