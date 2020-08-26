package pl.cichy.onlineshop.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.cichy.onlineshop.model.NotRegisteredOrder;

import java.util.Optional;

public interface NotRegisteredOrderRepository {

    Optional<NotRegisteredOrder> findById(Integer id);

    Page<NotRegisteredOrder> findAll(Pageable page);

    void deleteById(Integer id);

    NotRegisteredOrder save (NotRegisteredOrder entity);

    boolean existsById(Integer id);
}
