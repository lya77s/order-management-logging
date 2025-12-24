package com.example.ordermanagement.service;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.exception.InvalidOrderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Logger logger =
            LoggerFactory.getLogger(OrderService.class);

    public void createOrder(Order order) {

        logger.info("Тапсырыс қабылданды. ID: {}", order.getId());
        logger.debug("Тапсырыс деректері: {}", order);

        if (order.getQuantity() <= 0) {
            logger.warn("Қате quantity! ID: {}, quantity: {}",
                    order.getId(), order.getQuantity());

            throw new InvalidOrderException(
                    "Quantity нөлден үлкен болуы керек. ID: " + order.getId()
            );
        }

        if (order.getPrice() < 0) {
            logger.error("Баға теріс мән! ID: {}", order.getId());

            throw new InvalidOrderException(
                    "Price теріс болмауы керек. ID: " + order.getId()
            );
        }

        logger.info("Тапсырыс сәтті өңделді. ID: {}", order.getId());
    }
}
