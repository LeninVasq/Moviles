package sv.itca.valencia_vasquez_evp1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
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
        Button btn = findViewById(R.id.button);
        TextView password= findViewById(R.id.editTextTextPassword);
        TextView carnet= findViewById(R.id.editTextText);
        TextView error = findViewById(R.id.textView2);

        btn.setOnClickListener(v -> {
            String pass= password.getText().toString();

            if ("Vasques$299".equals(pass)){
                Intent ventana2 = new Intent( MainActivity.this, MainActivity2.class);
                ventana2.putExtra("carnet", carnet.getText().toString());
                startActivity(ventana2);
            }
            else {
                String Carnet = getString(R.string.error) ;
                error.setText(Carnet);
            }
        });
    }
}