package game.repositories;

import game.entities.Order;
import game.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findOrderByUser(User user);

    @Modifying
    @Query(value = "DELETE FROM softuni_game_store_db.orders_games WHERE order_id = :orderId AND game_id = :gameId", nativeQuery = true)
    void removeGameFromOrderById(@Param("orderId") Long orderId, @Param("gameId") Long gameId);
}
