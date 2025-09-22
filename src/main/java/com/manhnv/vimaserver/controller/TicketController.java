package com.manhnv.vimaserver.controller;

import com.manhnv.vimaserver.common.CommonResult;
import com.manhnv.vimaserver.dto.request.TicketPostRequest;
import com.manhnv.vimaserver.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public CommonResult createTicket(@Valid @RequestBody TicketPostRequest ticketPostRequest) {
        return CommonResult.success(ticketService.createTicket(ticketPostRequest));
    }
}
