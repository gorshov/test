package oneToMany;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


@NoArgsConstructor
@Entity
@Table(name = "MUSIC_GROUP")
@EqualsAndHashCode(exclude = {"albumSet"})
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
    private Set<Album> albumSet = new LinkedHashSet<Album>();

    public Group(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

}
