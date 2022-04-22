package ua.lviv.iot.ship;

public class Hovercraft extends HydrofoilShip{
    private double price;
    private int people;

    protected Hovercraft(){}
    public Hovercraft(double price, int people){
        this.price = price;
        this.people = people;
    }

    @Override
    public double getPriceForPeople() {
        return price;
    }
    @Override
    public String toCSV() {
        return price + "," + people;
    }
    @Override
    public int getMaxNumberPeople() {
        return people;
    }
    @Override
    public String toString() {
        return "Hovercraft: price = " + price + "; max people = " + people;
    }
}
