/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;


public class Student {
    int id;
    String name, gender, email, number;

    public Student() {
    }

    public Student(int id, String name, String gender, String email, String number) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.number = number;
    }

    public Student(String name, String gender, String email, String number) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }
      

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", number=" + number + '}';
    }

}
