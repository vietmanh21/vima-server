package com.manhnv.vimaserver.controller;

import com.manhnv.vimaserver.dto.request.AddressPostRequest;
import com.manhnv.vimaserver.model.Address;
import com.manhnv.vimaserver.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<Address> createAddress(@Valid @RequestBody AddressPostRequest request) {
        return ResponseEntity.ok(addressService.createAddress(request));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getList());
    }
}
