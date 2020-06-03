package com.example.esercitazione21;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //STRINGHE
    String nome;
    String TAGR;
    //COSTANTI
    static final int REQUEST_CODE = 1;
    static final int REQUEST_CODE_SQL = 2;
    //Caselle di TESTO
    EditText name;
    //BOTTONI
    Button cerca;
    Button verifica;
    Button cancella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RECUPERO TESTI
        name = (EditText) findViewById(R.id.ptxt_nome);
        //RECUPERO BOTTONI
        cerca = findViewById(R.id.bt_cerca);
        cancella = findViewById(R.id.bt_cancella);


        //────────────Eliminazione del Contenuto della Casella testuale────────────//
        cancella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CLEAR TEXT
                name.getText().clear();
                //name.setText("");
            }
        });
        //========================Passaggio all'Activity 2========================//
        verifica.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                nome = name.getText().toString();

                Toast t = Toast.makeText(getApplicationContext(), nome, Toast.LENGTH_SHORT);
                t.show();

                Intent i = new Intent(getApplicationContext(), activity_due.class);
                i.putExtra("testo", nome);//spedisco NOME alla seconda activity attraverso l'intent
                startActivityForResult(i, REQUEST_CODE);
            }


        });
        //========================Passaggio all'Activity 3========================//
        cerca.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                nome = name.getText().toString();

                Intent i = new Intent(getApplicationContext(), activity_tre.class);
                i.putExtra("testo", nome);

                //startActivityForResult(i, REQUEST_CODE_SQL);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //chek if the request code is same as what is passed
        if((requestCode == REQUEST_CODE) && (resultCode == Activity.RESULT_OK)){
            String messaggio = data.getStringExtra("Message");
            name.setText(messaggio);
        } else if(requestCode == Activity.RESULT_CANCELED){
            //SECONDA NON RESTITUISCE NULLA
            Toast t = Toast.makeText(getApplicationContext(), "Operazione annullata!", Toast.LENGTH_SHORT);
            t.show();//mostra il toast
        }
         if((requestCode == REQUEST_CODE_SQL) && (resultCode == Activity.RESULT_OK)){
            String messaggio = data.getStringExtra("Message_SQL");
           name.setText(messaggio);
        }
         Log.d(TAGR, "Metodo onResult");
    }
}
