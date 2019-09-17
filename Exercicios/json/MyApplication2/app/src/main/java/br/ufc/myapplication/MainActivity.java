package br.ufc.myapplication;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btImage;
    private ProgressDialog p;
    private InputStream is;
    private String nome;
    RecyclerView recyclerView;
    private LineAdapter lineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        lineAdapter = new LineAdapter(new ArrayList(0));
        recyclerView.setAdapter(lineAdapter);


        btImage = (Button) findViewById(R.id.btJson);
        recyclerView = (RecyclerView) findViewById(R.id.rv);


        btImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AulaAsyncTask().execute("https://jsonplaceholder.typicode.com/users");
            }
        });
    }

    private class AulaAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p = new ProgressDialog(MainActivity.this);
            p.setMessage("É já macho!!");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL texto = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) texto.openConnection();
                conn.setDoInput(true);
                conn.connect();
                is = conn.getInputStream();
                nome = convertInputStreamToString(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return nome;
        }

        @Override
        protected void onPostExecute(String nome) {
            super.onPostExecute(nome);
            if (nome != null) {
                p.hide();
                try {
                    JSONArray jsonArray = new JSONArray(nome);
                    for (int i = 0; i < jsonArray.length(); i++){
                        lineAdapter

                    }
                }catch ()



                Toast.makeText(MainActivity.this, nome, Toast.LENGTH_SHORT).show();
            } else {
                p.show();
            }
        }
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null) {
            result += line;
        }

        inputStream.close();
        return result;
    }
}

