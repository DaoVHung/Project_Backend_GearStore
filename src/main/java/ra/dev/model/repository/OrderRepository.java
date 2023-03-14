package ra.dev.model.repository;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.data.jpa.repository.Query;import org.springframework.data.repository.query.Param;import org.springframework.stereotype.Repository;import ra.dev.model.entity.Order;import java.util.List;@Repositorypublic interface OrderRepository extends JpaRepository<Order, Integer> {    @Query(value = "select o from Order o where o.orderStatus = 1 ")    List<Order> status1();    @Query(value = "select o from Order o where o.orderStatus = 2 ")    List<Order> status2();    @Query(value = "select o from Order o where o.orderStatus = 3 ")    List<Order> status3();    @Query(value = "select o from Order o where o.orderStatus = 4 ")    List<Order> status4();    @Query(value = "select o from Order o where o.orderStatus = 1 ")    List<Order> getOrderByUserID(@Param("userID") Integer userID);    @Query(value = "select o from Order o where o.orderStatus = 1 ")    Order findByUserID_UserId(Integer userID);//    @Query(value = "select o from Order o where o.orderStatus = 1 ")//    Order getAllByUserID(Integer userID);    @Query(value = "select o from Order o where o.orderStatus = 3 ")    List<Order> getOrderConfirm(@Param("userID") Integer userID);}