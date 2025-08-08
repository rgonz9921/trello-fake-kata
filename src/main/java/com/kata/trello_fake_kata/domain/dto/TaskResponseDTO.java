package com.kata.trello_fake_kata.domain.dto;

import java.time.LocalDate;

public class TaskResponseDTO {
    private String id;
    private String title;
    private String description;
    private String priority;
    private String assigneeName;
    private LocalDate deliveryDate;
    private LocalDate dueDate;
    private String sprint;
    private String status;

    public TaskResponseDTO(String id, String title, String description, String priority,
                           String assigneeName,
                           LocalDate deliveryDate, LocalDate dueDate,
                           String sprint, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.assigneeName = assigneeName;
        this.deliveryDate = deliveryDate;
        this.dueDate = dueDate;
        this.sprint = sprint;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getSprint() {
        return sprint;
    }

    public void setSprint(String sprint) {
        this.sprint = sprint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

