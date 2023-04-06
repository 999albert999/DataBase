package com.digi.model;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private int id;
    private int age;

    public User(int id, String name, String surname, int age, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\n" + "ID:" + this.id + "\n" + "Name:" + this.name + "\n" + "Surname:" + this.surname + "\n " + "Age:" + this.age + "\n" + "Email:" + this.email + "\n" + "Password:" + this.password + "\n" + "----------------------------";
    }
}
