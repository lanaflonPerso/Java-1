package vehicles.services;

import vehicles.entities.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> findAll();

    Restaurant findById(long id);

    Restaurant create(Restaurant restaurant);

    List<Restaurant> multipleCreate(Iterable<Restaurant> restaurants);

    void deleteById(long id);
}
