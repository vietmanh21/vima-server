package com.manhnv.vimaserver.controller;

import com.manhnv.vimaserver.dto.response.TicketResponse;
import com.manhnv.vimaserver.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/get-all")
    public ResponseEntity<List<TicketResponse>> getAllCart() {
        return ResponseEntity.ok(cartService.getAllTicketsInCart());
    }
}
