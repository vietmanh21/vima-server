package com.falcon.serveradmin.service;

import com.falcon.serveradmin.dto.request.CreateTripRequest;
import com.falcon.serveradmin.dto.response.TripResponse;
import com.falcon.serveradmin.mapper.TripMapper;
import com.falcon.serveradmin.repository.AddressRepository;
import com.falcon.serveradmin.repository.SeatRepository;
import com.falcon.serveradmin.repository.TripRepository;
import com.falcon.serveradmin.utils.Constants;
import com.falcon.servercommon.exception.ApiException;
import com.falcon.serverdb.model.Seat;
import com.falcon.serverdb.model.Trip;
import com.falcon.serverdb.model.enumeration.TripType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;
    private final AddressRepository addressRepository;
    private final SeatRepository seatRepository;
    private final TripMapper tripMapper;

    public TripResponse createTrip(CreateTripRequest request) {
        Trip trip = new Trip();
        trip.setLicensePlate(request.getLicensePlate());
        trip.setStartTime(request.getStartTime().toInstant());
        trip.setEndTime(request.getEndTime().toInstant());
        trip.setPrice(request.getPrice());
        trip.setTripType(request.getTripType());
        trip.setDeparturePoint(addressRepository.findById(request.getDeparturePointId()).orElseThrow(() -> new ApiException("điểm xuất phát ko tồn tại")));
        trip.setDestinationPoint(addressRepository.findById(request.getDestinationPointId()).orElseThrow(() -> new ApiException("Điểm đến ko tồn tại")));

        Trip savedTrip = tripRepository.save(trip);
        // now create all the individual seats
        List<Seat> seats = new ArrayList<>();
        if (TripType.VIP24 == request.getTripType()) {
            for (String code : Constants.seatCodeVip24) {
                Seat seat = new Seat();
                seat.setSeatCode(code);
                seat.setTrip(savedTrip);
                seats.add(seat);
            }
        } else if (TripType.VIP34 == request.getTripType()) {
            for (String code : Constants.seatCodeVip34) {
                Seat seat = new Seat();
                seat.setSeatCode(code);
                seat.setTrip(savedTrip);
                seats.add(seat);
            }
        }

        seatRepository.saveAll(seats);

        return tripMapper.toResponse(trip);
    }
}
