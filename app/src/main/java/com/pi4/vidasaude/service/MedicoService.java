package com.pi4.vidasaude.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MedicoService {

    private String baseUrl = "https://diogoolivins.000webhostapp.com/medicos/";
    private InterfaceDeServicos api;
    private static MedicoService instancia;

    private MedicoService() {
        api = criaRetrofit().create(InterfaceDeServicos.class);
    }
    public static InterfaceDeServicos getServico() {
        if (instancia == null)
            instancia = new MedicoService();
        return instancia.api;
    }
    private Retrofit criaRetrofit() {
        Gson gson = new GsonBuilder().create();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
