package com.pi4.vidasaude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pi4.vidasaude.Domain.Especialidade;
import com.pi4.vidasaude.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    List<Especialidade> listaDeEspecialidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = new ListView(MainActivity.this);
        listView.setOnItemClickListener(this);
        consultaEspecialidades();
    }


    private void consultaEspecialidades() {
        Call<List<Especialidade>> chamada = RetrofitService.getServico().especialidades();
        chamada.enqueue(new Callback<List<Especialidade>>() {
            @Override
            public void onResponse(Call<List<Especialidade>> call, Response<List<Especialidade>> response) {
                listaDeEspecialidades = response.body();
                List<String> lista = new ArrayList<String>();
                for (Especialidade especialidade : listaDeEspecialidades) {
                    lista.add(especialidade.getESP_NOME());
                }

                setContentView(listView);
                listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, lista));
            }

            @Override
            public void onFailure(Call<List<Especialidade>> call, Throwable t) {
                Log.i("teste", t.getMessage());
            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String idEspecialidade = listaDeEspecialidades.get(position).getID();
        Intent i = new Intent(this, DoctorsActivity.class);
        i.putExtra("idEspecialidade",idEspecialidade);
        startActivity(i);
    }
}
