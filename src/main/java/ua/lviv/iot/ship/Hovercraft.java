package ua.lviv.iot.ship;

public class Hovercraft extends HydrofoilShip{
    private double price;
    private int crew;

    protected Hovercraft(){}
    public Hovercraft(double price, int people){
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
        return "Hovercraft: price = " + price + "; max people = " + crew;
    }
}
