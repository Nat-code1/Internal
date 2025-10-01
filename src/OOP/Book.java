package OOP;

public class Book {

    private String isbn;
    private String name;

    private Author[] authors; //compositiion, aggregation
    private double price;

    public Book(String isbn, String name, Author[] authors, Double price){
        this.isbn=isbn;
        this.name=name;
        this.authors=authors;
        this.price=price;
    }

    public String getIsbn(){return isbn;}
    public String getName(){return name;}
    public Author[] getAuthors(){return authors;}
    public double getPrice(){return price;}


    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
    return "Book{" +
    "isbn='" + isbn + '\'' + ", name='" + name + '\'' +", author=" + authors +", price=" + price + '}';    }
}


