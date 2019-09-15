package ir.omidashouri.friends.controller;

import ir.omidashouri.friends.FriendsApplication;
import ir.omidashouri.friends.model.Friend;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {FriendsApplication.class})
public class IntegrationTests {


//    in this test application should not be in RUNNING mode

    @Autowired
    FriendController friendController;

    @Test
    public void testCreateReadDelete(){
        Friend friend = new Friend("omidT2","ashouriT2");

        Friend friendResult = friendController.create(friend);

        Iterable<Friend> friends = friendController.read();
        Assertions.assertThat(friends).first().hasFieldOrPropertyWithValue("firstName","omidT2");

        friendController.delete(friendResult.getId());
        Assertions.assertThat(friendController.read()).isEmpty();
    }

//  check later
//    @Test(expected = ValidationException.class)
    public void errorHandlingValidationExceptionThrown(){
//        friendController.somethingIsWrong();
    }

}
