package com.stan.parcel.Percistance.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="parcel")
public class Parcel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long parcelId;
    private String parcelName;
    private String description;
    private String weight;
    private Double charges;
    private String Status;
    private Long senderId;
    private Long recipientId;
    private Long originationId;
    private Long destinationId;
    private Long addedBy;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "client_id",insertable = false,updatable = false)
    private Client sender;
    @ManyToOne
    @JoinColumn(name = "client_id",insertable = false,updatable = false)
    private Client recipient;
    @ManyToOne
    @JoinColumn(name = "pickup_station_id",insertable = false,updatable = false)
    private PickupStation originatingStation;
    @ManyToOne
    @JoinColumn(name = "pickup_station_id",insertable = false,updatable = false)
    private PickupStation destinationStation;
    public Parcel() {
    }

    public Parcel(Long parcelId) {
        this.parcelId = parcelId;
    }

    public Parcel(Long parcelId, String parcelName, String description, String weight, Double charges, String status, Long senderId, Long recipientId, Long originationId, Long destinationId, Long addedBy, Timestamp createdAt, Timestamp updatedAt, Client sender, Client recipient, PickupStation originatingStation, PickupStation destinationStation) {
        this.parcelId = parcelId;
        this.parcelName = parcelName;
        this.description = description;
        this.weight = weight;
        this.charges = charges;
        Status = status;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.originationId = originationId;
        this.destinationId = destinationId;
        this.addedBy = addedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.sender = sender;
        this.recipient = recipient;
        this.originatingStation = originatingStation;
        this.destinationStation = destinationStation;
    }

    public Long getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Long addedBy) {
        this.addedBy = addedBy;
    }

    public Long getParcelId() {
        return parcelId;
    }

    public void setParcelId(Long parcelId) {
        this.parcelId = parcelId;
    }

    public String getParcelName() {
        return parcelName;
    }

    public void setParcelName(String parcelName) {
        this.parcelName = parcelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public Long getOriginationId() {
        return originationId;
    }

    public void setOriginationId(Long originationId) {
        this.originationId = originationId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Client getRecipient() {
        return recipient;
    }

    public void setRecipient(Client recipient) {
        this.recipient = recipient;
    }

    public PickupStation getOriginatingStation() {
        return originatingStation;
    }

    public void setOriginatingStation(PickupStation originatingStation) {
        this.originatingStation = originatingStation;
    }

    public PickupStation getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(PickupStation destinationStation) {
        this.destinationStation = destinationStation;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "parcelId=" + parcelId +
                ", parcelName='" + parcelName + '\'' +
                ", description='" + description + '\'' +
                ", weight='" + weight + '\'' +
                ", charges=" + charges +
                ", Status='" + Status + '\'' +
                ", senderId=" + senderId +
                ", recipientId=" + recipientId +
                ", originationId=" + originationId +
                ", destinationId=" + destinationId +
                ", addedBy=" + addedBy +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", originatingStation=" + originatingStation +
                ", destinationStation=" + destinationStation +
                '}';
    }
}
