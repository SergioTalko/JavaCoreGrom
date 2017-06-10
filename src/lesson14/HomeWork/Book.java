package lesson14.HomeWork;

import java.util.Date;

public class Book {
    private long id;
    private String callNo;
    private String name;
    private String author;
    private String publisher;
    private int quantity;
    private int issued;
    private Date addedDate;


    public Book(long id, String callNo, String name, String author, String publisher, int quantity, int issued, Date addedDate) {
        this.id = id;
        this.callNo = callNo;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issued = issued;
        this.addedDate = addedDate;
    }


    public long getId() {
        return id;
    }

    public String getCallNo() {
        return callNo;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIssued() {
        return issued;
    }

    public Date getAddedDate() {
        return addedDate;
    }


    public void setCallNo(String callNo) {
        this.callNo = callNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", callNo='" + callNo + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                ", issued=" + issued +
                ", addedDate=" + addedDate +
                '}';
    }
}
