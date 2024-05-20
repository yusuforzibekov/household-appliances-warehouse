package edu.itpu.fopjava_course_work.entity;

public class Feedback {
    private String name;
    private String surname;
    private String message;

    public Feedback(String name, String surname, String message) {
        this.name = name;
        this.surname = surname;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nSurname: " + surname + "\nMessage: " + message;
    }
}