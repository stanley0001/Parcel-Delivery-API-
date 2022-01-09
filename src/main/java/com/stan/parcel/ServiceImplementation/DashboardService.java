package com.stan.parcel.ServiceImplementation;

import com.stan.parcel.Percistance.Model.ParcelForm;
import com.stan.parcel.Percistance.Model.ResponseModel;
import org.springframework.stereotype.Service;

@Service
public interface DashboardService {
    ResponseModel sendParcel(ParcelForm parcelForm);
}
