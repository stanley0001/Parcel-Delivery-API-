package com.stan.parcel.Services;

import com.stan.parcel.Percistance.Entities.Configurations;
import com.stan.parcel.Repositories.ConfigurationRepo;
import com.stan.parcel.ServiceImplementation.ConfigurationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {
    private final ConfigurationRepo configurationRepo;

    public ConfigurationServiceImpl(ConfigurationRepo configurationRepo) {
        this.configurationRepo = configurationRepo;
    }

    public Configurations createConfiguration(Configurations configuration){
        return configurationRepo.save(configuration);
    }
    public List<Configurations> getConfigurations(){
        return configurationRepo.findAll();
    }
}
