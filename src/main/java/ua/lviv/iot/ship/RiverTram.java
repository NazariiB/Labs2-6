package ua.lviv.iot.ship;

public class RiverTram extends Ferry {
    private double price;
    private int people;

    protected RiverTram(){}

    public RiverTram(double price, int people){
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
        return "RiverTram: price = " + price + "; max people = " + people;
    }
}
