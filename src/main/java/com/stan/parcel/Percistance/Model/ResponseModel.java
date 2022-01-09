package com.stan.parcel.Percistance.Model;

import org.springframework.http.HttpStatus;

public class ResponseModel {

    private HttpStatus status;
    private String message;
    private String reason;
    private String error;

    public ResponseModel() {
    }

    public ResponseModel(HttpStatus status, String message, String reason, String error) {
        this.status = status;
        this.message = message;
        this.reason = reason;
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", reason='" + reason + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
