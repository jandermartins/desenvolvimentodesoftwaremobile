package com.example.segundoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText tFirstName;
    EditText tLastName;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tFirstName = (EditText) findViewById(R.id.tFirstName);
        tLastName = (EditText) findViewById(R.id.tLastName);

        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                i.putExtra("tFirstName", tFirstName.getText().toString());
                i.putExtra("tLastName", tLastName.getText().toString());

                startActivity(i);
            }
        });
    }
}
