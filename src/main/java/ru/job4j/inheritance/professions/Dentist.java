package ru.job4j.inheritance.professions;

public class Dentist extends Doctor {
    boolean salary;

    public Dentist(boolean salary) {
        this.salary = salary;
    }

    public Dentist(String name, String surname, String education, String birthday, boolean salary) {
        super(name, surname, education, birthday);
        this.salary = salary;
    }

    public void bore() {

    }
}
