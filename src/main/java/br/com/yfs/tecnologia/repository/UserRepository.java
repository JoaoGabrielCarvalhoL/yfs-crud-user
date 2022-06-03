package br.com.yfs.tecnologia.repository;

import br.com.yfs.tecnologia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
