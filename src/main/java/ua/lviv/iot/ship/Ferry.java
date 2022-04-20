package ua.lviv.iot.ship;

public class Ferry extends Steamship {
    private double price;
    private int people;

    protected Ferry() { }
    public Ferry(final double cost, final int persons) {
        price = cost;
        people = persons;
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
        return "Ferry: price = " + price + "; max people = " + people;
    }
}
