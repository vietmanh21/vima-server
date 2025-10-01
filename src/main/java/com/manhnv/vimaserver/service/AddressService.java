package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.dto.request.AddressPostRequest;
import com.manhnv.vimaserver.model.Address;
import com.manhnv.vimaserver.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    public Address createAddress(AddressPostRequest request) {
        Address address = new Address();
        address.setAddressLine(request.getAddressLine());
        address.setStateOrProvince(request.getStateOrProvince());
        return addressRepository.save(address);
    }

    public List<Address> getList() {
        return addressRepository.findAll();
    }
}
