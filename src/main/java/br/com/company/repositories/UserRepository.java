package br.com.company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.company.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
