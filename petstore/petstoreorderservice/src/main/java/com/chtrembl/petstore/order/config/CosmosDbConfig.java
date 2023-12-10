package com.chtrembl.petstore.order.config;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;
import com.chtrembl.petstore.order.config.properties.CosmosDbProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yevhen_Voroniuk
 */
@Configuration
public class CosmosDbConfig {

  private static final String ORDERS_CONTAINER = "orders";

  @Bean
  public CosmosClient cosmosClient(CosmosDbProperties properties) {
    return new CosmosClientBuilder()
        .endpoint(properties.getUri())
        .key(properties.getKey())
        .buildClient();
  }

  @Bean
  public CosmosDatabase cosmosDatabase(CosmosClient cosmosClient, CosmosDbProperties properties) {
    return cosmosClient.getDatabase(properties.getDatabase());
  }

  @Bean
  public CosmosContainer ordersContainer(CosmosDatabase cosmosDatabase) {
    return cosmosDatabase.getContainer(ORDERS_CONTAINER);
  }
}
