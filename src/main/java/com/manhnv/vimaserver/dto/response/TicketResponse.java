package com.manhnv.vimaserver.dto.response;

import com.manhnv.vimaserver.model.Ticket;
import com.manhnv.vimaserver.model.enumeration.TicketStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class TicketResponse {
    private String boardingPoint;
    private String dropoffPoint;
    private TicketStatus status;
    private String seatCode;
    private Instant startTime;

    private Instant endTime;

    private BigDecimal price;

    public static TicketResponse toResponse(Ticket ticket) {
        return TicketResponse.builder().boardingPoint(ticket.getBoardingPoint())
                .dropoffPoint(ticket.getDropoffPoint())
                .status(ticket.getStatus())
                .price(ticket.getSeat().getTrip().getPrice())
                .seatCode(ticket.getSeat().getSeatCode())
                .startTime(ticket.getSeat().getTrip().getStartTime())
                .endTime(ticket.getSeat().getTrip().getEndTime()).build();
    }
}
