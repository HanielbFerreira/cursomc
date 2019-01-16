package br.com.cursomc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage smg) {
		LOG.info("Simulando envio de Email...");
		LOG.info(smg.toString());
		LOG.info("Email enviado");
	}

}
