package ua.lviv.iot.ship;

public class RiverTram extends Ferry {
    private double price;
    private int crew;

    protected RiverTram(){};

    public RiverTram(double price, int people){
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
        return "RiverTram: price = " + price + "; max people = " + crew;
    }
}
