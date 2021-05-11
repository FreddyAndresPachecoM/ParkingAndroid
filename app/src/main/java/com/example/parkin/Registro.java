package com.example.parkin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parkin.models.Persona;

public class Registro extends AppCompatActivity {

    private EditText editTextNombre, editTextApellido, editTextCorreo, editTextCelular, editTextUsernameR, editTextPasswordR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextCorreo = findViewById(R.id.editTextCorreo);
        editTextCelular = findViewById(R.id.editTextCelular);
        editTextUsernameR = findViewById(R.id.editTextUsernameR);
        editTextPasswordR = findViewById(R.id.editTextPasswordR);

        Button buttonRegistrar = findViewById(R.id.buttonRegistroR);

        buttonRegistrar.setOnClickListener(registrarR);

    }

    View.OnClickListener registrarR = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            Persona persona = new Persona();
            persona.setNombre(editTextNombre.getText().toString());
            persona.setApellido(editTextApellido.getText().toString());
            persona.setCorreo(editTextCorreo.getText().toString());
            persona.setCelular(editTextCelular.getText().toString());
            persona.setUsername(editTextUsernameR.getText().toString());
            persona.setPassword(editTextPasswordR.getText().toString());

            persona.guardar(getApplicationContext());

            Toast.makeText(v.getContext(), "Persona agregada correctamente!", Toast.LENGTH_LONG).show();
        }
    };
}