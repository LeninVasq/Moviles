package sv.edu.itca.lv_administraralumnos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ControladorBD extends SQLiteOpenHelper {

    public ControladorBD(@Nullable Context context,
                         @Nullable String name,
                         @Nullable SQLiteDatabase.CursorFactory factory,
                         int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Alumnos(carnet text primary key," +
                " nombres text," +
                "apellidos text, edad integer)");
        db.execSQL("CREATE TABLE Materia(codigo text primary key, nombre text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int v1, int v2) {

    }
}
