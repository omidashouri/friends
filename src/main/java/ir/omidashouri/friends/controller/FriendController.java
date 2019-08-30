package ir.omidashouri.friends.controller;

import ir.omidashouri.friends.model.Friend;
import ir.omidashouri.friends.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FriendController {

    FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @PostMapping("/friend")
    Friend create(@RequestBody Friend friend){
        return friendService.save(friend);
    }

    @GetMapping("/friend")
    Iterable<Friend> read(){
        return friendService.findAll();
    }

    @PutMapping("/friend")
    Friend update(@RequestBody Friend friend){
        return friendService.save(friend);
    }

    @DeleteMapping("/friend/{id}")
    void delete(@PathVariable Integer id){
        friendService.deleteById(id);
    }


    @GetMapping("/friend/{id}")
    Optional<Friend> findById(@PathVariable Integer id){
        return friendService.findById(id);
    }

    @GetMapping("/friend/search")
    Iterable<Friend> findByQuery(
            @RequestParam(value = "first", required = false) String firstName,
            @RequestParam(value = "last", required = false) String lastName){
        if(null !=firstName && null != lastName)
        return friendService.findByFirstNameAndLastName(firstName,lastName);
        else if(null !=firstName)
            return friendService.findByFirstName(firstName);
        else if(null!=lastName)
            return friendService.findByLastName(lastName);
        else
            return friendService.findAll();
    }





}
