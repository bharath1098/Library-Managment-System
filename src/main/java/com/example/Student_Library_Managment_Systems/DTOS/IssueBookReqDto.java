package com.example.Student_Library_Managment_Systems.DTOS;

public class IssueBookReqDto {
    private int bookId;
    private int cardId;

    public IssueBookReqDto() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
