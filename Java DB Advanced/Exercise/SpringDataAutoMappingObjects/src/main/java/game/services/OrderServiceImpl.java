package game.services;

import game.entities.Order;
import game.entities.User;
import game.repositories.OrderRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order findById(long id) {
        return this.orderRepository.findOne(id);
    }

    @Override
    public Order findOrderByUser(User user) {
        Order orderByUser = this.orderRepository.findOrderByUser(user);
        if (orderByUser != null) {
            Hibernate.initialize(orderByUser.getGames());
        }
        return orderByUser;
    }

    @Override
    public Order createOne(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public List<Order> createMany(Iterable<Order> orders) {
        return this.orderRepository.save(orders);
    }

    @Override
    public Order updateOne(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public List<Order> updateMany(Iterable<Order> orders) {
        return this.orderRepository.save(orders);
    }

    @Override
    public void removeGameFromOrderById(@Param("orderId") Long orderId, @Param("gameId") Long gameId) {
        this.orderRepository.removeGameFromOrderById(orderId, gameId);
    }

    @Override
    public void deleteById(long id) {
        this.orderRepository.delete(id);
    }

}
