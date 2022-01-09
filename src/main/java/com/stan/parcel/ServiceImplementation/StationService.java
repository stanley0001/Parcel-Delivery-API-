package com.stan.parcel.ServiceImplementation;

import com.stan.parcel.Percistance.Entities.PickupStation;
import com.stan.parcel.Percistance.Model.ResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StationService {
    ResponseModel createStation(PickupStation station);


    List<PickupStation> getStations();
}
