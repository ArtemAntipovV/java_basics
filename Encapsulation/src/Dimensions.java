public class Dimensions {

    private final double width; // ширина;
    private final double height; // высота;
    private final double length;// длина;


    public Dimensions(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;

    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

     public double getLength() {
        return length;
    }

    public Dimensions setLength(double length) {
        return new Dimensions(width, height, length);
    }
    public Dimensions setWidth(double width) {
        return new Dimensions(width, height, length);
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(width, height, length);
    }

    public  double getVolume() {
        return  width * height * length;
    }

    public String toString() {
        return "Габариты" + getVolume();
    }

}
