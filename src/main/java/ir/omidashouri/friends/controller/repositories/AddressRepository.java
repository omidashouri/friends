package ir.omidashouri.friends.controller.repositories;

import ir.omidashouri.friends.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
