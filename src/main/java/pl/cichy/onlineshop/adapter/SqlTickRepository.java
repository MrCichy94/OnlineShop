package pl.cichy.onlineshop.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.Tick;
import pl.cichy.onlineshop.model.repository.CommentRepository;
import pl.cichy.onlineshop.model.repository.TickRepository;

@Repository
public interface SqlTickRepository extends TickRepository, JpaRepository<Tick, Integer> {
}
