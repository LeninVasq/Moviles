package sv.itca.doggytraining;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Inicio extends AppCompatActivity {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        // Ajustar el padding para los insets del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.LayoutHome), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar el TabHost
        tabHost = findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setIndicator("", getResources().getDrawable(R.drawable.entrenamientocanino));
        tab1.setContent(R.id.Entre);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setIndicator("", getResources().getDrawable(R.drawable.corazon));
        tab2.setContent(R.id.Cuidado);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3");
        tab3.setIndicator("", getResources().getDrawable(R.drawable.huella));
        tab3.setContent(R.id.Home);

        TabHost.TabSpec tab4 = tabHost.newTabSpec("tab4");
        tab4.setIndicator("", getResources().getDrawable(R.drawable.carritodecompras));
        tab4.setContent(R.id.Tienda);

        TabHost.TabSpec tab5 = tabHost.newTabSpec("tab5");
        tab5.setIndicator("", getResources().getDrawable(R.drawable.usuario));
        tab5.setContent(R.id.Cuenta);

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        tabHost.addTab(tab4);
        tabHost.addTab(tab5);

        // Hacer que la pestaña "Home" sea la primera en mostrarse
        tabHost.setCurrentTabByTag("tab3");



    }


}
