package com.vid.captcha.service;

import com.vid.captcha.model.MensajeResponse;
import com.vid.captcha.model.ValidarRequest;

public interface CaptchaService {

	MensajeResponse cargarInstrucciones();

	String generarCaptcha(int longitud, String type);

	MensajeResponse validarCaptcha(ValidarRequest request);

}
