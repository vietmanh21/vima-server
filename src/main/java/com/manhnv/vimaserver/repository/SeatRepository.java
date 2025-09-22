package com.manhnv.vimaserver.repository;

import com.manhnv.vimaserver.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<Seat> findBySeatCodeAndIsReservedIsFalse(String seatCode);
}
