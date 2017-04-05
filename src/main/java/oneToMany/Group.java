package oneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "STAR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "group_seq")
    @Column(name = "GROUP_ID", unique = true)
    private Long starId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENRE")

    private String genre;
    @OneToMany(mappedBy = "group")
    private Set<Album> albumSet = new LinkedHashSet<Album>();

    public Group(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

}
