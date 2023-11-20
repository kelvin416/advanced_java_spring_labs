package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String activity;

    @Column(nullable = false)
    private String likes;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "reference_user", referencedColumnName = "user"),
            @JoinColumn(name = "reference_post", referencedColumnName = "posting")
    })
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "user_id", referencedColumnName = "id")
    })
    private User user;
}
