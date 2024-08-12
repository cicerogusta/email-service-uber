package com.cicerodev.email_service_uber.infra.ses

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AwsConfig {
    @Bean
    fun amazonSimpleEmailService(): AmazonSimpleEmailService {
        return AmazonSimpleEmailServiceClientBuilder.standard().build()
    }
}