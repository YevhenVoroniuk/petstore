package com.chtrembl.petstore.order.config.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "cosmos-db")
@NoArgsConstructor
public class CosmosDbProperties {
  private String uri;
  private String key;
  private String database;
}