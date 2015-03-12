package com.davita.demo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateNumCharsImplTest {

    private ValidatorInterface validateNumChars = new ValidateNumCharsImpl();
    private static final String VALID_PASSWORD = "abc123";

    @Test
    public void validateNumberOfCharsTest() {
        assertNull(validateNumChars.validate(VALID_PASSWORD));
    }

    @Test
    public void validateTooManyCharsTest() {
        String invalid = "abc123def456ghi";
        String response = validateNumChars.validate(invalid);
        assertNotNull(response);
        assertTrue(StringUtils.equals(response, "must be between 5 and 12 characters in length"));
    }

    @Test
    public void validateTooFewCharsTest() {
        String invalid = "abc1";
        String response = validateNumChars.validate(invalid);
        assertNotNull(response);
        assertTrue(StringUtils.equals(response, "must be between 5 and 12 characters in length"));
    }

}