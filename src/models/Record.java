package models;

import java.time.LocalDateTime;

public class Record {
    protected LocalDateTime date;
    protected String type;

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}

