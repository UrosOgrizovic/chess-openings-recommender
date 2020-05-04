package com.cor.backend.model;

import com.cor.backend.model.enums.PlayerType;

import javax.persistence.*;

@Entity
@Table(name = "ChessBook")
public class ChessBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String authorFullName;
    @Column
    private String goodreadsLink;
    @Column
    private PlayerType bookType;

    public ChessBook(String title, String authorFullName, String goodreadsLink, PlayerType bookType) {
        this.title = title;
        this.authorFullName = authorFullName;
        this.goodreadsLink = goodreadsLink;
        this.bookType = bookType;
    }

    public PlayerType getBookType() {
        return bookType;
    }

    public void setBookType(PlayerType bookType) {
        this.bookType = bookType;
    }

    public ChessBook() {
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
}
