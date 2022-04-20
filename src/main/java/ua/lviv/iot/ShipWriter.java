package ua.lviv.iot;

import ua.lviv.iot.ship.Ship;

import java.io.*;
import java.util.List;

public class ShipWriter {
    public void writeToFile(List<Ship> ships){
        try(FileWriter fileWriter = new FileWriter("src/main/java/ua/lviv/iot/ships")){
            fileWriter.write(ships.get(0).getHeaders() + "\n");
            ships.forEach(ship -> {
                try {
                    fileWriter.write(ship.toCSV() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
