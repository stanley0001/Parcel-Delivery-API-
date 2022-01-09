package com.stan.parcel.Repositories;

import com.stan.parcel.Percistance.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    List<Message> findByStatus(String aNew);
}
