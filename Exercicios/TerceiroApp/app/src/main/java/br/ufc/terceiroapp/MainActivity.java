package br.ufc.terceiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    CheckBox cbPizza, cbRefri, cbHamb;
    Button btCalcular;
    EditText etQtdPizza, etPrecoPizza, etQtdRefri, etPrecoRefri, etQtdHamb, etPrecoHamb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCalcular = (Button) findViewById(R.id.btCalcular);
        cbPizza = (CheckBox) findViewById(R.id.cbPizza);
        cbRefri = (CheckBox) findViewById(R.id.cbRefri);
        cbHamb = (CheckBox) findViewById(R.id.cbHamb);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double precoPizza = 12.06;
                double precoRefri = 13.55;
                double precoHamburguer = 16.00;
                double total = 0.00;
                String mensagem = "Itens Selecionados" + "\n";

                if(cbPizza.isChecked()){
                    total += precoPizza;

                    mensagem += "Pizza: "+ precoPizza + "\n";
                }
                if(cbRefri.isChecked()){
                    total += precoRefri;
                    mensagem += "Refrigerante "+ precoRefri +"\n";
                }
                if(cbHamb.isChecked()){
                    total += precoHamburguer;
                    mensagem += "Hamburguer "+ precoHamburguer;
                }
                Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_SHORT).show();
            }
        });


    }

}
