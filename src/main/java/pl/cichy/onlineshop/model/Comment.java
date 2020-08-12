package pl.cichy.onlineshop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table( name = "comments")
public class Comment {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;

    @NotBlank(message = "Nie pusty NICK!")
    private String name;

    @NotBlank(message = "Nie pusty KOMENTARZ!")
    private String commText;

    public Comment() {
    }

    public Comment(String name, String commText) {
        this.name = name;
        this.commText = commText;
    }
}
