     package sv.itca.lv_buscadordinamico;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  implements SearchView.OnQueryTextListener  {

    private ListView Listado;

    SearchView buscador;
    ArrayAdapter<String> adaptador;
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
        buscador = findViewById(R.id.svBuscador);
        Listado = findViewById(R.id.lvListarElemntos);



        String[] Elementos = {
                "Juan Pérez", "Carmelo González", "Ana Cerón", "Alan Brito", "Karla Castro",
                "María López", "Luis Ramírez", "Pedro Fernández", "Laura Martínez", "Sofía García",
                "Jorge Torres", "Isabel Hernández", "Ricardo Díaz", "Gabriela Núñez", "Andrés Flores",
                "Elena Rojas", "Daniel Ortega", "Patricia Vega", "Fernando Reyes", "Lucía Morales",
                "Miguel Herrera", "Raquel Jiménez", "David Castillo", "Claudia Navarro", "Carlos Mendoza",
                "Verónica Salazar", "José Morales", "Marta Guzmán", "Rafael Gómez", "Nuria Peña",
                "Samuel Vázquez", "Paula Sánchez", "Javier Castro", "Alma Suárez", "Pablo Fuentes",
                "Adriana Paredes", "Tomás Herrera", "Cristina Flores", "Esteban Pérez", "Susana León",
                "Vicente Romero", "Carolina Rivas", "Felipe Campos", "Julia Reyes", "Manuel Ramos",
                "Renata Gil", "Rodrigo Silva", "Ángela Figueroa", "Gonzalo Luna", "Victoria Solís",
                "Emilio Delgado", "Mariana Ponce", "Enrique Soto", "Sara Prieto", "Francisco Ibáñez",
                "Carmen Ruiz", "Héctor Arce", "Paola García", "Matías Domínguez", "Natalia Aguirre",
                "Rubén López", "Liliana Salinas", "Diego Méndez", "Montserrat Robles", "Agustín Lara",
                "Daniela Castañeda", "Ignacio Valdez", "Teresa Olivares", "Julio Cervantes", "Bárbara Nieto",
                "Gerardo Espinoza", "Silvia Carrillo", "Bruno Lozano", "Beatriz Villanueva", "Oscar Peralta",
                "Luisa Calderón", "Guillermo Tapia", "Elisa Estrada", "Roberto Chávez", "Cecilia Ramos"
        };

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Elementos);
        Listado.setAdapter(adaptador);

        buscador.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adaptador.getFilter().filter(newText);
        return false;
    }
}