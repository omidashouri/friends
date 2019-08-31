package ir.omidashouri.friends.controller;

import ir.omidashouri.friends.model.Friend;
import ir.omidashouri.friends.service.FriendService;
import ir.omidashouri.friends.util.ErrorMessage;
import ir.omidashouri.friends.util.FieldErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FriendController {

    FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @PostMapping("/friend1")
    Friend create1(@RequestBody Friend friend) throws ValidationException {
        if(friend.getId() !=0 && friend.getFirstName() != null && friend.getLastName() != null)
            return friendService.save(friend);
        else
            throw  new ValidationException("friend cannot be created");
    }


    @PostMapping("/friend")
    Friend create(@Valid @RequestBody Friend friend)  {
            return friendService.save(friend);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors
                                                        .stream()
                                                        .map(fieldError -> new FieldErrorMessage(fieldError.getField(),fieldError.getDefaultMessage()))
                                                        .collect(Collectors.toList());
        return fieldErrorMessages;
    }

    @GetMapping("/friend")
    Iterable<Friend> read(){
        return friendService.findAll();
    }

    @PutMapping("/friend")
    ResponseEntity<Friend> update(@RequestBody Friend friend){
        if(friendService.findById(friend.getId()).isPresent())
            return new ResponseEntity<>(friendService.save(friend), HttpStatus.OK);
        else
            return new ResponseEntity<>(friend,HttpStatus.BAD_REQUEST);
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
