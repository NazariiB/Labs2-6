package ua.lviv.iot.ship;

public class Hovercraft extends HydrofoilShip {
    private final double price;
    private final int people;

    public Hovercraft(final double cost, final int persons) {
        price = cost;
        people = persons;
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
