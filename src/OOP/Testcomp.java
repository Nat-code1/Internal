package OOP;

public class Testcomp {
    public static void main(String[] args){

        Author[]authors = new Author[2];
        authors[0]= new Author ("Bolesław", "Prus", "Poland", "male");
        authors[1]= new Author ("Wisława", "Szymborska", "Poland", "female");

        System.out.println(authors[0]);
        System.out.println(authors[1]);

        for (int i =0; i<authors.length; i++)
        {
            System.out.println(authors[i].getName());
        }
    }
}
