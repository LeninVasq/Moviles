package sv.itca.lv_conversorunidades;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView txtGramos;
    private TextView txtLibras;
    private TextView txtKilos;
    private TextView txtToneladas;

    private TextView txtMilimetros;
    private TextView txtcentimetro;
    private TextView txtmetros;
    private TextView txtkilometros;

    private TextView txtCelsius;
    private TextView txtFahrenheit;
    private TextView txtKelvin;


    private final int QUINIETOS = 500, MIL = 1000,DOSMIL=2000, MILLON = 1000000;





    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.miTabHost), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        IniciarVariable();

        Button btnConvertirPeso = findViewById(R.id.btnConvertir);
        btnConvertirPeso.setOnClickListener( v -> configurarBtnConvertir());
        Button btnConvertirLong = findViewById(R.id.btnConvertirLong);
        btnConvertirLong.setOnClickListener(v -> configurarBtnConvertir1());

        Button btnConvertirTemp = findViewById(R.id.btnConvertirTemp);
        btnConvertirTemp.setOnClickListener(v -> configurarBtnConvertir2());
        TabHost tabcontrol = findViewById(R.id.miTabHost);
        tabcontrol.setup();

        TabHost.TabSpec spec;

        spec = tabcontrol.newTabSpec("PESO");
        spec.setContent(R.id.tab1);
        spec.setIndicator("", getResources().getDrawable(R.drawable.ic_menu_peso));
        tabcontrol.addTab(spec);

        spec = tabcontrol.newTabSpec("TEMP");
        spec.setContent(R.id.tab2);
        spec.setIndicator("", getResources().getDrawable(R.drawable.ic_menu_temperatura));
        tabcontrol.addTab(spec);

        spec = tabcontrol.newTabSpec("LONG");
        spec.setContent(R.id.tab3);
        spec.setIndicator("", getResources().getDrawable(R.drawable.ic_menu_longitud));
        tabcontrol.addTab(spec);
    }

    private void IniciarVariable() {
        txtGramos = findViewById(R.id.txtGramos);
        txtLibras = findViewById(R.id.txtLibras);
        txtKilos = findViewById(R.id.txtKilos);
        txtToneladas = findViewById(R.id.txtToneladas);


        txtMilimetros = findViewById(R.id.txtmilimetros);
        txtcentimetro = findViewById(R.id.txtcentimetros);
        txtmetros = findViewById(R.id.txtmetros);
        txtkilometros = findViewById(R.id.txtkilometros);

        txtCelsius = findViewById(R.id.txtCelsius);
        txtFahrenheit = findViewById(R.id.txtFahrenheit);
        txtKelvin = findViewById(R.id.txtKelvin);
    }

    private void configurarBtnConvertir() {

        final int GRAMO = 0, LIBRA = 1, KILO = 2, TONELADA = 3;
        EditText valorPeso = findViewById(R.id.txtValorPeso);
        TextView tv1 = findViewById(R.id.tv1);

        tv1.setText("");
        if (valorPeso.getText().toString().isEmpty()){

            tv1.setText(R.string.valor);
        }
        else {


            String strValor = valorPeso.getText().toString();
                Float valorConvertido = Float.parseFloat(strValor);
            Spinner spnUnidadesPeso = findViewById(R.id.spinnerUnidades);
                int itemSeleccioando = spnUnidadesPeso.getSelectedItemPosition();

                switch (itemSeleccioando) {
                    case GRAMO:
                        txtGramos.setText(strValor);
                        txtLibras.setText(gramosLIbras(valorConvertido));
                        txtKilos.setText(gramosKilos(valorConvertido));
                        txtToneladas.setText(gramoToneladas(valorConvertido));
                        break;

                    case LIBRA:
                        txtGramos.setText(libraGramos(valorConvertido));
                        txtLibras.setText(strValor);
                        txtKilos.setText(libraKilos(valorConvertido));
                        txtToneladas.setText(libraaToneladas(valorConvertido));
                        break;
                    case KILO:
                        txtGramos.setText(Kilosgramos(valorConvertido));
                        txtLibras.setText(Kiloslibras(valorConvertido));
                        txtKilos.setText(strValor);
                        txtToneladas.setText(Kilostoneladas(valorConvertido));
                        break;
                    case TONELADA:
                        txtGramos.setText(Toneladasgramos(valorConvertido));
                        txtLibras.setText(Toneladaslibras(valorConvertido));
                        txtKilos.setText(Toneladaskilos(valorConvertido));
                        txtToneladas.setText(strValor);
                        break;

                }


        }


    }

    private void configurarBtnConvertir1() {


        EditText valorLong = findViewById(R.id.txtvalorLong);
        TextView tv2= findViewById(R.id.tv2);

        tv2.setText("");

        if (valorLong.getText().toString().isEmpty()){

            tv2.setText(R.string.valor);
        }
        else {

            final int MILIMETROS = 0, CENTIMETROS = 1 , METROS = 2, KILOMETROS= 3;
            String strValorLong = valorLong.getText().toString();
                Float valorConvertir = Float.parseFloat(strValorLong);
            Spinner spnUnidadeslong = findViewById(R.id.spinerLog);
                int itemSeleccionado = spnUnidadeslong.getSelectedItemPosition();

                switch (itemSeleccionado) {
                    case MILIMETROS:
                        txtMilimetros.setText(strValorLong);
                        txtcentimetro.setText(Milimetroscentimetros(valorConvertir));
                        txtmetros.setText(Milimetrosmetros(valorConvertir));
                        txtkilometros.setText(MilimetrosKilometros(valorConvertir));
                        break;

                    case CENTIMETROS:
                        txtMilimetros.setText(Centimetrosmilimetros(valorConvertir));
                        txtcentimetro.setText((strValorLong));
                        txtmetros.setText(Centimetrosmetros(valorConvertir));
                        txtkilometros.setText(CentimetrosKilometros(valorConvertir));
                        break;

                    case METROS:
                        txtMilimetros.setText(Metrosmilimetros(valorConvertir));
                        txtcentimetro.setText(Metroscentimetros(valorConvertir));
                        txtmetros.setText((strValorLong));
                        txtkilometros.setText(Metroskilometros(valorConvertir));
                        break;

                    case KILOMETROS:
                        txtMilimetros.setText(Kilometrosmilimetros(valorConvertir));
                        txtcentimetro.setText(Kilometroscentimetros(valorConvertir));
                        txtmetros.setText(Kilometrosmetros(valorConvertir));
                        txtkilometros.setText((strValorLong));
                        break;
                }



        }


    }

    private void configurarBtnConvertir2() {

        EditText valorTemp = findViewById(R.id.txtvalorTemp);
        TextView tv3= findViewById(R.id.tv3);

        tv3.setText("");

        if (valorTemp.getText().toString().isEmpty()){

            tv3.setText(R.string.valor);
        }
        else {
            final int Celsius = 0, Fahrenheit = 1 , Kelvin = 2;

            String strValorTemp = valorTemp.getText().toString();
            Float valorConvertir1 = Float.parseFloat(strValorTemp);
            Spinner spnUnidadesTemp = findViewById(R.id.spinerTemp);
            int itemSeleccionado = spnUnidadesTemp.getSelectedItemPosition();

            switch (itemSeleccionado) {
                case Celsius:
                    txtCelsius.setText(strValorTemp);
                    txtFahrenheit.setText(CelsiusFahreheint(valorConvertir1));
                    txtKelvin.setText(CelsiusKelvin(valorConvertir1));
                    break;

                case Fahrenheit:
                    txtCelsius.setText(FahrenheitCelsius(valorConvertir1));
                    txtFahrenheit.setText((strValorTemp));
                    txtKelvin.setText(FahrenheitKelvin(valorConvertir1));
                    break;

                case Kelvin:
                    txtCelsius.setText(KelvinCelsius(valorConvertir1));
                    txtFahrenheit.setText(KelvinFahrentint(valorConvertir1));
                    txtKelvin.setText((strValorTemp));
                    break;


            }

        }
    }

    //celsius a otras temp
    private String CelsiusFahreheint(Float ValorConvertir){
        double ope = 0.0;
        ope = ((ValorConvertir*9/5)+32);
        return String.format("%,2f", ope);
    }

    private String CelsiusKelvin(Float ValorConvertir){
        double ope = 0.0;
        ope =(ValorConvertir +273.15);

        return String.format("%,2f", ope);
    }

    //Fahrenheit a otras temp
    private String FahrenheitCelsius(Float ValorConvertir){
        double ope = 0.0;
        ope=((ValorConvertir-32)*5/9);
        return String.format("$,2f", ope);
    }

    private String FahrenheitKelvin(Float ValorConvertir){
        double ope = 0.0;
        ope = ((ValorConvertir-32)*5/9+273.15);
        return String.format("%,2f", ope);
    }

    //kelvin a otras temp
    private String KelvinCelsius(Float ValorConvertir){
        double ope = 0.0;
        ope =(ValorConvertir- 273.15);
        return String.format("%,2f", ope);
    }

    private String KelvinFahrentint(Float ValorConvertir){
        double ope = 0.0;
        ope =((ValorConvertir-273.15)*9/5+32);
        return String.format("%,2f", ope);
    }

    //convertir milimiteros a otras longitudes
    private String Milimetroscentimetros(Float ValorConvertir){
        double ope = 0.0;
        ope =(ValorConvertir/10);
        return String.format("%,2f", ope);

    }

    private String Milimetrosmetros(Float ValorConvertir){
        double ope = 0.0;
        ope =(ValorConvertir/MIL);
        return String.format("%,2f", ope);
    }

    private String MilimetrosKilometros(Float ValorConvertir){
        double ope = 0.0;
        ope =(ValorConvertir/MILLON);
        return String.format("%,2f", ope);
    }



    // centimetros a otras longitudes

    private String Centimetrosmilimetros(Float ValorConvertir){
        double ope = 0.0;
        ope =(ValorConvertir*10);
        return String.format("%,2f", ope);
    }

    private String Centimetrosmetros(Float ValorConvertir){
        double ope = 0.0;
        ope =(ValorConvertir/100);
        return String.format("%,2f", ope);
    }

    private String CentimetrosKilometros(Float ValorConvertir){
        double ope = 0.0;
        ope =(ValorConvertir/100000);
        return String.format("%,2f", ope);
    }

    //metros a otras longitudes

    private String Metrosmilimetros(Float ValorConvertir){
        double ope = 0.0;
        ope =(ValorConvertir* MIL);
        return String.format("%,2f", ope);
    }

    private String Metroscentimetros(Float ValorConvertir){
        double ope =(ValorConvertir * 100);
        return String.format("%,2f", ope);
    }

    private String Metroskilometros(Float ValorConvertir){
        double ope =(ValorConvertir/ MIL);
        return String.format("%,2f", ope);
    }

    //kilometros a otras unidades

    private String Kilometrosmilimetros(Float ValorConvertir){
        double ope =(ValorConvertir* MILLON);
        return String.format("%,2f", ope);
    }

    private String Kilometroscentimetros(Float ValorConvertir){
        double ope =(ValorConvertir* 100000);
        return String.format("%,2f", ope);
    }
    private String Kilometrosmetros(Float ValorConvertir){
        double ope =(ValorConvertir* MIL);
        return String.format("%,2f", ope);
    }




    // GRAMOS A LAS OTRAS UNIDADES
    private String gramosLIbras(Float ValorConvertir){
        double ope =(ValorConvertir/QUINIETOS);
        return String.format(Locale.US,"%,2f", ope);
    }

    private String gramosKilos (Float valorConvertir){
        double ope =(valorConvertir/MIL);
        return String.format(Locale.US,"%,2f", ope);

    }

    private String gramoToneladas(Float valorConvertir){
        double ope =(valorConvertir/MILLON);
        return String.format(Locale.US,"%,2f", ope);
    }

    // libras a las otras toneladas
    private String libraGramos(Float valorConvertir){
        double ope =(valorConvertir*QUINIETOS);
        return String.format(Locale.US,"%,2f", ope);
    }

    private String libraKilos (Float valorConvertir){
        double ope =(valorConvertir/2);
        return String.format(Locale.US,"%,2f", ope);
    }

    private String libraaToneladas (Float valorConvertir){
        double ope =(valorConvertir/DOSMIL);
        return String.format(Locale.US,"%,2f", ope);
    }

    //Kilos a otras unidades

    private String Kilosgramos(Float valorConvertir){
        double ope =(valorConvertir* MIL);
        return String.format(Locale.US,"%,2f", ope);
    }

    private String Kiloslibras(Float valorConvertir){
        double ope =(valorConvertir* 2);
        return String.format(Locale.US,"%,2f", ope);
    }

    private String Kilostoneladas(Float valorConvertir){
        double ope =(valorConvertir/ MIL);
        return String.format(Locale.US,"%,2f", ope);
    }

    //Toneladas a las otras unidades

    private String Toneladasgramos(Float valorConvertir){
        double ope =(valorConvertir* MILLON);
        return String.format(Locale.US,"%,2f", ope);
    }

    private String Toneladaslibras(Float valorConvertir){
        double ope =(valorConvertir* DOSMIL);
        return String.format(Locale.US,"%,2f", ope);
    }

    private String Toneladaskilos(Float valorConvertir){
        double ope =(valorConvertir* MIL);
        return String.format(Locale.US,"%,2f", ope);
    }






}