package com.davita.demo;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateLettersDigitsImplTest {

    private ValidatorInterface validateLettersDigits = new ValidateLettersDigitsImpl();
    private static final String VALID_PASSWORD = "abc123";

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void validateLettersDigitsValidTest() {
        assertNull(validateLettersDigits.validate(VALID_PASSWORD));
    }

    @Test
    public void validateLetterDigitsInvalidLettersOnlyTest() {
        String invalidPwd = "abcdefg";
        String response = validateLettersDigits.validate(invalidPwd);
        assertNotNull(response);
        assertTrue(StringUtils.equals(response, "must contain lower-case letters and numerical digits only"));
    }

    @Test
    public void validateLetterDigitsInvalidNumbersOnlyTest() {
        String invalidPwd = "123456";
        String response = validateLettersDigits.validate(invalidPwd);
        assertNotNull(response);
        assertTrue(StringUtils.equals(response, "must contain lower-case letters and numerical digits only"));
    }

    @Test
    public void validateLetterDigitsInvalidUpperCaseTest() {
        String invalidPwd = "ABCDEF";
        String response = validateLettersDigits.validate(invalidPwd);
        assertNotNull(response);
        assertTrue(StringUtils.equals(response, "must contain lower-case letters and numerical digits only"));
    }

    @Test
    public void validateLetterDigitsInvalidSpecialCharsTest() {
        String invalidPwd = "ab$%$85";
        String response = validateLettersDigits.validate(invalidPwd);
        assertNotNull(response);
        assertTrue(StringUtils.equals(response, "must contain lower-case letters and numerical digits only"));
    }

    @Test
    public void validateLetterDigitsSpaceTest() {
        String invalidPwd = "ab 123";
        String response = validateLettersDigits.validate(invalidPwd);
        assertNotNull(response);
        assertTrue(StringUtils.equals(response, "must contain lower-case letters and numerical digits only"));
    }

}