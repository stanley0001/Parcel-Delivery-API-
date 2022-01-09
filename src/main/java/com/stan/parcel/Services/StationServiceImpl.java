package com.stan.parcel.Services;

import com.stan.parcel.Percistance.Entities.PickupStation;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.Repositories.StationRepo;
import com.stan.parcel.ServiceImplementation.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {
    private final StationRepo stationRepo;

    public StationServiceImpl(StationRepo stationRepo) {
        this.stationRepo = stationRepo;
    }

    public ResponseModel createStation(PickupStation station){
        ResponseModel response=new ResponseModel();
         stationRepo.save(station);
         response.setStatus(HttpStatus.CREATED);
         response.setMessage("Station Created");
        return response;
    }
    public List<PickupStation> getStations(){
        return stationRepo.findAll();
    }

    public Optional<PickupStation> findById(Long destinationId) {
        return Optional.of(stationRepo.findById(destinationId).get());
    }
}
