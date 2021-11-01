/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.dvdstore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author Steve KOUNA
 */
@Configuration
@ComponentScan(basePackages = {
    "com.koona.dvdstore.controller",
    "com.koona.dvdstore.service",
    "com.koona.dvdstore.repository.file"
})
@PropertySource("classpath:application.properties")
public class AppConfig {
    
}
