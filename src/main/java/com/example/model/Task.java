package com.example.model;

public class Task {
    private int id ;
    private String description ;
    private String createdAt;
    private String updatedAt;
    private  Status status;

    public Task(int id, String description, String createdAt, String updatedAt, Status status) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status= status;
    }

}
