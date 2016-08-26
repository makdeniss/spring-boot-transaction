package org.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * User: Deniss Makarenkov
 * Date: 26.08.2016
 * Time: 14:36
 */
@Configuration
@ConfigurationProperties(prefix = "custom")
public class CustomProperties {

	private String property;

	public String getProperty () {
		return property;
	}

	public void setProperty (String property) {
		this.property = property;
	}
}
