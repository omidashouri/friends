package ir.omidashouri.friends.bootstrap;

import ir.omidashouri.friends.model.Friend;
import ir.omidashouri.friends.service.FriendServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

@Component
public class DataLoader implements CommandLineRunner {

    private final FriendServiceImpl friendServiceImpl;


    public DataLoader(FriendServiceImpl friendServiceImpl) {
        this.friendServiceImpl = friendServiceImpl;
    }

    @Override
    public void run(String... args) throws Exception {

        long count = StreamSupport.stream(friendServiceImpl.getAllFriends().spliterator(),false).count();

        if (count == 0 ){
            loadData();
        }
    }


    private void loadData() {

        Friend friend = new Friend();
        friend.setFirstName("Ada");
        friend.setLastName("Lovelace");
        friend.setAge(10);
        friend.setMarried(true);



        Friend friend1 = new Friend();
        friend1.setFirstName("Linus");
        friend1.setLastName("Torvalds");
        friend1.setAge(20);
        friend1.setMarried(true);

        Friend friend2 = new Friend();
        friend2.setFirstName("Gordon");
        friend2.setLastName("Moore");
        friend2.setAge(30);
        friend2.setMarried(false);

        friendServiceImpl.saveFriendAndReturnDTO(friend);

        friendServiceImpl.saveFriendAndReturnDTO(friend1);

        friendServiceImpl.saveFriendAndReturnDTO(friend2);

        System.out.println("Loaded Vets....");

    }
}
