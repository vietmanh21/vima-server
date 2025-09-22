package com.manhnv.vimaserver.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressPostRequest {
    @NotBlank
    private String addressLine;

    @NotBlank
    private String stateOrProvince;

}
