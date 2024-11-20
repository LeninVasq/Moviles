package com.example.lv_notitoast;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnDefecto, btnGravity, btnLayout;

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

        btnDefecto = findViewById(R.id.btnPorDefecto);
        btnGravity = findViewById(R.id.btnGravity);
        btnLayout = findViewById(R.id.btnLayout);

    }

    public void BtnDefecto(View v){
        Toast toast1 = Toast.makeText(getApplicationContext(), "Toast por defecto", Toast.LENGTH_SHORT);
        toast1.show();
    }
    public void BtnGravity(View v){
        Toast toast2 = Toast.makeText(getApplicationContext(), "Toast por con gravity", Toast.LENGTH_SHORT);
        toast2.show();
    }
    public void BtnPersonalizado(View v) {
        Toast toast3 = new Toast(getApplicationContext());
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,  findViewById(R.id.lytlayout));
        TextView txtMsg =  layout.findViewById(R.id.txtMensaje);

        txtMsg.setText("Toast Personalizado");
        toast3.setDuration(Toast.LENGTH_SHORT);
        toast3.setView(layout);
        toast3.show();
    }
}