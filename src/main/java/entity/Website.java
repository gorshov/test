package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WEBSITE")
public class Website {

    @Id
    @GenericGenerator(name = "one", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "artist"))
    @GeneratedValue(generator = "one")
    @Column(name = "WEBSITE_ID")
    @Access(AccessType.PROPERTY)
    private Long id;

    @Column(name = "URL")
    private String url;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @Access(AccessType.PROPERTY)

    Artist artist;

}
