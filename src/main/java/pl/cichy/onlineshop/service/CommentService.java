package pl.cichy.onlineshop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.repository.CommentRepository;
import pl.cichy.onlineshop.model.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(final CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Optional<Comment> findById(Integer id){
        return commentRepository.findById(id);
    }

    public Page<Comment> findAll(Pageable page){
        return commentRepository.findAll(page);
    }

    public void deleteById(Integer id){
        commentRepository.deleteById(id);
    }

    public Comment save (Comment entity){
        return commentRepository.save(entity);
    }

    public boolean existsById(Integer id){
        return commentRepository.existsById(id);
    }

}
