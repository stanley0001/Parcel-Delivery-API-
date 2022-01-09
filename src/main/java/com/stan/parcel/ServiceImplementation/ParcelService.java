package com.stan.parcel.ServiceImplementation;

import com.stan.parcel.Percistance.Entities.Parcel;
import com.stan.parcel.Percistance.Model.ResponseModel;

import java.util.List;

public interface ParcelService {
    ResponseModel createParcel(Parcel parcel);

    List<Parcel> getAllParcels();

    Parcel getParcelById(Long id);

    List<Parcel> findBySenderId(Long id);
}
