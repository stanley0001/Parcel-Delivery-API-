package com.stan.parcel.Repositories;

import com.stan.parcel.Percistance.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client,Long> {
    Optional<Client> findBydocumentNumber(String documentNumber);

    Optional<Client> findClientByPhone(String phone);
}
