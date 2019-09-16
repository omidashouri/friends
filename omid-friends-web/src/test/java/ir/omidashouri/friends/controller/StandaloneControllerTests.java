package ir.omidashouri.friends.controller;


import ir.omidashouri.friends.service.FriendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


/*@ExtendWith(SpringExtension.class)
@WebMvcTest(FriendController.class)*/
public class StandaloneControllerTests {

    @MockBean
    FriendService friendService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateReadDelete() throws Exception{
//        TODO::Correct Later
/*
        Friend friend = new Friend("omidStAlCon","ashouriStAlCon");
        List<Friend> friends = Arrays.asList(friend);

        Mockito.when(friendService.findAll()).thenReturn(friends);

        mockMvc.perform(MockMvcRequestBuilders.get("/friend")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].first-name",Matchers.is("omidStAlCon")));
*/

    }
}
