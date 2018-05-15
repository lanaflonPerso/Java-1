package vehicles.services;

import vehicles.entities.Restaurant;
import vehicles.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> findAll() {
        return this.restaurantRepository.findAll();
    }

    @Override
    public Restaurant findById(long id) {
        return this.restaurantRepository.findOne(id);
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return this.restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> multipleCreate(Iterable<Restaurant> restaurants) {
        return this.restaurantRepository.save(restaurants);
    }

    @Override
    public void deleteById(long id) {
        this.restaurantRepository.delete(id);
    }

}
