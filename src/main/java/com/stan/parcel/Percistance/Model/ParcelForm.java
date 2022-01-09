package com.stan.parcel.Percistance.Model;

public class ParcelForm {
    private String senderName;
    private String senderPhone;
    private String senderDocumentNumber;
    private String senderEmail;
    private String recipientName;
    private String recipientPhone;
    private String recipientDocumentNumber;
    private String recipientEmail;
    private String parcelContent;
    private String parcelDescription;
    private String weight;
    private Double charges;
    private Long originatingId;
    private Long destinationId;
    private Long addedBy;

    public ParcelForm() {
    }

    public ParcelForm(String senderName) {
        this.senderName = senderName;
    }

    public ParcelForm(String senderName, String senderPhone, String senderDocumentNumber, String senderEmail, String recipientName, String recipientPhone, String recipientDocumentNumber, String recipientEmail, String parcelContent, String parcelDescription, String weight, Double charges, Long originatingId, Long destinationId, Long addedBy) {
        this.senderName = senderName;
        this.senderPhone = senderPhone;
        this.senderDocumentNumber = senderDocumentNumber;
        this.senderEmail = senderEmail;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
        this.recipientDocumentNumber = recipientDocumentNumber;
        this.recipientEmail = recipientEmail;
        this.parcelContent = parcelContent;
        this.parcelDescription = parcelDescription;
        this.weight = weight;
        this.charges = charges;
        this.originatingId = originatingId;
        this.destinationId = destinationId;
        this.addedBy = addedBy;
    }

    public String getParcelDescription() {
        return parcelDescription;
    }

    public void setParcelDescription(String parcelDescription) {
        this.parcelDescription = parcelDescription;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderDocumentNumber() {
        return senderDocumentNumber;
    }

    public void setSenderDocumentNumber(String senderDocumentNumber) {
        this.senderDocumentNumber = senderDocumentNumber;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipientDocumentNumber() {
        return recipientDocumentNumber;
    }

    public void setRecipientDocumentNumber(String recipientDocumentNumber) {
        this.recipientDocumentNumber = recipientDocumentNumber;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getParcelContent() {
        return parcelContent;
    }

    public void setParcelContent(String parcelContent) {
        this.parcelContent = parcelContent;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    public Long getOriginatingId() {
        return originatingId;
    }

    public void setOriginatingId(Long originatingId) {
        this.originatingId = originatingId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public Long getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Long addedBy) {
        this.addedBy = addedBy;
    }

    @Override
    public String toString() {
        return "ParcelForm{" +
                "senderName='" + senderName + '\'' +
                ", senderPhone='" + senderPhone + '\'' +
                ", senderDocumentNumber='" + senderDocumentNumber + '\'' +
                ", senderEmail='" + senderEmail + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", recipientPhone='" + recipientPhone + '\'' +
                ", recipientDocumentNumber='" + recipientDocumentNumber + '\'' +
                ", recipientEmail='" + recipientEmail + '\'' +
                ", parcelContent='" + parcelContent + '\'' +
                ", parcelDescription='" + parcelDescription + '\'' +
                ", weight='" + weight + '\'' +
                ", charges=" + charges +
                ", originatingId=" + originatingId +
                ", destinationId=" + destinationId +
                ", addedBy=" + addedBy +
                '}';
    }
}
