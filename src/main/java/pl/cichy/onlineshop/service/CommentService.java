package pl.cichy.onlineshop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.projection.CommentWriteModel;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Comment addComment(Comment comment);

    Comment addComm(CommentWriteModel entity);

    List <Comment> readAllComments();

}
