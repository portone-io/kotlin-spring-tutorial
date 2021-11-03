package com.example.demo

import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator
import org.springframework.stereotype.Component

@Configuration
class ConnectionFactorySetup  {

    @Bean
    fun initializer(connectionFactory: ConnectionFactory): ConnectionFactoryInitializer =
        ConnectionFactoryInitializer()
            .apply {
                setConnectionFactory(connectionFactory)
                setDatabasePopulator(ResourceDatabasePopulator(ClassPathResource("schema.sql")))
            }
}