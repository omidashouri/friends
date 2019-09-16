package ir.omidashouri.friends.service;

import ir.omidashouri.friends.api.v1.mapper.AddressMapper;
import ir.omidashouri.friends.controller.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressMapper addressMapper;
    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressMapper addressMapper, AddressRepository addressRepository) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }
}
