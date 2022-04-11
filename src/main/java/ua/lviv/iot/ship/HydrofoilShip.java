package ua.lviv.iot.ship;

public class HydrofoilShip extends MotorShip{
    private double price;
    private int crew;

    protected HydrofoilShip(){}
    public HydrofoilShip(double price, int people){
        this.price = price;
        this.crew = people;
    }

    @Override
    public double getPriceForPeople() {
        return price;
    }

    @Override
    public int getMaxNumberPeople() {
        return crew;
    }
    @Override
    public String toString() {
        return "HydrofoilShip: price = " + price + "; max people = " + crew;
    }
}
