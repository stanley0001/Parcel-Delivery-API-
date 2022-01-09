package com.stan.parcel.Percistance.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    @Column(unique = true,nullable = false)
    private String documentNumber;
    private String name;
    @Column(unique = true,nullable = false)
    private String phone;
    @Column(unique = true)
    private String email;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "sender",fetch = FetchType.EAGER)
    private Set<Parcel> sentParcels;
    @OneToMany(mappedBy = "recipient",fetch = FetchType.EAGER)
    private Set<Parcel> receivedParcels;

    public Client() {
    }

    public Client(Long id) {
        this.id = id;
    }

    public Client(Set<Parcel> sentParcels) {
        this.sentParcels = sentParcels;
    }

    public Client(Long id, String documentNumber, String name, String phone, String email, Timestamp createdAt, Timestamp updatedAt, Set<Parcel> sentParcels, Set<Parcel> receivedParcels) {
        this.id = id;
        this.documentNumber = documentNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.sentParcels = sentParcels;
        this.receivedParcels = receivedParcels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Set<Parcel> getSentParcels() {
        return sentParcels;
    }

    public void setSentParcels(Set<Parcel> sentParcels) {
        this.sentParcels = sentParcels;
    }

    public Set<Parcel> getReceivedParcels() {
        return receivedParcels;
    }

    public void setReceivedParcels(Set<Parcel> receivedParcels) {
        this.receivedParcels = receivedParcels;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", documentNumber='" + documentNumber + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", sentParcels=" + sentParcels +
                ", receivedParcels=" + receivedParcels +
                '}';
    }
}
