//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class RGBColor {
    private final int MAX_COLOR = 255;
    private int _red;
    private int _green;
    private int _blue;

    public RGBColor() {
        this._red = 0;
        this._green = 0;
        this._blue = 0;
    }

    public RGBColor(int red, int green, int blue) {
        this._red = red;
        this._green = green;
        this._blue = blue;
    }

    public RGBColor(RGBColor other) {
        this._red = other._red;
        this._green = other._green;
        this._blue = other._blue;
    }

    public int getRed() {
        return this._red;
    }

    public int getGreen() {
        return this._green;
    }

    public int getBlue() {
        return this._blue;
    }

    public void setRed(int red) {
        this._red = red;
    }

    public void setGreen(int green) {
        this._green = green;
    }

    public void setBlue(int blue) {
        this._blue = blue;
    }

    public void invert() {
        this._red = 255 - this._red;
        this._green = 255 - this._green;
        this._blue = 255 - this._blue;
    }

    public void mix(RGBColor other) {
        this._red = (other._red + this._red) / 2;
        this._green = (other._green + this._green) / 2;
        this._blue = (other._blue + this._blue) / 2;
    }

    public double convertToGrayscale() {
        return (double)this._red * 0.3D + (double)this._green * 0.59D + (double)this._blue * 0.11D;
    }

    public boolean equals(RGBColor other) {
        return this._red == other._red && this._green == other._green && this._blue == other._blue;
    }

    public String toString(){
        return "("+ _red +"," + _green + "," + _blue + ")" ;
    }
}
