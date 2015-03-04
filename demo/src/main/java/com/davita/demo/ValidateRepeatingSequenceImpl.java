/**
 * 
 */
package com.davita.demo;

/**
 * @author ladobbins
 *
 */
public class ValidateRepeatingSequenceImpl implements ValidatorInterface {

	private static final String REPEAT_PATTERN = "(?!(.+?)\\1).*";
	private static final String INVALID_REPEAT_SEQ_ERROR_MSG = "must not contain any sequence of characters immediately followed by the same sequence";

	/* (non-Javadoc)
	 * @see com.davita.demo.ValidatorInterface#validate(java.lang.String)
	 */
	@Override
	public String validate(String password) {
		String returnString = null;
		if (password.matches(REPEAT_PATTERN)) {
			if (password.length() > 3) {
				// Recurse through since the regular expression only checks from
				// the beginning of the password
				returnString = validate(password.substring(1));
			} 
		} else {
			returnString = INVALID_REPEAT_SEQ_ERROR_MSG;
		}
		return returnString;
	}

}
