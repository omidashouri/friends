package ir.omidashouri.friends.service;

import ir.omidashouri.friends.model.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendService extends CrudRepository<Friend,Integer> {

/*    void save();
    List<Friend> findAll();
    void deleteFriendById();*/

    Iterable<Friend> findByFirstNameAndLastName(String firstName,String lastName);
    Iterable<Friend> findByFirstName(String firstName);
    Iterable<Friend> findByLastName(String lastName);

}
