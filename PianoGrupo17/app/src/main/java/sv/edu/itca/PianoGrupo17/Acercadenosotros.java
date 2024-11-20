package sv.edu.itca.PianoGrupo17;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Acercadenosotros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.acercadenosotros);
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

        switch (item.getTitle().toString()){

            case "Salida":

                finishAffinity();

                return true;
            case "Acerca de Nosotros":
                Toast.makeText(this, "Ya se encuentra en Acerca de nosotrs", Toast.LENGTH_SHORT).show();

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
                            pianointent = new Intent(Acercadenosotros.this, MainActivity.class);

                        } else if (seleccionarpiano.equals("Piano Infantil de la Selva")) {
                            pianointent = new Intent(Acercadenosotros.this, Selva.class);
                        } else if (seleccionarpiano.equals("Piano de Instrumentos musicales")) {
                            pianointent = new Intent(Acercadenosotros.this, Intrumentos.class);

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
}