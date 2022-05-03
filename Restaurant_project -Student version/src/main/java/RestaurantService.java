import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getName().equals(restaurantName)) {
                int index = i;
                return restaurants.get(index);
            } else {
                throw new restaurantNotFoundException(restaurantName);
            }
        }
        return null;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public int displayPrice(List<String> listname, String restaurant_name) throws restaurantNotFoundException {
        int total = 0;
        Restaurant restaurant_choosen=findRestaurantByName(restaurant_name);
        for (int i = 0; i < listname.size(); i++) {
            String selected_dish = listname.get(i);
            Item item = restaurant_choosen.findItemUsingName(selected_dish);
            total = total + item.getPrice();
        }
        return total;
    }
}

