package ir.omidashouri.friends.api.v1.mapper;

import ir.omidashouri.friends.api.v1.model.AddressDTO;
import ir.omidashouri.friends.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO AddresstoAddressDTO(Address address);

    Address AddressDtoToAddress(AddressDTO addressDTO);
}
