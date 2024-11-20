package sv.edu.itca.PianoGrupo17;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Intrumentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.intrumentos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getTitle().toString()) {

            case "Salida":

                finishAffinity();

                return true;
            case "Acerca de Nosotros":
                Intent acerca = new Intent( Intrumentos.this,  Acercadenosotros.class );
                startActivity(acerca);

                return true;

            case "Cambiar el Piano":
                // Definimos los pianos como en el primer bloque de código
                final String[] pianos = {"Piano Tradicional", "Piano Infantil de la Selva", "Piano de Instrumentos musicales"};

                // Construimos el diálogo de selección
                AlertDialog.Builder builderpiano = new AlertDialog.Builder(this);
                builderpiano.setTitle("Selecciona el Piano");

                // Agregamos las opciones al diálogo
                builderpiano.setItems(pianos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String seleccionarpiano = pianos[i];
                        Intent pianointent = null;

                        // Evaluamos cuál opción fue seleccionada
                        if (seleccionarpiano.equals("Piano Tradicional")) {
                            pianointent = new Intent(Intrumentos.this, MainActivity.class);
                        } else if (seleccionarpiano.equals("Piano Infantil de la Selva")) {
                            pianointent = new Intent(Intrumentos.this, Selva.class);
                        } else if (seleccionarpiano.equals("Piano de Instrumentos musicales")) {
                            Toast.makeText(Intrumentos.this, "Ya se encuentra en el Piano de instrumentos", Toast.LENGTH_SHORT).show();
                            return; // Salimos si ya estamos en el piano actual
                        }

                        // Iniciamos la actividad correspondiente solo si no es el piano actual
                        if (pianointent != null) {
                            startActivity(pianointent);
                            Toast.makeText(getApplicationContext(), seleccionarpiano + " Seleccionado.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                // Mostramos el diálogo
                builderpiano.show();
                return true;



            default:
                return super.onOptionsItemSelected(item);
        }




    }
    private void MessageBox(String mensaje) {
        Toast.makeText(this, "Sonido de  "+mensaje, Toast.LENGTH_SHORT).show();
    }
    MediaPlayer sonido;


    public void flauta(View view) {
        MessageBox("Flauta");
        sonido = MediaPlayer.create(this, R.raw.flauta);
        sonido.start();
    }

    public void guitarra(View view) {
        MessageBox("guitarra");
        sonido = MediaPlayer.create(this, R.raw.guitarra);
        sonido.start();
    }

    public void pandero(View view) {
        MessageBox("pandero");
        sonido = MediaPlayer.create(this, R.raw.pandero);
        sonido.start();
    }

    public void saxofon(View view) {
        MessageBox("saxofon");
        sonido = MediaPlayer.create(this, R.raw.saxofon);
        sonido.start();
    }

    public void tambor(View view) {
        MessageBox("tambor");
        sonido = MediaPlayer.create(this, R.raw.tambor);
        sonido.start();
    }

    public void trompeta(View view) {
        MessageBox("trompeta");
        sonido = MediaPlayer.create(this, R.raw.trompeta);
        sonido.start();
    }

    public void maracas(View view) {
        MessageBox("maracas");
        sonido = MediaPlayer.create(this, R.raw.maracas);
        sonido.start();
    }
}