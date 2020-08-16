package pl.cichy.onlineshop.service.implementation;

import org.springframework.stereotype.Service;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.repository.CommentRepository;
import pl.cichy.onlineshop.service.CommentService;
import java.util.List;


public class CommentServiceImpl{

    //@Autowired
    private final CommentRepository commentRepository;

    public CommentServiceImpl(final CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


}
