package com.chtrembl.petstore.order.service;

import com.chtrembl.petstore.order.model.Order;
import com.chtrembl.petstore.order.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Yevhen_Voroniuk
 */
@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;

  public Order getOrder(String id) {
    var res = orderRepository.getOrder(id);
    if (res == null) {
      res = new Order();
    }
    return res;
  }

  public void saveOrder(Order order) {
    orderRepository.saveOrder(order);
  }
}
