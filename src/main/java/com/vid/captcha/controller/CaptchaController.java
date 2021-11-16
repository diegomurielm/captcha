package com.vid.captcha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vid.captcha.model.MensajeResponse;
import com.vid.captcha.model.SettingsRequest;
import com.vid.captcha.model.ValidarRequest;
import com.vid.captcha.service.CaptchaService;

@RestController
public class CaptchaController {
	
	@Autowired
	private CaptchaService service;

	@Autowired
    SettingsRequest sessionScopedBean;
    
    @PostMapping("/settings")
	public void settings(@RequestBody SettingsRequest request) throws Exception {

    	if(request.getLongitud()<4 || request.getLongitud()>8) {
    		throw new Exception("La longitud debe estar entre 4 y 8.");
    	}
    	sessionScopedBean = request;
	}


	@GetMapping("/instrucciones")
	public ResponseEntity<MensajeResponse> instrucciones() {

		return ResponseEntity.ok(service.cargarInstrucciones());
	}
	
	@GetMapping("/generar")
	public ResponseEntity<String> generar() {

		return ResponseEntity.ok(service.generarCaptcha(sessionScopedBean.getLongitud(),sessionScopedBean.getTipo().getIdentifier()));
	}
	
	@GetMapping("/validar")
	public ResponseEntity<MensajeResponse> validar(@RequestBody ValidarRequest request) {

		return ResponseEntity.ok(service.validarCaptcha(request));
	}
	
	
}
