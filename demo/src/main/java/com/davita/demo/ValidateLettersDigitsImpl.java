/**
 * 
 */
package com.davita.demo;

/**
 * @author ladobbins
 *
 */
public class ValidateLettersDigitsImpl implements ValidatorInterface {

	private static final String INVALID_LETTERS_DIGITS_ERROR_MSG = "must contain lower-case letters and numerical digits only";
	private static final String PASSWORD_LETTERS_DIGITS_PATTERN = "^[a-z]+[0-9]+$";

	/* (non-Javadoc)
	 * @see com.davita.demo.ValidatorInterface#validate(java.lang.String)
	 */
	@Override
	public String validate(String password) {
		if (password.matches(PASSWORD_LETTERS_DIGITS_PATTERN)){
			return null;
		} else {
			return INVALID_LETTERS_DIGITS_ERROR_MSG;
		}			
	}

}
