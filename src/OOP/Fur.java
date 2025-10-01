package OOP;

public class Fur {
    private String colour;
    private String type;

    public Fur ( String colour, String type){
        this.colour=colour;
        this.type=type;
    }

    public String getColour() {
        return colour;
    }

    public String getType() {
        return type;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString (){return colour +type;}
}
