package com.chtrembl.petstore.order.repo;

import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosException;
import com.azure.cosmos.implementation.HttpConstants;
import com.azure.cosmos.models.PartitionKey;
import com.chtrembl.petstore.order.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author Yevhen_Voroniuk
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepository {


  private final CosmosContainer ordersContainer;

  public Order getOrder(String id) {
    try {
      return ordersContainer.readItem(id, new PartitionKey(id), Order.class).getItem();
    } catch (CosmosException ex) {
      if (ex.getStatusCode() == HttpConstants.StatusCodes.NOTFOUND) {
        return null;
      }
      throw ex;
    }
  }

  public void saveOrder(Order order) {
    ordersContainer.upsertItem(order);
    log.info("Saved order: {}", order.getId());
  }
}
