package com.manhnv.vimaserver.dto.response;

import com.manhnv.vimaserver.model.Address;
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
    private Address departurePoint;
    private Address destinationPoint;
    private TripStatus tripStatus;
}
