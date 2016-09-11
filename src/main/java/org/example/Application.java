package org.example;

import org.example.data.admin.CustomerRepository;
import org.example.data.local.ProductRepository;
import org.example.domain.admin.Customer;
import org.example.domain.local.Product;
import org.example.parser.Parser;
import org.example.services.MessagingService;
import org.example.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public Application() {}

    public static void main (String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner app(MessagingService messagingService, Parser parser,
                                 CustomerRepository customerRepository, ProductRepository productRepository,
                                 TransactionService transactionService) {
        return args -> {

            Locale defaultLocale = Locale.getDefault();
            Locale.setDefault(defaultLocale);
            parser.parse();

            Customer denissCustomer = customerRepository.findByName("Deniss");

            Customer oksanaCustomer = customerRepository.findByName("Oksana");

            transactionService.makeTransactionFromSenderToReceiver(denissCustomer, oksanaCustomer, 50);
            log.info(messagingService.getCustomer() + " " + denissCustomer.getName() + " "
                                                            + messagingService.getHasBalanceInAmount() + " "
                                                                + denissCustomer.getBalance());
        };
    }
}