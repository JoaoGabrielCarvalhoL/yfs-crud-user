package br.com.yfs.tecnologia.service.impl;

import br.com.yfs.tecnologia.exception.NotFoundException;
import br.com.yfs.tecnologia.model.Address;
import br.com.yfs.tecnologia.repository.AddressRepository;
import br.com.yfs.tecnologia.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address findById(UUID id) {
        Optional<Address> addressResult = addressRepository.findById(id);
        return addressResult.orElseThrow(()-> new NotFoundException("Address not found! Id: " + id));
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteAddressById(UUID id) {
        Optional<Address> addressResult = addressRepository.findById(id);
        if (addressResult.isEmpty()){
            throw new NotFoundException("Address not found! Id: " + id);
        }
        addressRepository.delete(addressResult.get());
    }

    @Override
    public void updateAddress(Address address) {
        saveAddress(address);
    }
}
