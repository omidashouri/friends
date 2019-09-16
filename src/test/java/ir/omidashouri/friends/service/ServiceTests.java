package ir.omidashouri.friends.service;

import ir.omidashouri.friends.model.Friend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceTests {



    @Autowired
    FriendService friendService;

    @Test
    public void testCreateReadDelete(){
        Friend friend = new Friend("omidService","ashouriService");

//        TODO::Correct Later

/*        friendService.save(friend);

        Iterable<Friend> friends = friendService.findAll();
        Assertions.assertThat(friends).extracting(Friend::getFirstName).containsOnly("omidService");

        friendService.deleteAll();
        Assertions.assertThat(friendService.findAll()).isEmpty();*/
    }
}
