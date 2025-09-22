package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.dto.request.OrderPostRequest;
import com.manhnv.vimaserver.model.Order;
import com.manhnv.vimaserver.model.Ticket;
import com.manhnv.vimaserver.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    private Order createOrder(OrderPostRequest orderRequest) {
        Order order = Order.builder()
                .totalPrice(orderRequest.getTotalPrice())
                .paymentStatus(orderRequest.getPaymentStatus())
                .paymentStatus(orderRequest.getPaymentStatus())

                .build();

        Set<Ticket> tickets = orderRequest.getTickets().stream().map(ticketRequest -> Ticket.builder()
                .boardingPoint(ticketRequest.getBoardingPoint())
                .dropoffPoint(ticketRequest.getDropoffPoint())
//                .seatCode(ticketRequest.getSeatCode())
                .build()).collect(java.util.stream.Collectors.toSet());
        return orderRepository.save(order);
    }
}
