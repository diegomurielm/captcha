package com.vid.captcha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@PropertySource("classpath:config/mensajes.properties")
public class MensajesProperties {

	/** The env. */
	@Autowired
	private Environment env;
	
	/**
	 * Gets the description from code.
	 *
	 * @param errorCode the error code
	 * @return the description from code
	 */
	public String getDescriptionFromCode(String errorCode) {
		return env.getProperty(String.valueOf(errorCode));
	}
}
