package pl.cichy.onlineshop.model.projection;

import lombok.Getter;
import lombok.Setter;
import pl.cichy.onlineshop.model.Comment;

@Getter
@Setter
public class CommentReadModel {

    private int id;
    private String name;
    private String commText;

    public CommentReadModel(Comment source) {
        id = source.getId();
        name = source.getName();
        commText = source.getCommText();
    }
}
