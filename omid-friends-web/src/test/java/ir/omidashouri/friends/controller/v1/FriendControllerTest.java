package ir.omidashouri.friends.controller.v1;

import ir.omidashouri.friends.api.v1.mapper.FriendMapper;
import ir.omidashouri.friends.api.v1.model.FriendDTO;
import ir.omidashouri.friends.model.Friend;
import ir.omidashouri.friends.service.FriendServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({MockitoExtension.class})
class FriendControllerTest {

    @Mock
    FriendServiceImpl friendServiceImpl;

    FriendMapper friendMapper;

    @InjectMocks
    FriendController friendController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        friendMapper = FriendMapper.INSTANCE;

        mockMvc = MockMvcBuilders.standaloneSetup(friendController).build();

    }

    @Test
    void create() {
    }

    @Test
    void read() throws Exception {
//        given
        Friend friend1 = Friend.builder()
                .id(1L)
                .firstName("Ada")
                .lastName("Lovelace")
                .build();

        FriendDTO friendDTO1 = friendMapper.friendToFriendDTO(friend1);

        Friend friend2 = Friend.builder()
                .id(1L)
                .firstName("Linus")
                .lastName("Torvalds")
                .build();

        FriendDTO friendDTO2 = friendMapper.friendToFriendDTO(friend2);

//        when
        when(friendServiceImpl.getAllFriends()).thenReturn(Arrays.asList(friendDTO1,friendDTO2));

//        result
        mockMvc.perform(get("/friend")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].firstName", Matchers.is("Ada")))
                .andExpect(jsonPath("$[1].lastName", equalToIgnoringCase("Torvalds")))
                .andReturn().getResponse().getContentAsString();


    }


}