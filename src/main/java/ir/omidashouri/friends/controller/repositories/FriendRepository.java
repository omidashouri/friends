package ir.omidashouri.friends.controller.repositories;

import ir.omidashouri.friends.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend,Long> {

    Friend findByFirstName(String firstName);
    Friend findByLastName(String lastName);
    Friend findByFirstNameAndLastName(String firstName, String lastName);
//    Friend save(Friend friend);

}
