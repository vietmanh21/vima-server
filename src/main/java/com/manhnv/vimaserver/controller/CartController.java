package com.manhnv.vimaserver.controller;

import com.manhnv.vimaserver.common.CommonResult;
import com.manhnv.vimaserver.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/get-all")
    public CommonResult getAllCart() {
        return CommonResult.success(cartService.getAllTicketsInCart());
    }
}
