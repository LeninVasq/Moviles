package com.example.lv_cuadrosdialogo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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


    }

    public void MostrarInformacion(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder( this);
        builder.setMessage("Esto es un mensaje de alerta")
                .setTitle("Informacion")
                .setPositiveButton("Ok", null);
        builder.setCancelable(false);
        builder.create();
        builder.show();
    }

    public void PedirConfirmacion(View view){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage("Que Desea ver?");
        builder2.setCancelable(false);
        builder2.setTitle("Elija");
        builder2.setPositiveButton("Saludo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast mensajito = Toast.makeText(getApplicationContext(),
                        "Hola", Toast.LENGTH_SHORT);
                mensajito.show();
            }
        });
        builder2.setNegativeButton("Despedida", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast mensajito = Toast.makeText(getApplicationContext(),
                        "Adios", Toast.LENGTH_SHORT);
                mensajito.show();
            }
        });
        builder2.create();
        builder2.show();
    }

    public void MostrarMultiple(View v){
        final String[] idiomas={"Español","English", "French"};
        AlertDialog.Builder builder3 = new AlertDialog.Builder( this);
        builder3.setTitle("Seleccion");
        builder3.setItems(idiomas, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast mensajito = Toast.makeText(getApplicationContext(),
                        "Idioma Seleccionado " + idiomas[i], Toast.LENGTH_SHORT);
                mensajito.show();
            }
        });

        builder3.create();
        builder3.show();
    }

    public void MostrarPersonalizado(View v){
        AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
        LayoutInflater inflater= this.getLayoutInflater();
        builder4.setView(inflater.inflate(R.layout.dialogo_personalizado, null))
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        builder4.create();
        builder4.show();
    }
}