package ru.itmo.wp.model.domain;

import java.util.Date;


public class Event {
    private long id;
    private long userId;
    private Date creationTime;
    private status type;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getUserId() { return userId; }

    public void setUserId(long userId) { this.userId = userId; }

    public Date getCreationTime() { return creationTime; }

    public void setCreationTime(Date creationTime) { this.creationTime = creationTime; }

    public status getType() { return type; }

    public void setType(status type) { this.type = type; }
}
