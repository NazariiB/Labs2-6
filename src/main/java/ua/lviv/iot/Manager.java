package ua.lviv.iot;


import ua.lviv.iot.ship.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Manager {
    private final List<Ship> ships = new ArrayList<>();
    private final String name;

    Manager(String name){
        this.name = name;
    }


    public void sortByMaxPeople(SortType lever){
        if(SortType.BIGTOLOW.equals(lever))
            ships.sort((ship1, ship2) -> ship2.getMaxNumberPeople() - ship1.getMaxNumberPeople());
        else
            ships.sort(Comparator.comparingInt(Ship::getMaxNumberPeople));
    }

    public void sortByPrice(SortType lever){
        if(SortType.BIGTOLOW.equals(lever))
            ships.sort((ship1, ship2) -> (int) (ship2.getPriceForPeople() - ship1.getPriceForPeople()));
        else
            ships.sort((ship1, ship2) -> (int) (ship1.getPriceForPeople() - ship2.getPriceForPeople()));
    }

    public List<Ship> findSortByPrice(double price, SortType sortType){
        List<Ship> ships = findShipsDyPrice(price);
        if(sortType.equals(SortType.BIGTOLOW))
            ships.sort((ship1, ship2) -> (int) (ship2.getPriceForPeople() - ship1.getPriceForPeople()));
        else
            ships.sort((ship1, ship2) -> (int) (ship1.getPriceForPeople() - ship2.getPriceForPeople()));
        return ships;
    }

    public List<Ship> findSortByMaxPeople(int people, SortType sortType){
        List<Ship> ships = findShipsByMaxPeople(people);
        if(SortType.BIGTOLOW.equals(sortType))
            ships.sort((ship1, ship2) -> ship2.getMaxNumberPeople() - ship1.getMaxNumberPeople());
        else
            ships.sort(Comparator.comparingInt(Ship::getMaxNumberPeople));
        return ships;
    }

    public void addShip(Ship ship){
        ships.add(ship);
    }

    @Override
    public String toString() {
        return "Manager name:" + name + "\nships =" +
                ships.stream().flatMap(a -> Stream.of(a.toString()))
                        .collect(Collectors.joining(" \n "," [ "," ] ")) + '}';
    }

    public List<Ship> findShipsDyPrice(double price){
        return ships.stream().filter(ship -> ship.getPriceForPeople() == price).collect(Collectors.toList());
    }

    public List<Ship> findShipsByMaxPeople(int people){
        return ships.stream().filter(ship -> ship.getMaxNumberPeople() == people).collect(Collectors.toList());
    }
}