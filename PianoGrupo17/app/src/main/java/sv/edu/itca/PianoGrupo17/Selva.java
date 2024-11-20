package sv.edu.itca.PianoGrupo17;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
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

public class Selva extends AppCompatActivity {
    boolean btnAtrasPress = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.selva);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void MessageBox(String mensaje) {
        Toast.makeText(this, "Sonido de  "+mensaje, Toast.LENGTH_SHORT).show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getTitle().toString()){

            case "Salida":

                finishAffinity();

                return true;

            case "Acerca de Nosotros":
                Intent acerca = new Intent( Selva.this,  Acercadenosotros.class );
                startActivity(acerca);

                return true;




            case "Cambiar el Piano":
                final String[] pianos = {"Piano Tradicional", "Piano Infantil de la Selva", "Piano de Instrumentos musicales"};

                AlertDialog.Builder builderpiano = new AlertDialog.Builder(this);
                builderpiano.setTitle("Selecciona el Piano");

                builderpiano.setItems(pianos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String seleccionarpiano = pianos[i];
                        Intent pianointent = null;

                        // Evaluamos cuál opción fue seleccionada
                        if (seleccionarpiano.equals("Piano Tradicional")) {
                            pianointent = new Intent(Selva.this, MainActivity.class);

                        } else if (seleccionarpiano.equals("Piano Infantil de la Selva")) {
                            Toast.makeText(Selva.this, "Ya se encuentra en el Piano de la selva", Toast.LENGTH_SHORT).show();
                            return;
                        } else if (seleccionarpiano.equals("Piano de Instrumentos musicales")) {
                            pianointent = new Intent(Selva.this, Intrumentos.class);

                        }

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

    MediaPlayer sonido;
    public void leon(View view) {
        MessageBox("leon");
        sonido = MediaPlayer.create(this, R.raw.leon);
        sonido.start();
    }

    public void rana(View view) {
        MessageBox("rana");
        sonido = MediaPlayer.create(this, R.raw.rana);
        sonido.start();
    }

    public void buho(View view) {
        MessageBox("buho");
        sonido = MediaPlayer.create(this, R.raw.buho);
        sonido.start();
    }

    public void cabra(View view) {
        MessageBox("cabra");
        sonido = MediaPlayer.create(this, R.raw.cabra);
        sonido.start();
    }

    public void mono(View view) {
        MessageBox("mono");
        sonido = MediaPlayer.create(this, R.raw.mono);
        sonido.start();
    }

    public void delfin(View view) {
        MessageBox("delfin");
        sonido = MediaPlayer.create(this, R.raw.delfin);
        sonido.start();
    }

    public void elefante(View view) {
        MessageBox("elefante");
        sonido = MediaPlayer.create(this, R.raw.elefante);
        sonido.start();
    }
}