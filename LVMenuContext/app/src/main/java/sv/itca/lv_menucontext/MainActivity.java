package sv.itca.lv_menucontext;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView lblMensaje;
    private ListView lvlista;
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

        lblMensaje = findViewById(R.id.LblMensaje);
        lvlista=  findViewById(R.id.Lvlista);

        String [] datos = new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>( this,android.R.layout.simple_list_item_1, datos);

        lvlista.setAdapter(adapter);
        registerForContextMenu(lblMensaje);
        registerForContextMenu(lvlista);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        if (v.getId() == R.id.LblMensaje) {
            inflater.inflate(R.menu.menu_ctx_etiqueta, menu);
        } else if (v.getId() == R.id.Lvlista) {
            AdapterView.AdapterContextMenuInfo info =
                    (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle(lvlista.getAdapter().getItem(info.position).toString());
            inflater.inflate(R.menu.menu_ctx_lista, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getTitle().toString()){
            case "Opcion 1":
                lblMensaje.setText("Etiqueta: Opcion 1 pulsadas!");
                return true;
            case "Opcion 2":
                lblMensaje.setText("Etiqueta: Opcion 2 pulsadas!");
                return true;
            case "Lista 1":
                lblMensaje.setText("Lista[Elem"+(info.position+1)+"]: Opcion 1 pulsadas!");
                return true;
            case "Lista 2":
                lblMensaje.setText("Lista[Elem"+(info.position+1)+"]: Opcion 2 pulsadas!");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}