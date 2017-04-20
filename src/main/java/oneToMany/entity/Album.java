package oneToMany.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@Entity
@Table(name = "ALBUM")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALBUM_ID", unique = true)

    private Long albumId;

    @Column(name = "NAME")
    private String nameAlbum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GROUP_ID")
    Group group;

    public Album(String nameAlbum, Group group) {
        this.nameAlbum = nameAlbum;
        this.group = group;
    }
}
