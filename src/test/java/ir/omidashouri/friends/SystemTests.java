package ir.omidashouri.friends;

import ir.omidashouri.friends.model.Friend;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
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
        Assertions.assertThat(friends).extracting(Friend::getFirstName).containsOnly("omidT1");

        restTemplate.delete(url+"/"+friendResponseEntity.getBody().getId());
        Assertions.assertThat(restTemplate.getForObject(url,Friend[].class)).isEmpty();

    }


    public void testErrorHandlingReturnsBadRequest(){
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/wrong";

        try{
            restTemplate.getForEntity(url,String.class);
        }catch (HttpClientErrorException e){
            Assert.assertEquals(HttpStatus.BAD_REQUEST,e.getStatusCode());
        }

    }

}
