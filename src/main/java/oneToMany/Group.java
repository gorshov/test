package oneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "MUSIC_GROUP")
@EqualsAndHashCode(exclude = {"albumSet"})
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "GROUP_ID", unique = true)
    private Long groupId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENRE")

    private String genre;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<Album> albumSet = new LinkedHashSet<Album>();

    public Group(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

}
