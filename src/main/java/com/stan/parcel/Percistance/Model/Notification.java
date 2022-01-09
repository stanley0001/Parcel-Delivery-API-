package com.stan.parcel.Percistance.Model;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Notification {
    private String templateId;
    private String notificationType;
    private String[] to;
    private String name;
    private String item;
    private String message;
    private String amount;
    private String originatingAddress;
    private String destinationAddress;
    private Boolean schedule;
    private LocalDateTime scheduleTime;

    public Notification() {
    }

    public Notification(String templateId, String notificationType, String[] to, String name, String item, String message, String amount, String originatingAddress, String destinationAddress, Boolean schedule, LocalDateTime scheduleTime) {
        this.templateId = templateId;
        this.notificationType = notificationType;
        this.to = to;
        this.name = name;
        this.item = item;
        this.message = message;
        this.amount = amount;
        this.originatingAddress = originatingAddress;
        this.destinationAddress = destinationAddress;
        this.schedule = schedule;
        this.scheduleTime = scheduleTime;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOriginatingAddress() {
        return originatingAddress;
    }

    public void setOriginatingAddress(String originatingAddress) {
        this.originatingAddress = originatingAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public Boolean getSchedule() {
        return schedule;
    }

    public void setSchedule(Boolean schedule) {
        this.schedule = schedule;
    }

    public LocalDateTime getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(LocalDateTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "templateId='" + templateId + '\'' +
                ", notificationType='" + notificationType + '\'' +
                ", to=" + Arrays.toString(to) +
                ", name='" + name + '\'' +
                ", item='" + item + '\'' +
                ", message='" + message + '\'' +
                ", amount='" + amount + '\'' +
                ", originatingAddress='" + originatingAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", schedule=" + schedule +
                ", scheduleTime=" + scheduleTime +
                '}';
    }
}
