package com.stan.parcel.ServiceImplementation;

import com.stan.parcel.Percistance.Entities.Configurations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConfigurationService {
    Configurations createConfiguration(Configurations configuration);

    List<Configurations> getConfigurations();
}
