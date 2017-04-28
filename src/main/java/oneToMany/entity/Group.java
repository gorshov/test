package oneToMany.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "MUSIC_GROUP")
@EqualsAndHashCode(exclude = {"albumSet"})
@ToString(exclude = {"albumSet"})
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID", unique = true)
    private Long groupId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENRE")
    private String genre;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Album> albumSet = new LinkedList<Album>();

    public Group(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public Group() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Album> getAlbumSet() {
        return albumSet;
    }

    public void setAlbumSet(List<Album> albumSet) {
        this.albumSet = albumSet;
    }
}
