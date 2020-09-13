package pl.cichy.onlineshop.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.Tick;

import java.util.Optional;

public interface TickRepository {

    Optional<Tick> findById(Integer id);

    Page<Tick> findAll(Pageable page);

    void deleteById(Integer id);

    Tick save (Tick entity);

    boolean existsById(Integer id);

}
