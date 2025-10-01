package OOP;

public class Office {
    private String Offname;
    private String Offcity;
    private String Employee;

    public Office (String Offname, String Offcity, String Employee){
        this.Offname=Offname;
        this.Offcity=Offcity;
        this.Employee=Employee;
    }

    public String getOffname(){return Offname;}
    public String getOffcity(){return Offcity;}
    public String Employee(){return Employee;}
    public String toString (){return Offname + Offcity + Employee;}



}
