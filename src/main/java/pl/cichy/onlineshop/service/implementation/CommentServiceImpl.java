package pl.cichy.onlineshop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.projection.CommentWriteModel;
import pl.cichy.onlineshop.model.repository.CommentRepository;
import pl.cichy.onlineshop.model.repository.ProductRepository;
import pl.cichy.onlineshop.service.CommentService;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    //@Autowired
    private final CommentRepository commentRepository;

    public CommentServiceImpl(final CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addComment(Comment comment){
        return commentRepository.addComment(comment);
    }

    public List <Comment> readAllComments(){
        return commentRepository.readAllComments();
    }

    public Comment addComm(CommentWriteModel toSave) {
        return commentRepository.addComm(toSave.toComment());
    }
}
