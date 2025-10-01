package com.manhnv.vimaserver.dto.request;

import com.manhnv.vimaserver.model.enumeration.PaymentMethod;
import com.manhnv.vimaserver.model.enumeration.PaymentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderPostRequest {
    @NotNull
    private BigDecimal totalPrice;

    @NotNull
    PaymentMethod paymentMethod;
    @NotNull
    PaymentStatus paymentStatus;

    private List<TicketPostRequest> tickets;
}
