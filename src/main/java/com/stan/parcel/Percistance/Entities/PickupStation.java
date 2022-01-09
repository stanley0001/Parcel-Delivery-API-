package com.stan.parcel.Percistance.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="PickupStation")
public class PickupStation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false,insertable = false,updatable = false)
    private Long id;
    private String stationName;
    private String latitude;
    private String longitude;
    private String contactPerson;
    private String status;
    @Column(unique = true,nullable = false)
    private String phone;
    @Column(unique = true,nullable = false)
    private String email;
    private String mobile;
    @OneToMany(mappedBy = "originatingStation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Parcel> parcelOut;
    @OneToMany(mappedBy = "destinationStation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Parcel> parcelIn;

    public PickupStation() {
    }

    public PickupStation(Long id) {
        this.id = id;
    }

    public PickupStation(Long id, String stationName, String latitude, String longitude, String contactPerson, String status, String phone, String email, String mobile, Set<Parcel> parcelOut, Set<Parcel> parcelIn) {
        this.id = id;
        this.stationName = stationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.contactPerson = contactPerson;
        this.status = status;
        this.phone = phone;
        this.email = email;
        this.mobile = mobile;
        this.parcelOut = parcelOut;
        this.parcelIn = parcelIn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Set<Parcel> getParcelOut() {
        return parcelOut;
    }

    public void setParcelOut(Set<Parcel> parcelOut) {
        this.parcelOut = parcelOut;
    }

    public Set<Parcel> getParcelIn() {
        return parcelIn;
    }

    public void setParcelIn(Set<Parcel> parcelIn) {
        this.parcelIn = parcelIn;
    }

    @Override
    public String toString() {
        return "PickupStation{" +
                "id=" + id +
                ", stationName='" + stationName + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", status='" + status + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", parcelOut=" + parcelOut +
                ", parcelIn=" + parcelIn +
                '}';
    }
}
