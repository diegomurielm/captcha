package com.vid.captcha.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum CaptchaType {

    NUMERICO ("01"),

    ALFANUMERICO ("02");

    public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
     * The identifier
     */
    private String identifier;

}
