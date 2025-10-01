package OOP;

public class GuineaPig {
    private String name;
    private double age;
    private char gender;
    private Fur fur;

    public GuineaPig(String name, double age, char gender, Fur fur){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.fur=fur;
    }
    public String getName(){return name;}
    public double getAge(){return age;}
    public char getGender(){return gender;}
    public Fur getFur(){return fur;}
    public void setAge(double age){this.age=age;}
    public String toString(){return "name='" + name + '\'' +",age='" + age +'\''+ ",gender='" +gender + '\'' +",fur='" + fur;}

}
