package org.example;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private String content;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    public Document(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateCreated = LocalDateTime.now();
        this.dateModified = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.dateModified = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.dateModified = LocalDateTime.now();
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                '}';
    }
}

