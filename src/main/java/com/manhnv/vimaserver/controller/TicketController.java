package com.manhnv.vimaserver.controller;

import com.manhnv.vimaserver.dto.request.TicketPostRequest;
import com.manhnv.vimaserver.dto.response.TicketResponse;
import com.manhnv.vimaserver.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<TicketResponse> createTicket(@Valid @RequestBody TicketPostRequest ticketPostRequest) {
        return ResponseEntity.ok(ticketService.createTicket(ticketPostRequest));
    }
}
