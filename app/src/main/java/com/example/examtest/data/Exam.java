package com.example.examtest.data;

import java.util.Date;

public class Exam {
    private Date date;
    private Course course;
    private String classroom;
    private String supervisor;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Exam() {
    }

    public Exam(Date date, Course course, String classroom, String supervisor) {
        this.date = date;
        this.course = course;
        this.classroom = classroom;
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "date=" + date +
                ", course=" + course +
                ", classroom='" + classroom + '\'' +
                ", supervisor='" + supervisor + '\'' +
                '}';
    }
}
