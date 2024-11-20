package sv.edu.itca.PianoGrupo17;

import android.app.NotificationManager;
import android.content.Context;
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

    MediaPlayer sonido;


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
                Intent acerca = new Intent( MainActivity.this,  Acercadenosotros.class );
                startActivity(acerca);

                return true;

            case "Piano Tradiconal":
                Toast.makeText(this, "Ya se encuentra en el Piano Tradicional", Toast.LENGTH_SHORT).show();


                return true;



            case "Piano Infantil de la selva":
                Intent selva = new Intent( MainActivity.this, Selva.class );
                startActivity(selva);
                return true;



            case "Piano de instrumentos musicales":
                Intent intrumentos = new Intent( MainActivity.this, Intrumentos.class );
                startActivity(intrumentos);
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
                            Toast.makeText(MainActivity.this, "Ya se encuentra en el Piano Tradiconal", Toast.LENGTH_SHORT).show();
                            return;
                        } else if (seleccionarpiano.equals("Piano Infantil de la Selva")) {
                            pianointent = new Intent(MainActivity.this, Selva.class);
                        } else if (seleccionarpiano.equals("Piano de Instrumentos musicales")) {
                            pianointent = new Intent(MainActivity.this, Intrumentos.class);

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

    private void MessageBox(String mensaje) {
        Toast.makeText(this, "nota  "+mensaje, Toast.LENGTH_SHORT).show();
    }

    public void d_o(View view) {
        MessageBox("Do");
        sonido = MediaPlayer.create(this, R.raw.d_o);
        sonido.start();


    }

    public void re(View view) {
        MessageBox("Re");
        sonido = MediaPlayer.create(this, R.raw.re);
        sonido.start();

    }

    public void mi(View view) {
        MessageBox("Mi");
        sonido = MediaPlayer.create(this, R.raw.mi);
        sonido.start();
    }

    public void sol(View view) {
        MessageBox("Sol");

        sonido = MediaPlayer.create(this, R.raw.sol);
        sonido.start();
    }

    public void fa(View view) {
        MessageBox("Fa");

        sonido = MediaPlayer.create(this, R.raw.fa);
        sonido.start();
    }

    public void la(View view) {
        MessageBox("La");
        sonido = MediaPlayer.create(this, R.raw.la);
        sonido.start();
    }

    public void si(View view) {
        MessageBox("Si");
        sonido = MediaPlayer.create(this, R.raw.si);
        sonido.start();
    }
}