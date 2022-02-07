package com.stan.parcel.Services.Communication;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.Configuration;
import com.infobip.api.SendSmsApi;
import com.infobip.model.*;
import com.stan.parcel.Percistance.Entities.Message;
import com.stan.parcel.Percistance.Model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class InfoBidApiService {
    public void auth(){
        ApiClient apiClient = new ApiClient();
        apiClient.setApiKeyPrefix("App");
        apiClient.setApiKey(System.getenv().get("SMSsecret"));
        apiClient.setBasePath(System.getenv().get("SMSbaseUrl"));
        Configuration.setDefaultApiClient(apiClient);
    }


    public ResponseModel send(Message message){
        ResponseModel responseModel=new ResponseModel();
        this.auth();

        SendSmsApi sendSmsApi = new SendSmsApi();
        SmsResponse response=null;
        SmsTextualMessage smsMessage = new SmsTextualMessage()
                .from("STAN")
                .addDestinationsItem(new SmsDestination().to(message.getRecipient()))
                .text(message.getMessage());

        SmsAdvancedTextualRequest smsMessageRequest = new SmsAdvancedTextualRequest().messages(
                Collections.singletonList(smsMessage)
        );

        //sending
        try {

            response = sendSmsApi.sendSmsMessage(smsMessageRequest);
            //log.info("sent message {}",response);
        } catch (ApiException apiException) {
            // HANDLE THE EXCEPTION
            //log.info("Errors code {}, header {}, body{} ", apiException.getCode(),apiException.getResponseHeaders(),apiException.getResponseBody());
        }
        String reason;
       if (response==null){
           responseModel.setMessage("Network Error");
           responseModel.setStatus(HttpStatus.BAD_GATEWAY);
           reason="FAILED";
       }else{
           responseModel.setMessage(" Passes to API");
           responseModel.setStatus(HttpStatus.OK);
           reason=response.toString();
       }
        responseModel.setReason(reason);
        return responseModel;
    }

    public void getStatus(String bulkId, String messageId, int limit) throws ApiException {
        this.auth();

        SendSmsApi sendSmsApi = new SendSmsApi();
        Integer numberOfReportsLimit = 10;
        //log.info("Getting status");
        SmsDeliveryResult deliveryReports = sendSmsApi.getOutboundSmsMessageDeliveryReports(bulkId, messageId, numberOfReportsLimit);

        for (SmsReport report : deliveryReports.getResults()) {
            System.out.println(report.getMessageId() + " - " + report.getStatus().getName());
        }
       // log.info("Status check complete");
        //return sendSmsApi.getOutboundSmsMessageDeliveryReports(bulkId,messageId,limit);
    }
}

