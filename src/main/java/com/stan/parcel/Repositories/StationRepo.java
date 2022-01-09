package com.stan.parcel.Repositories;

import com.stan.parcel.Percistance.Entities.PickupStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepo extends JpaRepository<PickupStation,Long> {
}
