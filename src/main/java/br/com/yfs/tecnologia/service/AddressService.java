package br.com.yfs.tecnologia.service;

import br.com.yfs.tecnologia.model.Address;

import java.util.List;
import java.util.UUID;

public interface AddressService {

    void saveAddress(Address address);
    Address findById(UUID id);
    List<Address> findAll();
    void deleteAddressById(UUID id);
    void updateAddress(Address address);

}
