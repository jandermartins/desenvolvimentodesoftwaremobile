package br.ufc.armazenamento;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Button button;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        String filename = "meuarquivo";
        String content = "Olá Mundo";

        FileOutputStream outputStream = null;
        sharedPreferences = getSharedPreferences( "app", Context. MODE_PRIVATE);

        savePreference("aula armazenamento", "Aula 12");
        Log.i("Main", "Aula 12");

        Dexter.withActivity(this).withPermissions(
                Manifest.permission. READ_EXTERNAL_STORAGE,
                Manifest.permission. WRITE_EXTERNAL_STORAGE
        ).withListener( new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                writeToSDFile();
            }
            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest>
                                                                   permissions, PermissionToken token) {
            }
        }).check();



        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FileInputStream inputStream = null;
        try {
            inputStream = openFileInput(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            Log.i("Arquivo", sb.toString());
            inputStreamReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fileintent = new Intent(Intent.ACTION_GET_CONTENT);
                fileintent.setType("gagt/sdf");
                try {
                    startActivityForResult(fileintent, 1);
                } catch (ActivityNotFoundException e) {
                    Log.e("tag", "No activity can handle picking a file. Showing alternatives.");
                }
            }
        });
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment. MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
    public boolean isExternalStorageReadable() {
        String state = Environment. getExternalStorageState();
        if (Environment. MEDIA_MOUNTED.equals(state) ||
                Environment. MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    private void writeToSDFile(){
        File root = android.os.Environment. getExternalStorageDirectory();
        File dir = new File(root.getAbsolutePath() + "/Download");
        dir.mkdirs();
        File file = new File(dir, "myData.txt");
        try {
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);
            pw.println( "Hi , How are you");
            pw.flush();
            pw.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void savePreference(String key, String value) {
        SharedPreferences.Editor editor =
                sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public String readPreference(String key) {
        return sharedPreferences.getString(key, "");
    }

}
