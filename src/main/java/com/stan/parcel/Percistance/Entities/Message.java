package com.stan.parcel.Percistance.Entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    private String recipient;
    private String message;
    private String templateId;
    private String bulkId;
    private String batchId;
    private String messageType;
    private String subject;
    private Boolean scheduled;
    private String status;
    private Long retries;
    private LocalDateTime createdAt;
    private LocalDateTime scheduledTime;
    private LocalDateTime updatedAt;

    public Message() {
    }

    public Message(Long id) {
        this.id = id;
    }

    public Message(Long id, String recipient, String message, String templateId, String bulkId, String batchId, String messageType, String subject, Boolean scheduled, String status, Long retries, LocalDateTime createdAt, LocalDateTime scheduledTime, LocalDateTime updatedAt) {
        this.id = id;
        this.recipient = recipient;
        this.message = message;
        this.templateId = templateId;
        this.bulkId = bulkId;
        this.batchId = batchId;
        this.messageType = messageType;
        this.subject = subject;
        this.scheduled = scheduled;
        this.status = status;
        this.retries = retries;
        this.createdAt = createdAt;
        this.scheduledTime = scheduledTime;
        this.updatedAt = updatedAt;
    }

    public Long getRetries() {
        return retries;
    }

    public void setRetries(Long retries) {
        this.retries = retries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getBulkId() {
        return bulkId;
    }

    public void setBulkId(String bulkId) {
        this.bulkId = bulkId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getScheduled() {
        return scheduled;
    }

    public void setScheduled(Boolean scheduled) {
        this.scheduled = scheduled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", recipient='" + recipient + '\'' +
                ", message='" + message + '\'' +
                ", templateId='" + templateId + '\'' +
                ", bulkId='" + bulkId + '\'' +
                ", batchId='" + batchId + '\'' +
                ", messageType='" + messageType + '\'' +
                ", subject='" + subject + '\'' +
                ", scheduled=" + scheduled +
                ", status='" + status + '\'' +
                ", retries=" + retries +
                ", createdAt=" + createdAt +
                ", scheduledTime=" + scheduledTime +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
