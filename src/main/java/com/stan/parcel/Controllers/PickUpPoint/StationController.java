package com.stan.parcel.Controllers.PickUpPoint;

import com.stan.parcel.Percistance.Entities.Parcel;
import com.stan.parcel.Percistance.Entities.PickupStation;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.ServiceImplementation.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationController {
    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }
    @PostMapping("createStation")
    public ResponseEntity<ResponseModel> createStation(@RequestBody PickupStation station){
        ResponseModel response=stationService.createStation(station);

        return new ResponseEntity<>(response,response.getStatus());
    }
    @GetMapping("/allStations")
    public ResponseEntity<List<PickupStation>> getAllStations(){
        List<PickupStation> stations=stationService.getStations();
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }
}
