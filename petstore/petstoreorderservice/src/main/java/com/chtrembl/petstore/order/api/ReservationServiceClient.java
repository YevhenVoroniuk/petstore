package com.chtrembl.petstore.order.api;

import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Yevhen_Voroniuk
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationServiceClient {

  private final ServiceBusSenderClient orderPlacedSender;

  public void reserve(String order, String sessionId) {
    log.info("Reserving order: {} for sessionId: {}", order, sessionId);

    var message = new ServiceBusMessage(order);
    message.setSubject(sessionId);

    orderPlacedSender.sendMessage(message);
  }
}
