package com.example.iossenac.applistapaises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> listaPaises= new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iniciaListaPaises();
        setContentView(R.layout.activity_main);

        ListView listViewPaises = (ListView) findViewById(R.id.listViewPaises);

        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listaPaises);
        listViewPaises.setAdapter(arrayAdapter);


        listViewPaises.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Toast.makeText(MainActivity.this,
                        listaPaises.get(posicao), Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void iniciaListaPaises() {
        listaPaises.add("Argentina");
        listaPaises.add("Brasil");
        listaPaises.add("Canada");
        listaPaises.add("Dinamarca");
    }

    public void adicionarPais(View view){
        EditText editTextPais = (EditText) findViewById(R.id.editTextPais);
        listaPaises.add(editTextPais.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editTextPais.setText("");

    }




}
