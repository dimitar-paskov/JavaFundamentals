public class Box {
    private double length;
    private double  width;
    private double height;

    public Box(double length, double width, double height) throws ValidationException {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);

    }

    private void setLength(double length) throws ValidationException {
        if (length <=0 ){
            throw new ValidationException("Length cannot be zero or negative.");
//            throw new IllegalArgumentException();
        }
        this.length = length;
    }

    private void setWidth(double width) throws ValidationException {
        if (width <=0 ){
            throw new ValidationException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) throws ValidationException {
        if (height <=0 ){
            throw new ValidationException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea (){
        return 2*this.length*this.width + this.calculateLateralSurfaceArea();
    }
    public double calculateLateralSurfaceArea (){
        return 2*this.length*this.height + 2*this.width*this.height;
    }
    public double calculateVolume (){
        return this.length * this.width * this.height;
    }
}
