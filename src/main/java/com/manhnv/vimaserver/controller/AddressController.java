package com.manhnv.vimaserver.controller;

import com.manhnv.vimaserver.common.CommonResult;
import com.manhnv.vimaserver.dto.request.AddressPostRequest;
import com.manhnv.vimaserver.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    public CommonResult createAddress(@Valid @RequestBody AddressPostRequest request) {
        return CommonResult.success(addressService.createAddress(request));
    }

    @GetMapping("/list")
    public CommonResult listAddresses() {
        return CommonResult.success(addressService.getList());
    }
}
