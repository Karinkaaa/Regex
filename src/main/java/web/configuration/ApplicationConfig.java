package main.java.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"main.java.web.controller", "main.java.web.components"})
public class ApplicationConfig {
}
