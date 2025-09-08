package com.manhnv.vimaserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "booking")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DBBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
