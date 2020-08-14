package pl.cichy.onlineshop.model.repository.implementation;

import org.springframework.stereotype.Repository;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.Product;
import pl.cichy.onlineshop.model.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCommentRepository implements CommentRepository {

    private CommentRepository commentRepository;

    private final List<Comment> listOfComments = new ArrayList<Comment>();

    public InMemoryCommentRepository () {

        Comment comm1 = new Comment();
        comm1.setName("Autor aplikacji");
        comm1.setCommText("Bardzo ładne i stylowe! Polecam! :D");

        listOfComments.add(comm1);
    }

    public Comment addComment(Comment comment) {
        listOfComments.add(comment);
        return comment;
    }

    public Comment addComm(Comment comment) {
        listOfComments.add(comment);
        return comment;
    }

    public List <Comment> readAllComments() {
        return listOfComments;
    }

}
