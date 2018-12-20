package com.pi4.vidasaude.service;

import com.pi4.vidasaude.Domain.Especialidade;
import com.pi4.vidasaude.Domain.Medico;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InterfaceDeServicos {

    @GET("/especialidades.php")
    Call<List<Especialidade>> especialidades();

    @GET("/medicos.php")
    Call<List<Medico>> medicos(); //

    @GET("/{id}.php")
    Call<List<Medico>> medicosById(@Path("id") String idEspecialidade); //muito errado

    @GET("/medicos_especialidade.php?id={id}")
    Call<List<Medico>> medicosByEspecialidade(@Path("id") String idEspecialidade); //

    @GET("/medicos_id.php?id={id}")
    Call<Medico> medicoById(@Path("id") String id); //

}
