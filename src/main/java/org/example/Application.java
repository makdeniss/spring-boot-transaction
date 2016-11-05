package org.example;

import org.example.data.admin.CustomerRepository;
import org.example.data.local.ProductRepository;
import org.example.parser.Parser;
import org.example.services.MessagingService;
import org.example.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final TransactionRunner transactionRunner;

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    public Application(TransactionRunner transactionRunner){
        this.transactionRunner = transactionRunner;

    }

    public static void main (String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        transactionRunner.go();

    }
}