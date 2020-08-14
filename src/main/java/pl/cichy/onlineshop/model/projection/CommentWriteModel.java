package pl.cichy.onlineshop.model.projection;

import lombok.Getter;
import lombok.Setter;
import pl.cichy.onlineshop.model.Comment;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;

@Getter
@Setter
public class CommentWriteModel {

    @NotBlank(message = "Nie pusty NICK!")
    private String name;

    @NotBlank(message = "Nie pusty KOMENTARZ!")
    private String commText;

    public CommentWriteModel() {
    }

    public Comment toComment(){
        var result = new Comment();
        result.setName(name);
        result.setCommText(commText);
        return result;
    }
}
