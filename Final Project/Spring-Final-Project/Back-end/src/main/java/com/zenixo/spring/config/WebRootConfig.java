package com.zenixo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Configuration
@Import({JPAConfig.class})
public class WebRootConfig {

}
