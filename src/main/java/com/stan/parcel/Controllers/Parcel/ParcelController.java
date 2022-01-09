package com.stan.parcel.Controllers.Parcel;

import com.stan.parcel.Percistance.Entities.Parcel;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.ServiceImplementation.ParcelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parcel")
public class ParcelController {
    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }
    @PostMapping("/createParcel")
    public ResponseEntity<ResponseModel> createParcel(@RequestBody Parcel parcel){
        ResponseModel response=parcelService.createParcel(parcel);

        return new ResponseEntity<>(response,response.getStatus());
    }
    @GetMapping("getAllParcels")
    public ResponseEntity<List<Parcel>> getParcels(){
        List<Parcel> parcels=parcelService.getAllParcels();

        return new ResponseEntity<>(parcels, HttpStatus.OK);
    }
    @GetMapping("/getParcel{id}")
    public ResponseEntity<Parcel> getParcel(@PathVariable Long id){
        Parcel parcel=parcelService.getParcelById(id);

        return new ResponseEntity<>(parcel,HttpStatus.OK);
    }
    @GetMapping("/getBySenser{id}")
    public ResponseEntity<List<Parcel>> getParcelBySender(@PathVariable Long id){
        List<Parcel> parcel=parcelService.findBySenderId(id);

        return new ResponseEntity<>(parcel,HttpStatus.OK);
    }
}
