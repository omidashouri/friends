package ir.omidashouri.friends.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Friend {
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

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;
}
