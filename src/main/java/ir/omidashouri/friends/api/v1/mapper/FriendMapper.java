package ir.omidashouri.friends.api.v1.mapper;

import ir.omidashouri.friends.api.v1.model.FriendDTO;
import ir.omidashouri.friends.model.Friend;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FriendMapper {

    FriendMapper INSTANCE = Mappers.getMapper(FriendMapper.class);

    FriendDTO friendToFriendDTO(Friend friend);

    Friend FriendDtoToFriend(FriendDTO friendDTO);

}
