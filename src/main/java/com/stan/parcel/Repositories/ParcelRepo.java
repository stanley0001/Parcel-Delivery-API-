package com.stan.parcel.Repositories;

import com.stan.parcel.Percistance.Entities.Client;
import com.stan.parcel.Percistance.Entities.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ParcelRepo extends JpaRepository<Parcel, Long> {
    Optional<List<Parcel>> findParcelsBySender(Client client);

    Set<Parcel> findBySenderId(Long id);

    Set<Parcel> findParcelsByRecipientId(Long id);
}
