package sv.itca.lv_splachscreen2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Intro extends AppCompatActivity {

    boolean btnAtrasPress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });


        Handler controlador =  new Handler();
         controlador.postDelayed(new Runnable() {
             @Override
             public void run() {
                 if (!btnAtrasPress) {
                     Intent ventana = new Intent(Intro.this, MainActivity.class);
                     startActivity(ventana);
                     finish();

                 }
             }
         }, 3000);

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        btnAtrasPress = true;
    }
}