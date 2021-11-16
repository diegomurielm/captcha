package com.vid.captcha.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vid.captcha.config.MensajesProperties;
import com.vid.captcha.model.MensajeResponse;
import com.vid.captcha.model.ValidarRequest;

@Service
public class CaptchaServiceImpl implements CaptchaService {
	
	private MensajesProperties mensajesProperties;


	@Autowired
	public CaptchaServiceImpl(MensajesProperties mensajesProperties) {
		this.mensajesProperties = mensajesProperties;
	}
	
	@Override
	public MensajeResponse cargarInstrucciones() {

		return new MensajeResponse(mensajesProperties.getDescriptionFromCode("textoInicio"),
				mensajesProperties.getDescriptionFromCode("botonInicio"));
	}


	@Override
	public String generarCaptcha(int longitud, String type) {
		
		StringBuilder captcha = new StringBuilder();
		if("01".equals(type)) {
			for(int i=0; i<longitud; i++) {
				int aleatorio = (int) (Math.random()*10);
				captcha.append(String.valueOf(aleatorio));
			}
			return captcha.toString();
		}else {
			return RandomStringUtils.randomAlphanumeric(longitud);
		}
	}

	@Override
	public MensajeResponse validarCaptcha(ValidarRequest request) {
		// TODO Auto-generated method stub
		if(request.getCaptcha().equals(request.getValor())) {
			return new MensajeResponse(mensajesProperties.getDescriptionFromCode("textoOk"),
					mensajesProperties.getDescriptionFromCode("botonOk"));
		}else {
			return new MensajeResponse(mensajesProperties.getDescriptionFromCode("textoKo"),
					mensajesProperties.getDescriptionFromCode("botonKo"));
		}
	}

	

}
