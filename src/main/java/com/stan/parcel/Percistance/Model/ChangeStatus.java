package com.stan.parcel.Percistance.Model;

public class ChangeStatus {
    private Long parcelId;
    private String Status;

    public ChangeStatus() {
    }

    public ChangeStatus(Long parcelId, String status) {
        this.parcelId = parcelId;
        Status = status;
    }

    public Long getParcelId() {
        return parcelId;
    }

    public void setParcelId(Long parcelId) {
        this.parcelId = parcelId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "ChangeStatus{" +
                "parcelId=" + parcelId +
                ", Status='" + Status + '\'' +
                '}';
    }
}
