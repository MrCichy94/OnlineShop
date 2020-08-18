package pl.cichy.onlineshop.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.repository.CommentRepository;

@Repository
public interface SqlCommentRepository extends CommentRepository, JpaRepository<Comment, Integer> {

}
