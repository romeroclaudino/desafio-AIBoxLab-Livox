package com.aiboxlab.desafio_livox.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Book implements Serializable {
    public static final String KEY = "BOOK";

    private String title;
    private String isbn;
    private int pageCount;
    private String thumbnailUrl;
    private String shortDescription;
    private String longDescription;
    private String status;
    private ArrayList<String> authors;
    private ArrayList<String> categories;
    private PublishedDate publishedDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public Date getPublishedDate() {
        return publishedDate.$date;
    }

    public void setPublishedDate(Date date){
        publishedDate.$date = date;
    }

    private class PublishedDate implements Serializable{
        Date $date;
    }
}
