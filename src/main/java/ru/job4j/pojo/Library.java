package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book(485, "Clean Code");
        Book headFirst = new Book(358, "Head First Java");
        Book javaForJava = new Book(500, "javaForJava");
        Book linuxMint = new Book(454, "Linux Mint");
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = headFirst;
        books[2] = javaForJava;
        books[3] = linuxMint;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " " + book.getPage());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " " + book.getPage());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("Clean Code")) {
                System.out.println(book.getName() + " " + book.getPage());

            }
        }
    }
}
