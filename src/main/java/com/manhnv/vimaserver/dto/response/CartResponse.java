package com.manhnv.vimaserver.dto.response;

import lombok.Data;

import java.util.List;
@Data
public class CartResponse {
    private List<TicketResponse> tickets;
}
