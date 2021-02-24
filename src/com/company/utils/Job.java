package com.company.utils;

public class Job {
    public String author;
    public String phone;
    public String title;
    public String description;
    public String url;

    public Job(String author, String phone, String title, String description, String url) {
        this.author = author;
        this.phone = phone;
        this.title = title;
        this.description = description;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Job { " + url +  " }" +
                "\n titlu: " + title +
                "\n description: " + description +
                "\n contact: " + author + " - " + phone + "\n";
    }
}
