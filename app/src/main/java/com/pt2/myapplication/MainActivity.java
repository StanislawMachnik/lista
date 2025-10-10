package com.pt2.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button dodaj;
    private EditText produkt;
    private EditText cena;
    private EditText opis;
    private ListView lista;
    private TextView textu;
    private ArrayList<Produkt> produktyLista;
    private ArrayAdapter<Produkt> arrayAdapter;
    private double total = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dodaj = findViewById(R.id.dodaj);
        produkt = findViewById(R.id.produkt);
        cena = findViewById(R.id.cena);
        opis = findViewById(R.id.opis);
        lista = findViewById(R.id.lista);
        textu = findViewById(R.id.text);

        produktyLista = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, produktyLista);
        lista.setAdapter(arrayAdapter);

        dodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Produkt obiekt = new Produkt(produkt.getText().toString(), opis.getText().toString(), Double.parseDouble(cena.getText().toString()));
                        produktyLista.add(obiekt);
                        arrayAdapter.notifyDataSetChanged();
                        total += Double.parseDouble(cena.getText().toString());
                        textu.setText("Suma cen: " + total);
                    }
                }
        );
        lista.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        produktyLista.get(i).getCena();
                        Toast.makeText(MainActivity.this, produktyLista.get(i).getOpis() ,Toast.LENGTH_SHORT).show();
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
        );
        lista.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        total -= produktyLista.get(i).getCena();
                        textu.setText("Suma cen: " + total);
                        produktyLista.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                        return false;
                    }
                }
        );
    }
}