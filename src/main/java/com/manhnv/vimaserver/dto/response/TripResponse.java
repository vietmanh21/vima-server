package com.manhnv.vimaserver.dto.response;

import com.manhnv.vimaserver.model.enumeration.TripStatus;
import com.manhnv.vimaserver.model.enumeration.TripType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class TripResponse {
    private String id;
    private String licensePlate;
    private TripType tripType;
    private BigDecimal price;
    private Instant startTime;
    private Instant endTime;
    private AddressResponse departurePoint;
    private AddressResponse destinationPoint;
    private TripStatus tripStatus;
}
