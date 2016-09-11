package org.example.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * User: Deniss Makarenkov
 * Date: 30.08.2016
 * Time: 13:14
 *
 * Makes Autowiring simple.
 */

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {
}
