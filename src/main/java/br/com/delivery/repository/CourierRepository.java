package br.com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.delivery.entity.Courier;

@Repository
public interface CourierRepository extends JpaRepository<Courier, String>{

}
