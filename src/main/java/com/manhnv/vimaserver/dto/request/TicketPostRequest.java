package com.manhnv.vimaserver.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketPostRequest {
    private String seatCode;
    private String tripId;
    private String boardingPoint;
    private String dropoffPoint;
}
