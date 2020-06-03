package com.miluo.bookman.entity;

public class Book {
    private Integer bookId;

    private String bookname;

    private String wirtername;

    private Integer borrowflag;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getWirtername() {
        return wirtername;
    }

    public void setWirtername(String wirtername) {
        this.wirtername = wirtername == null ? null : wirtername.trim();
    }

    public Integer getBorrowflag() {
        return borrowflag;
    }

    public void setBorrowflag(Integer borrowflag) {
        this.borrowflag = borrowflag;
    }
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookname='" + bookname + '\'' +
                ", wirtername='" + wirtername + '\'' +
                ", borrowflag=" + borrowflag +
                '}';
    }
}