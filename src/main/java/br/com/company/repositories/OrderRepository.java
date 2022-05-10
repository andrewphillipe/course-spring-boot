package br.com.company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.company.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
