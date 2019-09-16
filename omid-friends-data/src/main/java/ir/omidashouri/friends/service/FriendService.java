package ir.omidashouri.friends.service;

import ir.omidashouri.friends.api.v1.model.FriendDTO;
import ir.omidashouri.friends.model.Friend;

import java.util.List;

public interface FriendService {

/*    void save();
    List<Friend> findAll();
    void deleteFriendById();*/

    List<FriendDTO> getAllFriends();

    FriendDTO getFriendByName(String name);

    FriendDTO saveFriendAndReturnDTO(Friend friend);

/*    Iterable<Friend> findByFirstNameAndLastName(String firstName, String lastName);
    Iterable<Friend> findByFirstName(String firstName);
    Iterable<Friend> findByLastName(String lastName);*/

}
