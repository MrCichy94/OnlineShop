package pl.cichy.onlineshop.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cichy.onlineshop.model.NotRegisteredOrder;
import pl.cichy.onlineshop.model.repository.NotRegisteredOrderRepository;

@Repository
public interface SqlNotRegisteredOrderRepository extends NotRegisteredOrderRepository, JpaRepository<NotRegisteredOrder, Integer> {

}
