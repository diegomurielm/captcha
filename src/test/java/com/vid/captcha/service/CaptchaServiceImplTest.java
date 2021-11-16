package com.vid.captcha.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.vid.captcha.config.MensajesProperties;
import com.vid.captcha.model.MensajeResponse;
import com.vid.captcha.model.ValidarRequest;

@RunWith(MockitoJUnitRunner.class)
class CaptchaServiceImplTest {

    @Mock
	private static MensajesProperties mockMensajesProperties;

    private static CaptchaServiceImpl service;
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		
		MockitoAnnotations.openMocks(CaptchaServiceImplTest.class);
		mockMensajesProperties = mock(MensajesProperties.class);

		service = new CaptchaServiceImpl(mockMensajesProperties);
	}

	@Test
	void validarCaptchaReturnOk(){
		
		ValidarRequest request = new ValidarRequest("valor", "valor");
		
		when(mockMensajesProperties.getDescriptionFromCode("textoOk")).thenReturn("textoOk");
		when(mockMensajesProperties.getDescriptionFromCode("botonOk")).thenReturn("botonOk");
		
		MensajeResponse response =service.validarCaptcha(request);
		
		assertEquals("textoOk", response.getMensaje());
		assertEquals("botonOk", response.getBoton());
	}

	@Test
	void validarCaptchaReturnKo(){
		
		ValidarRequest request = new ValidarRequest("valorKo", "valor");
		
		when(mockMensajesProperties.getDescriptionFromCode("textoKo")).thenReturn("textoKo");
		when(mockMensajesProperties.getDescriptionFromCode("botonKo")).thenReturn("botonKo");
		
		MensajeResponse response =service.validarCaptcha(request);
		
		assertEquals("textoKo", response.getMensaje());
		assertEquals("botonKo", response.getBoton());
	}
	
}
