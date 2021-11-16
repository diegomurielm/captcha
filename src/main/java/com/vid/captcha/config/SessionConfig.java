package com.vid.captcha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.vid.captcha.model.SettingsRequest;

@Component
public class SessionConfig {

	@Bean
	@SessionScope
	public SettingsRequest sessionScopeBean() {
		return new SettingsRequest();
	}
}
