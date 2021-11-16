package com.vid.captcha.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MensajeResponse {

	private String mensaje;
	private String boton;
}
