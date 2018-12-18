package com.pi4.vidasaude;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pi4.vidasaude.Domain.Medico;

import java.util.List;

class EspecialidadesAdapeter extends BaseAdapter {
    List<Medico> lista;
    Context ctx;

    public EspecialidadesAdapeter(Context ctx, List<Medico> lista) {
        this.lista = lista;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Medico medico = lista.get(position);
        View linha = LayoutInflater.from(ctx).inflate(R.layout.activity_doctors, null);

        TextView nome = linha.findViewById(R.id.nome_tv);
        TextView crm = linha.findViewById(R.id.crm_tv);
        Button btn = linha.findViewById(R.id.consulta_bt);

        nome.setText(medico.getMED_NOME());
        crm.setText(medico.getMED_CRM());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "Médico selecionado: "+ medico.getMED_NOME(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ctx,ConsultationActivity.class);
                ctx.startActivity(i);
            }
        });

        return linha;
    }
}
