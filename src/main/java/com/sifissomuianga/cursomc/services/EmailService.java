package com.sifissomuianga.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.sifissomuianga.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
