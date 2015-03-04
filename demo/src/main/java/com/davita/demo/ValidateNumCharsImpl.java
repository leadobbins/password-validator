/**
 * 
 */
package com.davita.demo;

/**
 * @author ladobbins
 *
 */
public class ValidateNumCharsImpl implements ValidatorInterface {

	private static final String INVALID_NUM_CHARS_ERROR_MSG = "must be between 5 and 12 characters in length";

	/* (non-Javadoc)
	 * @see com.davita.demo.ValidatorInterface#validate(java.lang.String)
	 */
	@Override
	public String validate(String password) {
		if ((password.length() < 5) || (password.length() > 12)) {
			return INVALID_NUM_CHARS_ERROR_MSG;
		} else {
			return null;
		}
	}

}
