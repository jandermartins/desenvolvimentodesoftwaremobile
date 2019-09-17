package br.ufc.crateus.aulasocket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Socket socket = new Socket("192.168.0.114", 50000);

                            DataInputStream dIn = new DataInputStream(socket.getInputStream());
                            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

                            dOut.writeUTF(editText.getText().toString());

                            dIn.close();
                            dOut.close();
                            socket.close();

                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

    }
}
