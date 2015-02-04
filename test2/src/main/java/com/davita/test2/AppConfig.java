/**
 * 
 */
package com.davita.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ladobbins
 *
 */
@Configuration
@Import(com.davita.demo.AppConfig.class)
public class AppConfig {
	
	@Bean
	public App app() {
		return new App();
	}
}
