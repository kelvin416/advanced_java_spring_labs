package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String user;

    @Column(nullable = false)
    private String posting;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumns({
//            @JoinColumn(name = "comment_activity", referencedColumnName = "activity"),
//            @JoinColumn(name = "comment_likes", referencedColumnName = "likes")
//    })
//    private Set<Comment> comments;
}
