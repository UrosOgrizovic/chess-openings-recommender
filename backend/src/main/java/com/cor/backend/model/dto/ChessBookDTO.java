package com.cor.backend.model.dto;

import com.cor.backend.model.ChessBook;

public class ChessBookDTO {
    private String title;
    private String authorFullName;
    private String goodreadsLink;
    private String bookType;
    private String goodreadsCoverPhotoLink;

    public String getGoodreadsCoverPhotoLink() {
        return goodreadsCoverPhotoLink;
    }

    public void setGoodreadsCoverPhotoLink(String goodreadsCoverPhotoLink) {
        this.goodreadsCoverPhotoLink = goodreadsCoverPhotoLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public String getGoodreadsLink() {
        return goodreadsLink;
    }

    public void setGoodreadsLink(String goodreadsLink) {
        this.goodreadsLink = goodreadsLink;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public ChessBookDTO() {
    }

    public ChessBookDTO(ChessBook cb) {
        this.authorFullName = cb.getAuthorFullName();
        this.bookType = cb.getBookType().toString();
        this.goodreadsLink = cb.getGoodreadsLink();
        this.title = cb.getTitle();
        this.goodreadsCoverPhotoLink = cb.getGoodreadsCoverPhotoLink();
    }
}
