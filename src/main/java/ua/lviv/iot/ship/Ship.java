package ua.lviv.iot.ship;

public interface Ship {
    double getPriceForPeople();
    int getMaxNumberPeople();

    default String getHeaders(){
        return "price,people";
    }
    String toCSV();
}
