package main.java.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"main.java.web.controller", "main.java.web.components"})
@PropertySource(value = {"classpath://regex.properties"})
public class ApplicationConfig {
}
