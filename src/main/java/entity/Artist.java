package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ARTIST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ARTIST_ID", unique = true)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENRE")
    private String genre;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "artist", cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    private Website website;

}
