package com.performance.example.base.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The configuration class to scan all beans under given component scan. This
 * can be further used to instantiate various resources used as per the project
 * need.
 */
@Configuration
@ComponentScan(basePackages = "com.performance")
public class BaseConfig {

}
