package com.falcon.serveradmin.dto.response;

import com.falcon.serverdb.model.enumeration.TripStatus;
import com.falcon.serverdb.model.enumeration.TripType;
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
