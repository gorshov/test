package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


@Data
@AllArgsConstructor
@Entity
@Table(name = "WEBSITE")
@NoArgsConstructor
public class Website {

    @Id
    @GenericGenerator(name = "one", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "artist"))
    @GeneratedValue(generator = "one")
    @Column(name = "WEBSITE_ID")
    private Long id;

    public Website(Long id, String url) {
        this.url = url;
        this.id = id;
    }

    @Column(name = "URL")
    private String url;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    Artist artist;

}
