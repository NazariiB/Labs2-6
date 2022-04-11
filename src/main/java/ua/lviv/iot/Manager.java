package ua.lviv.iot;


import ua.lviv.iot.ship.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Manager {
    private List<Ship> ships = new ArrayList<>();
    private String name;

    Manager(String name){
        this.name = name;
    }


    public void sortByMaxPeople(boolean lever){
        if(lever)
            ships.sort((o1, o2) -> o2.getMaxNumberPeople() - o1.getMaxNumberPeople());
        else
            ships.sort(Comparator.comparingInt(Ship::getMaxNumberPeople));
    }

    public void sortByPrice(boolean lever){
        if(lever)
            ships.sort((o1, o2) -> (int) (o2.getPriceForPeople() - o1.getPriceForPeople()));
        else
            ships.sort((o1, o2) -> (int) (o1.getPriceForPeople() - o2.getPriceForPeople()));
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
}
