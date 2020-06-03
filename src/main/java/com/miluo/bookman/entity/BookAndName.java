package com.miluo.bookman.entity;

import java.util.Date;

public class BookAndName {
    private Integer studentId;

    private Integer bookId;

    private Date time;

    public BookAndName() {
    }

    public BookAndName(Integer studentId, Integer bookId) {
        this.studentId = studentId;
        this.bookId = bookId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "BookAndName{" +
                "studentId=" + studentId +
                ", bookId=" + bookId +
                ", time=" + time +
                '}';
    }
}