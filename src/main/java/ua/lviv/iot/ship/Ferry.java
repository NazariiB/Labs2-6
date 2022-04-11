package ua.lviv.iot.ship;

public class Ferry extends Steamship {
    private double price;
    private int people;

    protected Ferry(){}
    public Ferry(double price, int people){
        this.price = price;
        this.people = people;
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
        return "Ferry: price = " + price + "; max people = " + people;
    }
}
