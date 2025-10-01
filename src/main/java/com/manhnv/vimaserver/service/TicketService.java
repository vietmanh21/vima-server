package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.dto.request.TicketPostRequest;
import com.manhnv.vimaserver.dto.response.TicketResponse;
import com.manhnv.vimaserver.exception.ApiException;
import com.manhnv.vimaserver.model.Cart;
import com.manhnv.vimaserver.model.Seat;
import com.manhnv.vimaserver.model.Ticket;
import com.manhnv.vimaserver.repository.CartRepository;
import com.manhnv.vimaserver.repository.SeatRepository;
import com.manhnv.vimaserver.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;
    private final CartService cartService;

    public TicketResponse createTicket(TicketPostRequest ticketRequest) {
        Seat seat = seatRepository.findBySeatCodeAndIsReservedIsFalse(ticketRequest.getSeatCode())
                .orElseThrow(() -> new ApiException("Seat not found or already reserved"));
        seat.setIsReserved(true);
        seatRepository.save(seat);
        Cart cart = cartService.createCart();
        Ticket ticket = Ticket.builder()
                .boardingPoint(ticketRequest.getBoardingPoint())
                .dropoffPoint(ticketRequest.getDropoffPoint())
                .seat(seat).cart(cart).build();
        Ticket newTicket = ticketRepository.save(ticket);
        return TicketResponse.toResponse(newTicket);
    }
}
