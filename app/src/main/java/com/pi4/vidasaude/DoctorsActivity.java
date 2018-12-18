package com.pi4.vidasaude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.pi4.vidasaude.Domain.Medico;
import com.pi4.vidasaude.service.RetrofitService;

import java.util.ArrayList;
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
        setContentView(R.layout.activity_doctors);
        int idEspecialidade = Integer.parseInt(getIntent().getStringExtra("idEspecialidade"));
        Toast.makeText(this, "ID = " + idEspecialidade, Toast.LENGTH_LONG).show();
        consultaMedicos(idEspecialidade);
    }

    private void consultaMedicos(int idEspecialidade) {
        int idEsp = idEspecialidade;
        Call<List<Medico>> chamada = RetrofitService.getServico().medicos();
        chamada.enqueue(new Callback<List<Medico>>() {
            @Override
            public void onResponse(Call<List<Medico>> call, Response<List<Medico>> response) {
                listaDeMedicos = response.body();
                List<String> lista = new ArrayList<>();
                for (Medico medico : listaDeMedicos) {
                    lista.add(medico.getMED_NOME());
                    //lista.add(medico.getMedCrm());
                }

                setContentView(listView);
                listView.setAdapter(new ArrayAdapter<>(DoctorsActivity.this, android.R.layout.simple_list_item_1, lista));
            }

            @Override
            public void onFailure(Call<List<Medico>> call, Throwable t) {
                Log.i("teste", t.getMessage());
            }
        });
    }

    public void consultaServidor(String idMedico) {
        Intent i = new Intent(this, ConsultationActivity.class);
        i.putExtra("idMedico", idMedico);
        startActivity(i);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String idMedico = listaDeMedicos.get(position).getID();
        consultaServidor(idMedico);
    }
}
