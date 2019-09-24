package br.ufc.crateus.aula_teste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private LineAdapterNum lineAdapterNum;
    Button button, btProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rvNum);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        lineAdapterNum = new LineAdapterNum(new ArrayList<Numero>(0));

        recyclerView.setAdapter(lineAdapterNum);

        button = (Button) findViewById(R.id.btVai);
        btProximo = (Button) findViewById(R.id.btVai);

        int count = 0;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runOnUiThread(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Socket socket = new Socket("10.42.0.1", 60000);
                            DataInputStream dIn = new DataInputStream(socket.getInputStream());
                            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

                            dOut.writeUTF("OK");
                            Numero num1 = new Numero(dIn.readInt());
                            lineAdapterNum.insertItem(num1);
                            dOut.writeUTF("OK");
                            Numero num2 = new Numero(dIn.readInt());
                            lineAdapterNum.insertItem(num2);
                            dOut.writeUTF("OK");
                            Numero num3 = new Numero(dIn.readInt());
                            lineAdapterNum.insertItem(num3);
                            Numero soma = new Numero(num1.getNum() + num2.getNum() + num3.getNum());
                            lineAdapterNum.insertItem(soma);
                            dIn.close();
                            dOut.close();
                            socket.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }));
            }
        });
        count++;
        if(count == 0){
            btProximo.setEnabled(true);
            Intent intent = new Intent(this, SegundaTela.class);
            startService(intent);
        }
    }
}
