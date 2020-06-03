package com.example.esercitazione21;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class activity_due extends AppCompatActivity {
    //STRINGHE
    String TAG = "Activity 2";
    //COSTANTI
    //Caselle di TESTO
    //BOTTONI
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_due);

        //RECUPERO BOTTONI
        btnHome = findViewById(R.id.bt_home_a2);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();//ricevo quello che è arrivato dalla prima activity
                Bundle b = i.getExtras();//recupero l'extras
                Toast t = Toast.makeText(getApplicationContext(), b.getString("testo"), Toast.LENGTH_SHORT);
                t.show();

                Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
                i1.putExtra("Message", "Nome da inserire");//restituire alla prima activity
                setResult(Activity.RESULT_OK, i1);//l'activity è andata correttamente e gli passo tutti i1
                finish();//l'activity viene distrutta
            }
        });
        Log.d(TAG, "onCreate()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

}
