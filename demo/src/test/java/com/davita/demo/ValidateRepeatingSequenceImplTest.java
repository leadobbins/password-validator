package com.davita.demo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateRepeatingSequenceImplTest {

    private ValidatorInterface validateRepeatingSequence = new ValidateRepeatingSequenceImpl();

    private static final String VALID_PASSWORD = "abc123";

    @Test
    public void validateRepeatingCharsValidTest() {
        assertNull(validateRepeatingSequence.validate(VALID_PASSWORD));
    }

    @Test
    public void validateRepeatingCharsInValidTest() {
        String invalid = "2ßabab1";
        String response = validateRepeatingSequence.validate(invalid);
        assertNotNull(response);
        assertTrue(StringUtils.equals(response, "must not contain any sequence of characters immediately followed by the same sequence"));
    }
}