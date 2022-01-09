package com.stan.parcel.Controllers.Parcel;

import com.stan.parcel.Percistance.Model.ParcelForm;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.ServiceImplementation.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dash")
public class DashBordController {
    public final DashboardService dashboardService;

    public DashBordController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }
    @PostMapping("SendParcel")
    public ResponseEntity<ResponseModel> parcelForm(@RequestBody ParcelForm parcelForm){
        ResponseModel response=dashboardService.sendParcel(parcelForm);

        return new ResponseEntity<>(response,response.getStatus());
    }
}
