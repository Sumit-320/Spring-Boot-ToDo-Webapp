package com.firstwebapp.todo.ToDoapp;
import java.time.LocalDate;
public class todo {
    // id-username-targetdate-username-done
    private int id;
    private String username;
    private String description;
    private LocalDate targetdate;
    private boolean done;
    
    public todo(int id, String username, String description, LocalDate targetdate, boolean done) {
        super();
        this.id=id;
        this.username = username;
        this.targetdate = targetdate;
        this.done = done;
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public LocalDate getTargetdate() {
        return targetdate;
    }
    public void setTargetdate(LocalDate targetdate) {
        this.targetdate = targetdate;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return "todo [id=" + id + ", username=" + username + ", targetdate=" + targetdate + ", done=" + done
                + ", description=" + description + "]";
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
