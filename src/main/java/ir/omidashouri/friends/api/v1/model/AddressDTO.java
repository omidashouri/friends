package ir.omidashouri.friends.api.v1.model;

import ir.omidashouri.friends.model.Friend;
import lombok.Data;

@Data
public class AddressDTO {

    private Long id;
    private String street;
    private String city;
    private Friend friend;
}
