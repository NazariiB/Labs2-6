package ua.lviv.iot;


import ua.lviv.iot.ship.*;
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Ivan");

        Ship steamMachine = new Steamship(100, 20);
        manager.addShip(steamMachine);

        Ship ferry = new Ferry(120, 40);
        manager.addShip(ferry);

        Ship riverTram = new RiverTram(30, 20);
        manager.addShip(riverTram);

        Ship motorShip = new MotorShip(50, 10);
        manager.addShip(motorShip);

        Ship hydrofoilShip = new HydrofoilShip(400, 15);
        manager.addShip(hydrofoilShip);

        Ship hovercraft = new Hovercraft(500, 17);
        manager.addShip(hovercraft);

        System.out.println("Not sorted list:\n" + manager);
        manager.sortByMaxPeople(SortType.BIGTOLOW);
        System.out.println("\nSorted list:\n" + manager);

        manager.sortByMaxPeople(SortType.LOWTOBIG);
        System.out.println("\nSorted list:\n" + manager);

        manager.sortByPrice(SortType.BIGTOLOW);
        System.out.println("\nSorted list:\n" + manager);

        manager.sortByPrice(SortType.LOWTOBIG);
        System.out.println("\nSorted list:\n" + manager);

        System.out.println("\nFind ships with price 100:\n" + manager.findSortByPrice(100, SortType.BIGTOLOW));

        System.out.println("\nFind ships with people 20: \n" + manager.findSortByMaxPeople(20, SortType.LOWTOBIG));

        ShipWriter shipWriter = new ShipWriter();
        shipWriter.writeToFile(manager.getShips());
    }
}
