package pl.cichy.onlineshop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.cichy.onlineshop.model.Comment;

import java.util.Optional;

public interface CommentService {

    Optional<Comment> findById(Integer id);

    Page<Comment> findAll(Pageable page);

    void deleteById(Integer id);

    Comment save (Comment entity);

    boolean existsById(Integer id);

}
