package com.miluo.bookman.entity;

public class Reader {
    private Integer studentId;

    private String name;

    private Integer count;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}