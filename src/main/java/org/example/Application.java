package org.example;

import org.example.parser.Parser;
import org.example.services.MessagingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import java.util.Locale;

@SpringBootApplication
public class Application {

    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    MessagingService messagingService;
    @Autowired
    Parser parser;

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main (String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner app() {
        return args -> {
            Locale defaultLocale = Locale.getDefault();
            Locale.setDefault(defaultLocale);
            log.info("Using MessagingService: " + messagingService.getMyMessageCode());

            parser.parse();
        };
    }
}