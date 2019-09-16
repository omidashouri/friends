package ir.omidashouri.friends.controller;

import ir.omidashouri.friends.FriendsApplication;
import ir.omidashouri.friends.controller.v1.FriendController;
import ir.omidashouri.friends.model.Friend;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.xml.bind.ValidationException;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {FriendsApplication.class})
public class IntegrationTests {


//    in this test application should not be in RUNNING mode

    @Autowired
    FriendController friendController;

    @Test
    public void testCreateReadDelete(){
        Friend friend = new Friend("omidT2","ashouriT2");
//        TODO::Correct Later
/*        Friend friendResult = friendController.create(friend);

        Iterable<Friend> friends = friendController.read();
        Assertions.assertThat(friends).first().hasFieldOrPropertyWithValue("firstName","omidT2");

        friendController.delete(friendResult.getId());
        Assertions.assertThat(friendController.read()).isEmpty();*/
    }


    @Test
    public void errorHandlingValidationExceptionThrown(){
       org.junit.jupiter.api.Assertions.assertThrows(ValidationException.class,()->friendController.somethingIsWrong());
    }

}
