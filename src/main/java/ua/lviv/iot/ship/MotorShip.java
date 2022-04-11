package ua.lviv.iot.ship;

public class MotorShip extends RiverTram{
    private double price;
    private int crew;

    protected MotorShip(){}
    public MotorShip(double price, int people){
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
        return "MotorShip: price = " + price + "; max people = " + crew;
    }
}
