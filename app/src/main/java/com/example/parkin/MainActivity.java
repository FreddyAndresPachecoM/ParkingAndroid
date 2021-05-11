package com.example.parkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parkin.models.Persona;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLogin = findViewById(R.id.buttonLogin);
        Button buttonRegistro = findViewById(R.id.buttonRegistro);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin.setOnClickListener(ingresar);
        buttonRegistro.setOnClickListener(registrar);
    }

    View.OnClickListener ingresar = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            cursor = Persona.getLogin(getApplicationContext(),editTextUsername.getText().toString(),editTextPassword.getText().toString());

           if (cursor.getCount()>0){
               ingresar(v);
           }else{
               Toast.makeText(v.getContext(), "Username o Password ingresados incorrectamente!"+editTextUsername.getText().toString()+editTextPassword.getText().toString(), Toast.LENGTH_LONG).show();
           }
        }
    };

    View.OnClickListener registrar = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            registrar(v);
        }
    };

    public void ingresar(View view){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

    public void registrar(View view){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}