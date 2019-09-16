package ir.omidashouri.friends.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tbl_Friend",schema = "friends")
public class Friend extends BaseEntity{




    @Builder
    public Friend(Long id, @NotBlank String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Friend(@NotBlank String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="friend_seq")
        @SequenceGenerator(
                name="friend_seq",
                sequenceName="friend_sequence",
                allocationSize=20
        )*/

    @NotBlank
    @JsonProperty("first-name")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @JsonProperty("last-name")
    @Column(name = "LAST_NAME")
    private String lastName;

    int age;

//    @JsonIgnore
    boolean married;


    /*
    //to connect to friend in address pojo
    @JsonManagedReference
    @OneToMany(mappedBy = "friend",cascade = CascadeType.ALL)*/
    @OneToMany(cascade = CascadeType.ALL)
    List<Address> addresses;
}
