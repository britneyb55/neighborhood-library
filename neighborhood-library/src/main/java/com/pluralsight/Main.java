package com.pluralsight;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Main
{
    static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        Book[] books =
                {
                new Book(1, "978-1400032716", "The Catcher in the Rey", false, ""),
                new Book(2, "978-0743273565", "To Kill a Mockingbird", false, ""),
                new Book(3, "978-0061120084", "Pride and Prejudice", false, ""),
                new Book(4, "978-0060935467", "In Cold Blood", false, ""),
                new Book(5, "978-0316769488", "The Great Gatsby", false, ""),
                new Book(6, "978-0060850524", "Brave New World", false, ""),
                new Book(7, "978-0446310789", "One Hundred Years of Solitude", false, ""),
                new Book(8, "978-0062563653", "Animal Farm", false, ""),
                new Book(9, "978-0743273565", "The Sun Also Rises", false, ""),
                new Book(10, "978-1594480003", "The Kite Runner", false, ""),
                new Book(11, "978-030727860", "The Road", false, ""),
                new Book(12, "978-0439554930", "The Hunger Games", false, ""),
                new Book(13, "978-0142403873", "Hamlet", false, ""),
                new Book(14, "978-0064430173", "1984", false, ""),
                new Book(15, "978-0060935467", "Gone with the Wind", false, ""),
                new Book(16, "978-0064400558", "The Old Man and the Sea", false, ""),
                new Book(17, "978-0064400015", "Green Eggs and Ham", false, ""),
                new Book(18, "978-0316011777", "Charlotte's Web", false, ""),
                new Book(19, "978-0312367541", "Charlie and the Chocolate Factor", false, ""),
                new Book(20, "978-0316015843", "Where the Wild Things Are", false, "")
                };

        int userChoice = 0;
        while (userChoice != 3)
        {
            userChoice = homeScreenDisplay();
            switch(userChoice)
            {
                case 1:
                    // show all available books
                    availableBookList(books);
                    //userBook(books);
                    break;

                case 2:
                    //show only checked out Books
                    checkedOutBookList(books);
                    break;
                case 3:
                    System.out.println("Exit Library");
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid selection");
                    break;
            }
        }

    }

    public static int homeScreenDisplay()
    {
        System.out.println();
        System.out.println("Welcome to the Library");
        System.out.println("1) Show Available Books");
        System.out.println("2) Show Checked Out Books");
        System.out.println("3) Exit");
        System.out.println();
        System.out.println("Select your choice by entering a number that are displayed above:");
        int userChoice = userInput.nextInt();
        userInput.nextLine();
        return userChoice;

    }

    public static void availableBookList(Book[] books)
    {
        System.out.println();
        System.out.println("Books available");
        System.out.println("--------------------------");
        System.out.println("ID         Isbn                       Book title");

        // for loop to check available loops
        for (int i = 0; i < books.length; i++)
        {
            Book book = books[i];

            if (book.getisCheckedOut() != true)
            {
                System.out.printf("%-10d %-26s %-33s\n", book.getId(),
                        book.getIsbn(),
                        book.getTitle(),
                        book.getisCheckedOut(),
                        book.getCheckedOutTo());
            }
        }

        int bookChoice = 0;

        System.out.println();
        System.out.println(" Select a book you'll like to check out by entering the book ID");
        System.out.println("Exit - enter 0");
        System.out.println("Select your choice by entering a number that are displayed above:");
        bookChoice = Integer.parseInt(userInput.nextLine());


        if (bookChoice >= 1 && books.length >= bookChoice)
        {

            for (int i = 0; i < books.length; i++)
            {
                Book book = books[i];

                if (book.getId() == bookChoice)
                {
                    System.out.println("Enter your first name");
                    String userFirstName = userInput.nextLine().strip();
                    book.checkOut(userFirstName);
                    System.out.println();
                    System.out.println("Book checked out:");
                    System.out.println("ID         Isbn            Book title              Check out to:");
                    System.out.printf("%-5d %-15s %-30s %-10s \n", book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
                }

            }


        }
        else if (bookChoice == 0)
        {
            System.out.println("Returning to Library home");
        }
        else
        {
            System.out.println("Invalid selection");
            availableBookList(books);
        }

    }


    public static void checkedOutBookList(Book[] books)
    {
        System.out.println();
        System.out.println("Books Checked Out");
        System.out.println("--------------------------");
        System.out.println("ID         Isbn                       Book title         check out to:");

        for (int i = 0; i < books.length; i++)
        {
            Book book = books[i];

            if(book.getisCheckedOut() != false)
            {
                System.out.printf("%-10d %-20s %-25s %-10s\n", book.getId(),
                        book.getIsbn(),
                        book.getTitle(),
                        book.getCheckedOutTo());

            }

        }
        System.out.println();
        System.out.println("C - Check In a book");
        System.out.println("X - Home Screen ");
        String userCheckIn = userInput.nextLine();

            if(userCheckIn.equalsIgnoreCase("C"))
            {
                checkInBook(books);
            }
            else if (userCheckIn.equalsIgnoreCase("X"))
            {
                System.out.println("Returning to Library Home page..");
            }
            else
            {
                System.out.println("invalid selection");
                System.out.println("Please try again entering C or X");
                checkedOutBookList(books);
            }


    }

    public static void checkInBook(Book[] books)
    {
        System.out.println();
        System.out.println("Checking In");
        System.out.println("Enter the ID of the Book you want to check in today");
        int idCheckInBook = userInput.nextInt();

        for (int i = 0; i < books.length; i++)
        {
            Book book = books[i];

            if (book.getId() == idCheckInBook)
            {
                book.checkIn();
                System.out.println("Successfully checked In");
            }
        }
    }


}