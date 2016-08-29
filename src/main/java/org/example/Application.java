package org.example;

import org.example.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import java.util.Locale;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Parser.class);


	@Autowired
	public static void main (String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner app(ApplicationContext context, Parser parser) {
		return args -> {
			Locale defaultLocale = Locale.getDefault();
			Locale.setDefault(defaultLocale);

			MessageSource messageSource = context.getBean(MessageSource.class);

			log.info(messageSource.getMessage("my.message.code", null, Locale.getDefault()));

			parser.parse();

		};
	}
}
