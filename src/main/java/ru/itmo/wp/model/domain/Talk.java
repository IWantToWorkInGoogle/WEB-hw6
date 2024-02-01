package ru.itmo.wp.model.domain;

import java.util.Date;

public class Talk {
    private long id;
    private long sourceUserId;
    private long targetUserId;
    private String text;
    private Date creationTime;

    public void setId(long id) { this.id = id; }

    public long getId() { return id; }

    public void setSourceUserId(long sourceUserId) { this.sourceUserId = sourceUserId; }

    public long getSourceUserId() { return sourceUserId; }

    public void setTargetUserId(long targetUserId) { this.targetUserId = targetUserId; }

    public long getTargetUserId() { return targetUserId; }

    public void setText(String text) { this.text = text; }

    public String getText() { return text; }

    public void setCreationTime(Date creationTime) { this.creationTime = creationTime; }

    public Date getCreationTime() { return creationTime; }
}
