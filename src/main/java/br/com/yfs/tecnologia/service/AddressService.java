package br.com.yfs.tecnologia.service;

import br.com.yfs.tecnologia.model.Address;

import java.util.List;

public interface AddressService {

    void saveAddress(Address address);

    Address findById(Long id);

    List<Address> findAll();

    void deleteAddressById(Long id);

    void updateAddress(Long id, Address address);

}
