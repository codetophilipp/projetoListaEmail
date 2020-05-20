package com.philipp.listaConvidadosEnviaEmail.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philipp.listaConvidadosEnviaEmail.model.Convidado;
import com.philipp.listaConvidadosEnviaEmail.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;

	public Iterable<Convidado> obterTodos() {

		Iterable<Convidado> convidados = repository.findAll();
		return convidados;
	}

	public void salvar(Convidado convidado) {

		repository.save(convidado);
	}

	public void enviar(String nome, String emailDestinatario) {

		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("codetophilipp@gmail.com", "Charlie88;"));
			email.setSSLOnConnect(true);

			email.setFrom("codetophilipp@gmail.com");
			email.setSubject("Você foi convidado pelo ListaVIP");
			email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
			email.addTo(emailDestinatario);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}

	}

}
