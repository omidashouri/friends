package ir.omidashouri.friends;

import ir.omidashouri.friends.controller.FriendController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FriendsApplicationTests {

    @Autowired
    FriendController friendController;

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(friendController);
        System.out.println("Test Junit 5");
    }

}
