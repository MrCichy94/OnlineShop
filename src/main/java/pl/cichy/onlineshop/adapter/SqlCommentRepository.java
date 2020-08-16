package pl.cichy.onlineshop.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.repository.CommentRepository;

import java.util.List;


@Repository
public interface SqlCommentRepository extends CommentRepository, JpaRepository<Comment, Integer> {




/*
    public Comment addComment(Comment comment) {
        listOfComments.add(comment);
        return comment;
    }

    public Comment addComm(Comment comment) {
        listOfComments.add(comment);
        return comment;
    }

    public List<Comment> readAllComments() {
        return listOfComments;
    }

 */


}
