package com.pi4.vidasaude;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;

import com.pi4.vidasaude.Domain.Especialidade;
import com.pi4.vidasaude.Domain.Medico;
import com.pi4.vidasaude.service.RetrofitService;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsultationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    Button btnData;
    Button btnHora;
    Calendar c;
    DatePickerDialog dpd;
    TimePickerDialog tpd;
    Medico medico;
    Especialidade especialidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation);
        String idMedico = getIntent().getStringExtra("idMedico");
        String nomeMedico = getIntent().getStringExtra("nomeMedico");
        String crmMedico = getIntent().getStringExtra("crmMedico");
        String nomeEspecialidade = getIntent().getStringExtra("nomeEspecialidade");
        insereDadosMedico(nomeMedico,crmMedico,nomeEspecialidade);
    }

    private void insereDadosMedico(String nome, String crm, String especialidade) {

        ((ProgressBar) findViewById(R.id.progressBar)).setVisibility(View.INVISIBLE);
        ((GridLayout) findViewById(R.id.dados_medico)).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.nomemedico)).setText(nome);
        ((TextView) findViewById(R.id.crmmedico)).setText(crm);
        ((TextView) findViewById(R.id.especialidademedico)).setText(especialidade);

    }

    public void solicitarConsulta(View view) {
        Intent i = new Intent(this, FinalActivity.class);
        startActivity(i);
    }

    public void escolherData(View view) {
        btnData = (Button) findViewById(R.id.botaodata);
        c = Calendar.getInstance();

        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        dpd = new DatePickerDialog(ConsultationActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                //TextView data = (TextView) findViewById(R.id.data);
                btnData.setText(day + "/" + month + "/" + year);
            }

            ;
        }, day, month, year);
        dpd.setTitle("Select Date");

        c.setTimeInMillis(c.getTimeInMillis());
        long mindate = c.getTime().getTime();
        c.add(Calendar.MONTH, 1);
        long maxdate = c.getTime().getTime();

        dpd.getDatePicker().setMinDate(mindate);
        dpd.getDatePicker().setMaxDate(maxdate);

        /*if(Build.VERSION.SDK_INT < 23){
            dpd.setTitle("Select Date");
        }*/
        dpd.show();
    }


    public void escolherHora(View view) {

        btnHora = (Button) findViewById(R.id.botaohora);
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        tpd = new TimePickerDialog(ConsultationActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                //TextView hora = (TextView) findViewById(R.id.hora);
                btnHora.setText(hour + ":" + minute);
            }
        }, hour, minute, true);//Yes 24 hour time
        tpd.setTitle("Select Time");
        tpd.show();


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        solicitarConsulta(null);
    }
}
