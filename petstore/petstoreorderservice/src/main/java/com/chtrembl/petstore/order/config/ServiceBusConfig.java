package com.chtrembl.petstore.order.config;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yevhen_Voroniuk
 */
@Configuration
public class ServiceBusConfig {

  @Value("${service-bus.connection-string}")
  private String connectionString;

  @Value("${service-bus.order-placed-queue-name}")
  private String reservationQueueName;

  @Bean
  public ServiceBusSenderClient orderPlacedSender() {
    return new ServiceBusClientBuilder()
        .connectionString(connectionString)
        .sender()
        .queueName(reservationQueueName)
        .buildClient();
  }
}
