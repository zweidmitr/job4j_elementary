package ru.job4j.inheritance.professions;

public class Doctor extends Profession {
    public Doctor() {
    }

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Diagnosis heal(Pacient pacient) {
        Diagnosis allIsGood = new Diagnosis();
        return allIsGood;
    }
}
