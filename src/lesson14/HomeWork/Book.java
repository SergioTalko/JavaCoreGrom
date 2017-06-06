package lesson14.HomeWork;

import java.util.Date;

/**
 * Created by SERGIO on 06.06.2017.
 */
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
}
