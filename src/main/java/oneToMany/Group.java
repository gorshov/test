package oneToMany;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


@NoArgsConstructor
@Entity
@Table(name = "MUSIC_GROUP")
@EqualsAndHashCode(exclude = {"albumSet"})
@ToString
@Component
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID", unique = true)
    @Getter
    @Setter
    private Long groupId;

    @Column(name = "NAME")
    @Getter
    @Setter
    private String name;

    @Column(name = "GENRE")
    @Getter
    @Setter
    private String genre;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Album> albumSet = new LinkedList<Album>();

    public Group(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

}
