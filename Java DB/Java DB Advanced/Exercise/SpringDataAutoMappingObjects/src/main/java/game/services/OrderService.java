package game.services;

import game.entities.Order;
import game.entities.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    Order findById(long id);

    Order findOrderByUser(User user);

    Order createOne(Order order);

    List<Order> createMany(Iterable<Order> orders);

    Order updateOne(Order order);

    List<Order> updateMany(Iterable<Order> orders);

    void removeGameFromOrderById(@Param("orderId") Long orderId, @Param("gameId") Long gameId);

    void deleteById(long id);
}
