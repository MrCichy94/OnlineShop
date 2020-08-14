package pl.cichy.onlineshop.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.projection.CommentWriteModel;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Comment addComment(Comment comment);

    Comment addComm(Comment entity);

    List<Comment> readAllComments();

}
