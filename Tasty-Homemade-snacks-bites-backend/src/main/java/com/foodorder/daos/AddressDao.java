package com.foodorder.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodorder.entities.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

}
