package oneToMany;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;



@AllArgsConstructor
@Entity
@Table(name = "ALBUM")
@NoArgsConstructor
@ToString
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

}
