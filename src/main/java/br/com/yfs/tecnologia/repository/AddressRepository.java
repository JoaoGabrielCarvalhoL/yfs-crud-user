package br.com.yfs.tecnologia.repository;

import br.com.yfs.tecnologia.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

}
