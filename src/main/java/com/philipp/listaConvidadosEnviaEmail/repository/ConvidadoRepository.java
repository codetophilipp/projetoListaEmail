package com.philipp.listaConvidadosEnviaEmail.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.philipp.listaConvidadosEnviaEmail.model.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {
	
	List<Convidado> findByNome(String nome);

}
