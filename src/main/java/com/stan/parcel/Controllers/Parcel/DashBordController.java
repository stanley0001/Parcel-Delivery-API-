package com.stan.parcel.Controllers.Parcel;

import com.stan.parcel.Percistance.Entities.Configurations;
import com.stan.parcel.Percistance.Model.ParcelForm;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.ServiceImplementation.ConfigurationService;
import com.stan.parcel.ServiceImplementation.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dash")
public class DashBordController {
    public final DashboardService dashboardService;
    public final ConfigurationService configurationService;

    public DashBordController(DashboardService dashboardService, ConfigurationService configurationService) {
        this.dashboardService = dashboardService;
        this.configurationService = configurationService;
    }
    @PostMapping("SendParcel")
    public ResponseEntity<ResponseModel> parcelForm(@RequestBody ParcelForm parcelForm){
        ResponseModel response=dashboardService.sendParcel(parcelForm);

        return new ResponseEntity<>(response,response.getStatus());
    }
    @PostMapping("/createConfiguration")
    public ResponseEntity<Configurations> createConfig(@RequestBody Configurations configuration){
        Configurations configuration1=configurationService.createConfiguration(configuration);

        return new ResponseEntity<>(configuration1, HttpStatus.OK);
    }
    @GetMapping("getConfigs")
    public ResponseEntity<List<Configurations>> getConfigs(){
        List<Configurations> configurations=configurationService.getConfigurations();

        return new ResponseEntity<>(configurations,HttpStatus.OK);
    }
}
