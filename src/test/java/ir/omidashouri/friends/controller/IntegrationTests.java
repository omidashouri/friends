package ir.omidashouri.friends.controller;

import ir.omidashouri.friends.FriendsApplication;
import ir.omidashouri.friends.model.Friend;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.ValidationException;


@RunWith(SpringRunner.class)
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


    @Test(expected = ValidationException.class)
    public void errorHandlingValidationExceptionThrown(){
//        friendController.somethingIsWrong();
    }

}
