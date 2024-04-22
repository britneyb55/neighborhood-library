package com.pluralsight;

public class Book
{
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id,String isbn,String title,boolean isCheckedOut,String checkedOutTo)
    {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;

    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getIsbn()
    {
        return this.isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean getIsCheckedOut()
    {
        return this.isCheckedOut;
    }

    public void setIsCheckedOut(boolean isCheckedOut)
    {
        this.isCheckedOut = isCheckedOut;
    }

    public String getCheckedOutTo()
    {
        return this.checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo)
    {
        this.checkedOutTo = checkedOutTo;
    }

    public void checkOut(String name)
    {


        if (isCheckedOut)
        {
            System.out.println("Sorry this book is checked out");
        }
        else{
            setCheckedOutTo(name);
            setisCheckedOut(true);
        }


    }

    public void checkIn()
    {

            setisCheckedOut(false);
            setCheckedOutTo("");



    }






}
