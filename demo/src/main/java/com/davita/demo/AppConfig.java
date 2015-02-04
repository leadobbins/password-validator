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
	public ValidatorUtils validatorUtils() {
		return new ValidatorUtils();
	}
	
	@Bean
	public PasswordValidationService passwordValidationService() {
		return new PasswordValidationService();
	}

}
