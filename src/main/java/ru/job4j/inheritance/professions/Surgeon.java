package ru.job4j.inheritance.professions;

import ru.job4j.inheritance.professions.Doctor;

public class Surgeon extends Doctor {
    private boolean experience;

    public Surgeon(String name, String surname, String education, String birthday, boolean experience) {
        super(name, surname, education, birthday);

    }

    public Surgeon(boolean experience) {
        this.experience = experience;
    }

    public void cut() {

    }
}
