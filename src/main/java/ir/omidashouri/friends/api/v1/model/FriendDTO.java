package ir.omidashouri.friends.api.v1.model;

import ir.omidashouri.friends.model.Address;
import lombok.Data;

import java.util.List;

@Data
public class FriendDTO {

    private Long id;
    private String firstName;
    private String lastName;
    int age;
    boolean married;
    List<Address> addresses;
}
