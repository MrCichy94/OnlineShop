package pl.cichy.onlineshop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.repository.CommentRepository;
import pl.cichy.onlineshop.service.CommentService;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Optional<Comment> findById(Integer id) {
        return commentRepository.findById(id);
    }

    public Page<Comment> findAll(Pageable page) {
        return commentRepository.findAll(page);
    }

    public void deleteById(Integer id) {
        commentRepository.deleteById(id);
    }

    public Comment save(Comment entity) {
        return commentRepository.save(entity);
    }

    public boolean existsById(Integer id) {
        return commentRepository.existsById(id);
    }
}
