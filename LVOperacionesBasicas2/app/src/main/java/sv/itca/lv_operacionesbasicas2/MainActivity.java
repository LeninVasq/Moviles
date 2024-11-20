package sv.itca.lv_operacionesbasicas2;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText et1, et2;
    private TextView tv3;
    private Spinner spn1;
    private Button vBoton;
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

        et1= (EditText) findViewById(R.id.etV1);
        et2= (EditText) findViewById(R.id.etV2);
        tv3= (TextView) findViewById(R.id.tvResultado);
        spn1= (Spinner) findViewById(R.id.spinner1);

        /*
        String[] opciones = {"Sumar","Restar","Multiplicacion", "Division"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spn1.setAdapter(adapter);
         */

        vBoton= (Button)  findViewById(R.id.btnCalcular);
        vBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operar();
            }
        });

    }

    public  void operar() {

        //if (et1.getText().toString().length()==0){
        //if (et1.getText().toString().equals("")){
        if (et1.getText().toString().isEmpty()) {
            tv3.setText(R.string.error1);
        } else if (et2.getText().toString().isEmpty()) {
            tv3.setText(R.string.error2);
        } else {
            double n1 = Double.parseDouble(et1.getText().toString());
            double n2 = Double.parseDouble(et2.getText().toString());
            String select = spn1.getSelectedItem().toString();

            double ope = 0.0;
            boolean ecero = false;

            if (select.equals("Sumar")) {
                ope = n1 + n2;
            }
            if (select.equals("Restar")) {
                ope = n1 - n2;
            }
            if (select.equals("Multiplicacion")) {
                ope = n1 * n2;
            }
            if (select.equals("Division")) {
                if (n2 != 0) {
                    ope = n1 / n2;
                } else {
                    ecero = true;
                }
            }
            if (ecero) {
                tv3.setText(R.string.error);
            } else {


                tv3.setText(String.format("%.2f", ope));
            }

        }
    }
}