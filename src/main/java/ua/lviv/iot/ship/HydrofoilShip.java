package ua.lviv.iot.ship;

public class HydrofoilShip extends MotorShip{
    private double price;
    private int people;

    protected HydrofoilShip(){}
    public HydrofoilShip(double price, int people){
        this.price = price;
        this.people = people;
    }
    @Override
    public String toCSV() {
        return price + "," + people;
    }
    @Override
    public double getPriceForPeople() {
        return price;
    }

    @Override
    public int getMaxNumberPeople() {
        return people;
    }
    @Override
    public String toString() {
        return "HydrofoilShip: price = " + price + "; max people = " + people;
    }
}
