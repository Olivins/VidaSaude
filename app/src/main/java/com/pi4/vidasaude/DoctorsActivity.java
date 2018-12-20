package com.pi4.vidasaude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.pi4.vidasaude.Adapters.EspecialidadesAdapter;
import com.pi4.vidasaude.Domain.Medico;
import com.pi4.vidasaude.service.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorsActivity extends AppCompatActivity {

    ListView listView;
    List<Medico> listaDeMedicos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = new ListView(this);
        String idEspecialidade = getIntent().getStringExtra("idEspecialidade");
        String nomeEspecialidade = getIntent().getStringExtra("nomeEspecialidade");
        setTitle(nomeEspecialidade);
        consultaMedicos(idEspecialidade, nomeEspecialidade);
    }

    private void consultaMedicos(String idEspecialidade, String nomeEspecialidade) {
        //Toast.makeText(this, "ID = " + idEspecialidade, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "" + nomeEspecialidade, Toast.LENGTH_LONG).show();
        Call<List<Medico>> chamada = RetrofitService.getServico().medicosById(idEspecialidade);
        chamada.enqueue(new Callback<List<Medico>>() {
            @Override
            public void onResponse(Call<List<Medico>> call, Response<List<Medico>> response) {
                listaDeMedicos = response.body();
                EspecialidadesAdapter especialidadesAdapter =  new EspecialidadesAdapter(DoctorsActivity.this,listaDeMedicos);
                setContentView(listView);
                listView.setAdapter(especialidadesAdapter);
            }

            @Override
            public void onFailure(Call<List<Medico>> call, Throwable t) {
                Log.i("teste", t.getMessage());
                mostrarPlaceholder();
            }
        });
    }

    public void mostrarPlaceholder() {
        Intent i = new Intent(this, UnavailableServiceActivity.class);
        startActivity(i);
    }
}
