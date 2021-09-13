package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("We", 250);
        Book second = new Book("New World", 200);
        Book third = new Book("Dandelion Wine", 300);
        Book fourth = new Book("Clean code", 100);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;

        for (int index = 0; index < books.length; index++) {
            Book bo = books[index];
            System.out.println(bo.getName() + " : " + bo.getCountOfPages());
        }
        System.out.println();
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bo = books[index];
            System.out.println(bo.getName() + " : " + bo.getCountOfPages());
        }
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            Book bo = books[index];
//            if (bo.getName() == "Clean code") {
//                System.out.println(bo.getName() + " : " + bo.getCountOfPages());
//            }
            if (bo.equals(books[0])) {
                System.out.println(bo.getName() + " : " + bo.getCountOfPages());
            }
        }
    }
}