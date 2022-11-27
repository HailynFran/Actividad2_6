package com.example.agenda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.agenda.db.DBContactos;

public class NewActivity extends AppCompatActivity {
    EditText txtNombre,txtTelefono,txtCorreo;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        txtNombre= findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreo = findViewById(R.id.txtCorreo);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBContactos dbContactos = new DBContactos(NewActivity.this);
                long id= dbContactos.insertarContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreo.getText().toString());
                if(id>0){
                    Toast.makeText(NewActivity.this, "Registro guardado", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(NewActivity.this, "Error al guardar el registro", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void limpiar() {
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }

}
