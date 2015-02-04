package com.davita.test2;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.davita.demo.PasswordValidationResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class AppTest {
	
	@Inject
	private App app;

	@Test
	public void testTestPasswordValidation() {
		PasswordValidationResponse response = app.testPasswordValidation("abc123");
		assertNotNull(response);
		assertTrue(response.isValid());
	}

}
