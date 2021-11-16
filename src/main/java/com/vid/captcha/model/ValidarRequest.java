package com.vid.captcha.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidarRequest {

	private String valor;
	private String captcha;
}
