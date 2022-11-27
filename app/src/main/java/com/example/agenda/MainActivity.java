package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.agenda.db.DBHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //muestra el menú de globo
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    //muestra el resultado de la seleccion del menú
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menuNuevo:
                registro();
                return true;

            case R.id.crearBase:
                crearBase();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void registro() {
        Intent i = new Intent(this, NewActivity.class);
        startActivity(i);
    }

    private void crearBase(){
        DBHelper dbhelper = new DBHelper(MainActivity.this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        if(db != null){
            Toast.makeText(this, "Base de datos creada", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Error al crear la base de datos", Toast.LENGTH_SHORT).show();
        }
    }
    
    
}