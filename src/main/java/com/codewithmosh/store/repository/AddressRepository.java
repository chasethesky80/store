package com.codewithmosh.store.repository;

import com.codewithmosh.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
