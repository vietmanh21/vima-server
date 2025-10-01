package com.falcon.serveradmin.dto.request;

import com.falcon.serverdb.model.enumeration.TripType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class CreateTripRequest {
    @NotBlank
    private String licensePlate;
    @NotNull
    private TripType tripType;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Date startTime;
    @NotNull
    private Date endTime;
    @NotNull
    private Long departurePointId;
    @NotNull
    private Long destinationPointId;
}
