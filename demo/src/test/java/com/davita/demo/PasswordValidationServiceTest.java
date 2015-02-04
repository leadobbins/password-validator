/**
 * 
 */
package com.davita.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * @author ladobbins
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class PasswordValidationServiceTest {
	
	private static final String VALID_PASSWORD = "abc123";

	@Autowired
	private PasswordValidationService service;

	@Test
	public void testValidatePassword() {
		PasswordValidationResponse response = service.validatePassword(VALID_PASSWORD);
		assertNotNull(response);
		assertTrue(response.toString(), response.isValid());
	}

	@Test
	public void testValidatePasswordInvalidUpperCase() {
		String invalid = "Abc123";
		PasswordValidationResponse response = service.validatePassword(invalid);
		assertNotNull(response);
		assertTrue(!response.isValid());
		assertTrue(response.getDetailedResponses().contains("must contain lower-case letters and numerical digits only"));
	}

	@Test
	public void testValidatePasswordInvalidRepeat() {
		String invalid = "abcabc123";
		PasswordValidationResponse response = service.validatePassword(invalid);
		assertNotNull(response);
		assertTrue(!response.isValid());
		assertTrue(response.getDetailedResponses().contains("must not contain any sequence of characters immediately followed by the same sequence"));
	}

	@Test
	public void testValidatePasswordTooLong() {
		String invalid = "abc123def456ghi789";
		PasswordValidationResponse response = service.validatePassword(invalid);
		assertNotNull(response);
		assertTrue(!response.isValid());
		assertTrue(response.getDetailedResponses().contains("must be between 5 and 12 characters in length"));
	}

	@Test
	public void testValidatePasswordMulitpleErrors() {
		String invalid = "456ghiDefDef789";
		PasswordValidationResponse response = service.validatePassword(invalid);
		assertNotNull(response);
		assertTrue(!response.isValid());
		assertTrue(response.getDetailedResponses().contains("must be between 5 and 12 characters in length"));
		assertTrue(response.getDetailedResponses().contains("must not contain any sequence of characters immediately followed by the same sequence"));
		assertTrue(response.getDetailedResponses().contains("must contain lower-case letters and numerical digits only"));
	}
}
