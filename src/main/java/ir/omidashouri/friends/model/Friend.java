package ir.omidashouri.friends.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Friend {


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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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
