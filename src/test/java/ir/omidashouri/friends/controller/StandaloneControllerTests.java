package ir.omidashouri.friends.controller;


import ir.omidashouri.friends.controller.v1.FriendController;
import ir.omidashouri.friends.model.Friend;
import ir.omidashouri.friends.service.FriendService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FriendController.class)
public class StandaloneControllerTests {

    @MockBean
    FriendService friendService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateReadDelete() throws Exception{

        Friend friend = new Friend("omidStAlCon","ashouriStAlCon");
        List<Friend> friends = Arrays.asList(friend);
//        TODO::Correct Later
/*
        Mockito.when(friendService.findAll()).thenReturn(friends);

        mockMvc.perform(MockMvcRequestBuilders.get("/friend")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].first-name",Matchers.is("omidStAlCon")));
*/

    }
}
