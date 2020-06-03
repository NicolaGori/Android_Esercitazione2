package com.example.esercitazione21;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class activity_tre extends AppCompatActivity {
    Button btHome;
    String TAG = "Activity Tre";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tre);

        btHome = findViewById(R.id.bt_home);


        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Bundle b = i.getExtras();
                Toast t = Toast.makeText(getApplicationContext(), b.getString("testo"), Toast.LENGTH_SHORT);
                t.show();//mostro il toast

                Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
                i1.putExtra("Message_SQL", "Dati da DB");
                setResult(Activity.RESULT_OK, i1);
                finish();
            }
        });
    }
    }
/*


 */
