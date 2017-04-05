package oneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@Entity
@Table(name = "ALBUM")
@NoArgsConstructor
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ALBUM_ID", unique = true)
    private Long albumId;

    @Column(name = "URL")
    private String url;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "GROUP_ID")
    Group group;

}
