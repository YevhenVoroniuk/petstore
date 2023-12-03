package com.chtrembl.petstore.order.api;

import com.chtrembl.petstore.order.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yevhen_Voroniuk
 */
@Service
@Slf4j
public class ReservationServiceClient {
  @Value("${petstore.service.reservation.url:}")
  private String reservationServiceURL;

  @Autowired
  private RestTemplate restTemplate;

  public void reserve(String order, String sessionId) {
    var request = new HttpEntity<>(order);

    log.info("Reserving order: {} for sessionId: {}", order, sessionId);
    var response = restTemplate.postForEntity(String.format("%s/api/reserve?sessionId=%s",
            this.reservationServiceURL, sessionId), request, String.class);

    if (response.getStatusCode().is2xxSuccessful()) {
      log.info("Reservation successful");
    } else {
      log.error("Reservation failed with response code: {}", response.getStatusCode());
    }
  }
}
