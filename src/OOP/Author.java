package OOP;

public class Author {
    private String name;
    private String surname;
    private String country;
    private String gender;


    public Author (String name, String surname, String country, String gender){
        this.name=name;
        this.surname=surname;
        this.country=country;
        this.gender=gender;
    }

    public String getName(){return name;}
    public String getSurname(){return surname;}
    public String getCountry(){return country;}
    public String getGender(){return gender;}
    public void setCountry (String country){this.country=country;}
    public String toString (){return name + surname + country;}
}
