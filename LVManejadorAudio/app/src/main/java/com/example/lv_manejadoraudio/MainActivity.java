package com.example.lv_manejadoraudio;

import android.Manifest;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ImageButton bGrabar, bDetener, bReproducir, bDetenerG;
    private TextView tvRuta;
    private MediaRecorder mRec;
    private MediaPlayer mPlay;
    private String stHora, fichero;
    Calendar Micalendario = Calendar.getInstance();

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

            bGrabar = findViewById(R.id.bGrabar);
            bDetenerG = findViewById(R.id.bDetenerG);
            bDetener = findViewById(R.id.vDetenerR);
            bReproducir = findViewById(R.id.bReproducir);
            tvRuta = findViewById(R.id.tvRuta);

            verificarPermisos();


            controlarBotones(View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
    }

    private void controlarBotones(int p1, int p2, int p3, int p4) {
        bGrabar.setVisibility(p1);
        bDetenerG.setVisibility(p2);
        bReproducir.setVisibility(p3);
        bDetener.setVisibility(p4);

    }

    private void verificarPermisos() {
        if (ContextCompat.checkSelfPermission
                (this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission
                        (this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            } ,1000);

        }
    }

    MediaPlayer sonido;
    public void SonidoClick(View view) {

        sonido = MediaPlayer.create(this, R.raw.click);
        sonido.start();
    }

    public void SonidoAlarma(View view) {
         sonido = MediaPlayer.create(this, R.raw.alarma);
        sonido.start();
    }

    public void SonidoExplosion(View view) {
         sonido = MediaPlayer.create(this, R.raw.explosion);
        sonido.start();
    }

    private void MessageBox(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }



    private void generarRutaArchivo() {

        stHora = String.valueOf(Micalendario.get(Calendar.HOUR_OF_DAY));
        stHora += String.valueOf(Micalendario.get(Calendar.MINUTE));
        stHora += String.valueOf(Micalendario.get(Calendar.SECOND));
        stHora += String.valueOf(Micalendario.get(Calendar.MILLISECOND));
        ContextWrapper cw= new ContextWrapper(getApplicationContext());
        File DirecorioMusica = cw.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File MiArchivo = new File(DirecorioMusica, "Grabacion_"+stHora+".3gp");
        fichero= MiArchivo.getPath();

        tvRuta.setText("Ruta del Archivo:\n " + fichero );
    }

    public void grabar(View view) {
        generarRutaArchivo();

        mRec = new MediaRecorder();
        mRec.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRec.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mRec.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        mRec.setOutputFile(fichero);
        try {
            mRec.prepare();
            mRec.start();
            MessageBox("Grabando...");
            controlarBotones(View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
        } catch (IOException error) {
            MessageBox("Error al intentar grabar");
        }
    }

    public void detenergabacion(View view) {
        mRec.stop();
        mRec.release();
        mRec= null;
        MessageBox("Archivo grabado con exito!");
        controlarBotones(View.VISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE);

    }

    public void Reproducir(View view) {
        mPlay = new MediaPlayer();
        try {
            mPlay.setDataSource(fichero);
            mPlay.prepare();
            mPlay.start();
            MessageBox("Reproducion Grabacion");
            controlarBotones(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE);

        } catch (IOException e) {
            MessageBox("Error al intentar reproducir");
        }
    }

    public void DetenerReproducion(View view) {
        mPlay.stop();
        mPlay.release();
        mPlay= null;
        MessageBox("Reproducion detenida con exito!");
        controlarBotones(View.VISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE);


    }
}