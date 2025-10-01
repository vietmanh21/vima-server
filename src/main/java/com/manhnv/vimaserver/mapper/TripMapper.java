package com.falcon.serveradmin.mapper;

import com.falcon.serveradmin.dto.response.TripResponse;
import com.falcon.serverdb.model.Trip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TripMapper extends BaseMapper<Trip, TripResponse> {

}
