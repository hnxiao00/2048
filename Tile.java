/**
* Name: Hannah Xiao
* Pennkey: hnxiao
* Execution: java Tile
*
* Description: This file contains the constructors and methods of the tile object.
**/

public class Tile {
    
    private int value;
    private int xval;
    private int yval;
    
    //Constructor for a Tile object
    public Tile(int value, int xval, int yval) {
        this.value = value;
        this.xval = xval;
        this.yval = yval;
    }
    
    /**
    * Inputs: None
    * Outputs: None
    * Description: This function writes the number of the tile
    * if the value is nonzero
    */
    public void reveal() {
        if (value == 0) {
            PennDraw.text(.125 + xval * .25, .125 + yval * .25, "");
        }
        else {
            PennDraw.setPenColor(PennDraw.BLACK);
            PennDraw.setFontSize(45);
            PennDraw.text(.125 + xval * .25, .125 + yval * .25, "" + value);
        }
    }
    
    /**
    * Inputs: A integer new value for the time
    * Outputs: None
    * Description: This function is a setter that sets the value of the tile
    */
    public void setValue(int a) {
        value = a;
    }
    
    /**
    * Inputs: None
    * Outputs: None
    * Description: This function returns the value of the tile
    */
    public int getValue() {
        return value;
    }

    /**
    * Inputs: another tile
    * Outputs: None
    * Description: This function checks if two tiles have the same value
    */
    public boolean equals(Tile other) {
        if (this.getValue() == other.getValue()) {
            return true;
        }
        return false;
    }
}
