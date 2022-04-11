package ua.lviv.iot.ship;

public class Steamship implements Ship{
    private double price;
    private int people;

    Steamship(){}
    public Steamship(double price, int people){
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
        return "Steamship: price = " + price + "; max people = " + people;
    }
}
