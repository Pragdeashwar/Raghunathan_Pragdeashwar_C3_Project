

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();


    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public LocalTime getcurrenttime() {
        LocalTime current_time = getCurrentTime();
        return current_time;
    }

    public boolean isRestaurantOpen() {
        LocalTime current = getcurrenttime();
        boolean status = false;
        int open_true = current.compareTo(openingTime);
        int close_false = current.compareTo(closingTime);


        if (open_true == 1 && close_false == -1) {
            status = true;
        } else if (open_true == 0 && close_false == -1) {
            status = true;
        } else if (open_true == 1 && close_false == 0) {
            status = true;
        } else {
            status = false;
        }
        return status;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }

    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    public List<Item> getMenu() {
        return menu;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    private Item findItemByName(String itemName) {
        for (Item item : menu) {
            if (item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails() {
        System.out.println("Restaurant:" + name + "\n"
                + "Location:" + location + "\n"
                + "Opening time:" + openingTime + "\n"
                + "Closing time:" + closingTime + "\n"
                + "Menu:" + "\n" + getMenu());

    }


    public String getName() {
        return name;
    }

    public Item findItemUsingName(String itemName) {
        for (Item item : menu) {
            if (item.getName().equals(itemName))
                return item;
        }
        return null;

    }
}