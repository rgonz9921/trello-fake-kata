package com.kata.trello_fake_kata.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "sprint")
public class Sprint {
    private String _id;
    private String name;
    private String goal;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Sprint(String _id, String name, String goal, LocalDate startDate,
                  LocalDate endDate, LocalDate createdAt,
                  LocalDate updatedAt) {
        this._id = _id;
        this.name = name;
        this.goal = goal;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters y Setters
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
