package com.vid.captcha.model;

import lombok.Data;

@Data
public class SettingsRequest {

	private CaptchaType tipo;
	private int longitud;
	private int intetos;
}
