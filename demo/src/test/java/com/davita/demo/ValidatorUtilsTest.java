package com.davita.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class ValidatorUtilsTest {
	
	private ValidatorUtils validatorUtils = new ValidatorUtils();
	
	private static final String VALID_PASSWORD = "abc123";
	
	@Test
	public void validateLettersDigitsValidTest() {
		assertNull(validatorUtils.validateLettersDigits(VALID_PASSWORD));
	}
	
	@Test
	public void validateLetterDigitsInvalidLettersOnlyTest() {
		String invalidPwd = "abcdefg";
		String response = validatorUtils.validateLettersDigits(invalidPwd);
		assertNotNull(response);
		assertTrue(StringUtils.equals(response, "must contain lower-case letters and numerical digits only"));
	}

	@Test
	public void validateLetterDigitsInvalidNumbersOnlyTest() {
		String invalidPwd = "123456";
		String response = validatorUtils.validateLettersDigits(invalidPwd);
		assertNotNull(response);
		assertTrue(StringUtils.equals(response, "must contain lower-case letters and numerical digits only"));
	}

	@Test
	public void validateLetterDigitsInvalidUpperCaseTest() {
		String invalidPwd = "ABCDEF";
		String response = validatorUtils.validateLettersDigits(invalidPwd);
		assertNotNull(response);
		assertTrue(StringUtils.equals(response, "must contain lower-case letters and numerical digits only"));
	}

	@Test
	public void validateLetterDigitsInvalidSpecialCharsTest() {
		String invalidPwd = "ab$%$85";
		String response = validatorUtils.validateLettersDigits(invalidPwd);
		assertNotNull(response);
		assertTrue(StringUtils.equals(response, "must contain lower-case letters and numerical digits only"));
	}

	@Test
	public void validateLetterDigitsSpaceTest() {
		String invalidPwd = "ab 123";
		String response = validatorUtils.validateLettersDigits(invalidPwd);
		assertNotNull(response);
		assertTrue(StringUtils.equals(response, "must contain lower-case letters and numerical digits only"));
	}
	
	@Test
	public void validateNumberOfCharsTest() {
		assertNull(validatorUtils.validateNumCharacters(VALID_PASSWORD));		
	}

	@Test
	public void validateTooManyCharsTest() {
		String invalid = "abc123def456ghi";
		String response = validatorUtils.validateNumCharacters(invalid);
		assertNotNull(response);
		assertTrue(StringUtils.equals(response, "must be between 5 and 12 characters in length"));
	}

	@Test
	public void validateTooFewCharsTest() {
		String invalid = "abc1";
		String response = validatorUtils.validateNumCharacters(invalid);
		assertNotNull(response);
		assertTrue(StringUtils.equals(response, "must be between 5 and 12 characters in length"));
	}

	@Test
	public void validateRepeatingCharsValidTest() {
		assertNull(validatorUtils.validateRepeatingSequence(VALID_PASSWORD));		
	}

	@Test
	public void validateRepeatingCharsInValidTest() {
		String invalid = "2ßabab1";
		String response = validatorUtils.validateRepeatingSequence(invalid);
		assertNotNull(response);
		assertTrue(StringUtils.equals(response, "must not contain any sequence of characters immediately followed by the same sequence"));
	}

}
