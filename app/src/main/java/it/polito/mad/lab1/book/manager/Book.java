/*
 Thiss class is not used yed, it was created for storing a book object in order to ease the
 manipulation for a book.
 */



package it.polito.mad.lab1.book.manager;

public class Book {


    private String bookTitle;
    private String bookAuthor;
    private String bookISBN;
    private String bookPublisher;
    private String bookEditionYear;

    private String extraDetails = null;

    public Book() {
    }

    // constructor without extra details
    public Book(String bookTitle, String bookAuthor, String bookISBN, String bookPublisher, String bookEditionYear) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookISBN = bookISBN;
        this.bookPublisher = bookPublisher;
        this.bookEditionYear = bookEditionYear;
    }


    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookEditionYear() {
        return bookEditionYear;
    }

    public void setBookEditionYear(String bookEditionYear) {
        this.bookEditionYear = bookEditionYear;
    }


    public String getExtraDeails() {
        return extraDetails;
    }

    public void setExtraDeails(String extraDeails) {
        this.extraDetails = extraDeails;
    }

    @Override
    public String toString() {
        return "Book{" +
                "\n bookTitle='" + bookTitle + '\'' +
                "\n bookAuthor='" + bookAuthor + '\'' +
                "\n bookISBN='" + bookISBN + '\'' +
                "\n bookPublisher='" + bookPublisher + '\'' +
                "\n bookEditionYear='" + bookEditionYear + '\'' +
                "\n extraDeails='" + extraDetails + '\'' +
                '}';
    }
}
