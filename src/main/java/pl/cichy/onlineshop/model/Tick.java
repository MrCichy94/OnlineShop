package pl.cichy.onlineshop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table( name = "ticks")
public class Tick {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;

    private LocalDateTime dateTick = LocalDateTime.now();

    public Tick() {
    }

    public Tick(LocalDateTime dateTick) {
        this.dateTick = dateTick;
    }
}
