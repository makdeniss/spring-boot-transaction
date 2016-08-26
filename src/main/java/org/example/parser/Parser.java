package org.example.parser;

import org.example.properties.CustomProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * User: Deniss Makarenkov
 * Date: 26.08.2016
 * Time: 14:39
 *
 * Parser that implements custom property.
 */
@Service
@ComponentScan(basePackages = "{org.example.*}")
public class Parser {

	@Autowired
	private CustomProperties customProperties;

	private static final Logger log = LoggerFactory.getLogger(Parser.class);

	public void parse() {
		String propertyValue = customProperties.getProperty();
		log.info("Property value: " + propertyValue);

	}

}
