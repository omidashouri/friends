package ir.omidashouri.friends;

import ir.omidashouri.friends.model.Friend;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
        public class SystemTests {

    //    in this test application should be RUNNING

/*    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Friend friend;*/

    @Test
    public void testCreateReloadDelete(){

        RestTemplate restTemplate = new RestTemplate();
        Friend friend = new Friend("omidT1","ashouriT1");

        String url = "http://localhost:8080/friend";

        ResponseEntity<Friend> friendResponseEntity = restTemplate.postForEntity(url,friend,Friend.class);

        Friend[] friends = restTemplate.getForObject(url,Friend[].class);
//        correect with junit 5
//        Assertions.assertThat(friends).extracting(Friend::getFirstName).containsOnly("omidT1");

        restTemplate.delete(url+"/"+friendResponseEntity.getBody().getId());
//        Assertions.assertThat(restTemplate.getForObject(url,Friend[].class)).isEmpty();

    }


    public void testErrorHandlingReturnsBadRequest(){
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/wrong";

        try{
            restTemplate.getForEntity(url,String.class);
        }catch (HttpClientErrorException e){
            Assertions.assertEquals(HttpStatus.BAD_REQUEST,e.getStatusCode());
        }

    }

}
