package br.com.yfs.tecnologia.repository;

import br.com.yfs.tecnologia.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
