package com.example.splashscreen.Classes;

public class BookLog_Details {
    String bookNAme;
    String authorName;
    String currentDate;
    String cardBackground;

    public BookLog_Details(String bookNAme, String authorName, String currentDate, String cardBackground) {
        this.bookNAme = bookNAme;
        this.authorName = authorName;
        this.currentDate = currentDate;
        this.cardBackground = cardBackground;
    }

    public String getBookNAme() {
        return bookNAme;
    }

    public void setBookNAme(String bookNAme) {
        this.bookNAme = bookNAme;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCardBackground() {
        return cardBackground;
    }

    public void setCardBackground(String cardBackground) {
        this.cardBackground = cardBackground;
    }
}
