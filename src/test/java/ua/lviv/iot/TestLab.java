package ua.lviv.iot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.lviv.iot.ship.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class TestLab {
    private static final Manager manager = new Manager("Ivan");

    @Before
    public void beforeEach(){
        manager.clearShips();
        manager.addShip(new HydrofoilShip(100, 10));
        manager.addShip(new Hovercraft(120, 12));
        manager.addShip(new MotorShip(90, 11));
        manager.addShip(new Ferry(110, 15));
        manager.addShip(new RiverTram(130, 16));
        manager.addShip(new Steamship(109, 9));
    }



    @Test
    public void testGeneral(){
        manager.sortByMaxPeople(SortType.BIGTOLOW);
        String str = manager.toString();
        Assert.assertNotNull(str);
        manager.sortByMaxPeople(SortType.LOWTOBIG);
        String str1 = manager.toString();
        assertNotEquals(str, str1);
        Assert.assertNotNull(manager.findSortByMaxPeople(11, SortType.BIGTOLOW));
        Assert.assertNotNull(manager.findSortByMaxPeople(11, SortType.LOWTOBIG));
        Assert.assertNotNull(manager.findSortByPrice(110, SortType.BIGTOLOW));
        Assert.assertNotNull(manager.findSortByPrice(110, SortType.LOWTOBIG));
    }

    @Test
    public void testSorting(){
        manager.sortByPrice(SortType.BIGTOLOW);
        assertEquals("""
                Manager name:Ivan
                ships = [ RiverTram: price = 130.0; max people = 16\s
                 Hovercraft: price = 120.0; max people = 12\s
                 Ferry: price = 110.0; max people = 15\s
                 Steamship: price = 109.0; max people = 9\s
                 HydrofoilShip: price = 100.0; max people = 10\s
                 MotorShip: price = 90.0; max people = 11 ] }""", manager.toString());

        manager.sortByPrice(SortType.LOWTOBIG);
        assertEquals("""
                Manager name:Ivan
                ships = [ MotorShip: price = 90.0; max people = 11\s
                 HydrofoilShip: price = 100.0; max people = 10\s
                 Steamship: price = 109.0; max people = 9\s
                 Ferry: price = 110.0; max people = 15\s
                 Hovercraft: price = 120.0; max people = 12\s
                 RiverTram: price = 130.0; max people = 16 ] }""", manager.toString());

        manager.sortByMaxPeople(SortType.LOWTOBIG);
        assertEquals("""
                Manager name:Ivan
                ships = [ Steamship: price = 109.0; max people = 9\s
                 HydrofoilShip: price = 100.0; max people = 10\s
                 MotorShip: price = 90.0; max people = 11\s
                 Hovercraft: price = 120.0; max people = 12\s
                 Ferry: price = 110.0; max people = 15\s
                 RiverTram: price = 130.0; max people = 16 ] }""", manager.toString());


        manager.sortByMaxPeople(SortType.BIGTOLOW);
        assertEquals("""
                Manager name:Ivan
                ships = [ RiverTram: price = 130.0; max people = 16\s
                 Ferry: price = 110.0; max people = 15\s
                 Hovercraft: price = 120.0; max people = 12\s
                 MotorShip: price = 90.0; max people = 11\s
                 HydrofoilShip: price = 100.0; max people = 10\s
                 Steamship: price = 109.0; max people = 9 ] }""", manager.toString());

    }

    @Test
    public void testFindingSortingByPrice(){
        manager.addShip(new Steamship(110, 12));
        manager.addShip(new RiverTram(110, 11));
        assertEquals("[Ferry: price = 110.0; max people = 15," +
                        " Steamship: price = 110.0; max people = 12," +
                        " RiverTram: price = 110.0; max people = 11]",
                            manager.findSortByPrice(110, SortType.BIGTOLOW).toString());
        assertEquals("[RiverTram: price = 110.0; max people = 11, " +
                        "Steamship: price = 110.0; max people = 12, " +
                        "Ferry: price = 110.0; max people = 15]",
                        manager.findSortByPrice(110, SortType.LOWTOBIG).toString());
    }

    @Test
    public void testFindingSortingByPeople(){
        manager.addShip(new Steamship(105, 11));
        manager.addShip(new RiverTram(117, 11));
        assertEquals("[RiverTram: price = 117.0; max people = 11," +
                        " Steamship: price = 105.0; max people = 11, " +
                        "MotorShip: price = 90.0; max people = 11]",
                manager.findSortByMaxPeople(11, SortType.BIGTOLOW).toString());
        assertEquals("[MotorShip: price = 90.0; max people = 11," +
                        " Steamship: price = 105.0; max people = 11," +
                        " RiverTram: price = 117.0; max people = 11]",
                manager.findSortByMaxPeople(11, SortType.LOWTOBIG).toString());
    }

    @Test
    public void testShipWriter(){
        ShipWriter shipWriter = new ShipWriter();
        shipWriter.writeToFile(manager.getShips());
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/ua/lviv/iot/ships"))) {
            List<String> file = bufferedReader.lines().toList();
            assertEquals(file.toString(), "[price,people, 100.0,10, 120.0,12, 90.0,11, 110.0,15, 130.0,16, 109.0,9]");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testClearShips(){
        manager.clearShips();
        assertEquals(0, manager.getShips().size());
    }
}
