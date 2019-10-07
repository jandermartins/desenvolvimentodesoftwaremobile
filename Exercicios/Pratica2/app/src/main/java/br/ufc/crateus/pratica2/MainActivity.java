package br.ufc.crateus.pratica2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton fab;
    Button btNext;
    RecyclerView recycler;
    LinearAdapter mAdapter;
    int num1;
    int num2;
    int num3;
    int cont = 0;
    int tam = 0;

    int soma = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        btNext = (Button) findViewById(R.id.btNext);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        mAdapter = new LinearAdapter(new ArrayList<>(0));
        recycler.setAdapter(mAdapter);
        btNext.setVisibility(View.INVISIBLE);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);
                startActivity(intent);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Socket socket = new Socket("10.42.0.1", 60000);
                            DataInputStream dIn = new DataInputStream(socket.getInputStream());
                            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

                            dOut.writeUTF("OK");
                            Log.i("ok", "mandou ok");
                            num1 = dIn.readInt();
                            cont++;
                            Log.i("num1", String.valueOf(num1));
                            dOut.writeUTF("OK");
                            Log.i("ok", "mandou ok");
                            num2 = dIn.readInt();
                            cont++;
                            Log.i("num2", String.valueOf(num2));
                            dOut.writeUTF("OK");
                            Log.i("ok", "mandou ok");
                            num3 = dIn.readInt();
                            cont++;
                            Log.i("num3", String.valueOf(num3));
                            soma = num1 + num2 + num3;

                            dIn.close();

                            dOut.close();

                            socket.close();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mAdapter.insertItem(num1, num2, num3, soma);
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                    tam++;
                    Log.i("tam", String.valueOf(tam));
                    cont = 0;
                if(tam >= 5){
                    btNext.setVisibility(View.VISIBLE);
                }else{
                    btNext.setVisibility(View.INVISIBLE);
                }

            }
        });

    }
}
