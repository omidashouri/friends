package ir.omidashouri.friends.service;

import ir.omidashouri.friends.api.v1.mapper.FriendMapper;
import ir.omidashouri.friends.api.v1.model.FriendDTO;
import ir.omidashouri.friends.controller.repositories.FriendRepository;
import ir.omidashouri.friends.model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendServiceImpl implements FriendService {

    private FriendMapper friendMapper;
    private FriendRepository friendRepository;

    @Autowired
    public FriendServiceImpl(FriendMapper friendMapper, FriendRepository friendRepository) {
        this.friendMapper = friendMapper;
        this.friendRepository = friendRepository;
    }

    @Override
    public List<FriendDTO> getAllFriends() {
        return friendRepository.findAll()
                .stream()
                .map(friendMapper::friendToFriendDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FriendDTO getFriendByName(String firstName) {
        return friendMapper.friendToFriendDTO(friendRepository.findByFirstName(firstName));
    }

    @Override
    public FriendDTO saveFriendAndReturnDTO(Friend friend) {
        return friendMapper.friendToFriendDTO(friendRepository.save(friend));
    }
}
