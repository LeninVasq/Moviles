package sv.itca.doggy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashsCreen extends AppCompatActivity {

    boolean btnatras = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashs_creen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Handler controller = new Handler();
        controller.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!btnatras) {
                    Intent inicio_session = new Intent( SplashsCreen.this , registro.class);
                    startActivity(inicio_session);
                    finish();
                }
            }
        }, 3000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        btnatras =true;
    }
}