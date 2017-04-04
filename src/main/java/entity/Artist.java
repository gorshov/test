package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ARTIST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ARTIST_ID", unique = true)
    private Long id;

    public Artist(Long id, String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.id = id;
    }

    public Artist(String name, String genre, Website website) {
        this.name = name;
        this.genre = genre;
        this.website = website;
    }

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENRE")
    private String genre;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "artist", cascade = CascadeType.ALL)
    private Website website;

}
