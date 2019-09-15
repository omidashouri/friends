package ir.omidashouri.friends.service;

import ir.omidashouri.friends.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressService extends CrudRepository<Address,Integer> {

}
