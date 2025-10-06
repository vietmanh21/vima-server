package com.manhnv.vimaserver.mapper;

import com.manhnv.vimaserver.dto.response.TripResponse;
import com.manhnv.vimaserver.model.Trip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TripMapper extends BaseMapper<Trip, TripResponse> {
}
