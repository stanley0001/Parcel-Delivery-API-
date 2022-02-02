package com.stan.parcel.Repositories;

import com.stan.parcel.Percistance.Entities.Configurations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepo extends JpaRepository<Configurations,Long> {
}
