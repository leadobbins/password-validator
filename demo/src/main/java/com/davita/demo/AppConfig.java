/**
 * 
 */
package com.davita.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Annotation based configuration class for Spring context
 * 
 * This can be imported into another Spring project using @Import
 * this will make all of these beans available to other beans in another
 * Spring configuration.  This can also be used in XML configuration -
 * see the spring documentation on how to do this.
 * 
 * @author ladobbins
 *
 */
@Configuration
public class AppConfig {
	
	@Bean
	public ValidatorInterface validateNumChars() {
		return new ValidateNumCharsImpl();
	}
	
	@Bean
	public ValidatorInterface validateLettersDigits() {
		return new ValidateLettersDigitsImpl();
	}
	
	@Bean
	public ValidatorInterface validateRepeatingSequence() {
		return new ValidateRepeatingSequenceImpl();
	}
	
	@Bean
	public PasswordValidationService passwordValidationService() {
		return new PasswordValidationService();
	}

}
