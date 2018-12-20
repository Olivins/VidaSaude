package com.pi4.vidasaude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UnavailableServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unavailable_service);
    }

    public void voltarParaEspecialidades(){
        Intent i = new Intent(this, EspecialityActivity.class);
        startActivity(i);
    }
}
