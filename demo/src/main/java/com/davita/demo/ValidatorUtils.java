/**
 * 
 */
package com.davita.demo;

import javax.inject.Named;

/**
 * Provides operations to validate that a password
 * must consist of a mixture of lower-case letters and numerical digits only, 
 * with at least one of each.
 * 
 * @author ladobbins
 *
 */
@Named
public class ValidatorUtils {
	
	private static final String INVALID_LETTERS_DIGITS_ERROR_MSG = "must contain lower-case letters and numerical digits only";
	private static final String INVALID_NUM_CHARS_ERROR_MSG = "must be between 5 and 12 characters in length";
	private static final String INVALID_REPEAT_SEQ_ERROR_MSG = "must not contain any sequence of characters immediately followed by the same sequence";

	private static final String PASSWORD_LETTERS_DIGITS_PATTERN = "^[a-z]+[0-9]+$";
	private static final String REPEAT_PATTERN = "(?!(.+?)\\1).*";
	
	/**
	 * Validates that the password contains both lower-case letters and
	 * numerical digits only, with at least one of each.  If the password
	 * is valid the string returns null otherwise the string contains
	 * the error message.
	 * 
	 * @param password
	 * @return 
	 */
	public String validateLettersDigits(String password) {
		if (password.matches(PASSWORD_LETTERS_DIGITS_PATTERN)){
			return null;
		} else {
			return INVALID_LETTERS_DIGITS_ERROR_MSG;
		}			
	}
	
	/**
	 * Validates that the password is between 5 and 12 characters in length (inclusive).
	 * Returns null if it is, an error message otherwise.
	 * 
	 * @param password
	 * @return
	 */
	public String validateNumCharacters(String password) {
		if ((password.length() < 5) || (password.length() > 12)) {
			return INVALID_NUM_CHARS_ERROR_MSG;
		} else {
			return null;
		}
	}
	
	/**
	 * Validates that there are no repeating sequence of characters in the password.
	 * null is returned if there are none, an error message otherwise.
	 * 
	 * @param password
	 * @return
	 */
	public String validateRepeatingSequence(String password) {
		String returnString = null;
		if (password.matches(REPEAT_PATTERN)) {
			if (password.length() > 3) {
				// Recurse through since the regular expression only checks from
				// the beginning of the password
				returnString = validateRepeatingSequence(password.substring(1));
			} 
		} else {
			returnString = INVALID_REPEAT_SEQ_ERROR_MSG;
		}
		return returnString;
	}
	
}
