package ua.lviv.iot;


import ua.lviv.iot.ship.*;
public class Main {
    public static void main(String[] args) {
        Manager ivan = new Manager("Petro");

        Ship steamMachine = new Steamship(100, 20);
        ivan.addShip(steamMachine);

        Ship ferry = new Ferry(120, 40);
        ivan.addShip(ferry);

        Ship riverTram = new RiverTram(30, 20);
        ivan.addShip(riverTram);

        Ship motorShip = new MotorShip(50, 10);
        ivan.addShip(motorShip);

        Ship hydrofoilShip = new HydrofoilShip(400, 15);
        ivan.addShip(hydrofoilShip);

        Ship hovercraft = new Hovercraft(500, 17);
        ivan.addShip(hovercraft);

        System.out.println("Not sorted list:\n" + ivan);
        ivan.sortByMaxPeople(true);
        System.out.println("\nSorted list:\n" + ivan);

        ivan.sortByMaxPeople(false);
        System.out.println("\nSorted list:\n" + ivan);

        ivan.sortByPrice(true);
        System.out.println("\nSorted list:\n" + ivan);

        ivan.sortByPrice(false);
        System.out.println("\nSorted list:\n" + ivan);
    }
}
