package oneToMany;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@Entity
@Table(name = "ALBUM")
@NoArgsConstructor
@ToString
@Component
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALBUM_ID", unique = true)
    @Getter
    @Setter
    private Long albumId;

    @Column(name = "NAME")
    @Getter
    @Setter
    private String nameAlbum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GROUP_ID")
    @Getter
    @Setter
    Group group;

    public Album(String nameAlbum, Group group) {
        this.nameAlbum = nameAlbum;
        this.group = group;
    }
}
