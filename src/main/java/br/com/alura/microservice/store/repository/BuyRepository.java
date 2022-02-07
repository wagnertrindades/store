package br.com.alura.microservice.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.store.model.Buy;

@Repository
public interface BuyRepository extends CrudRepository<Buy, Long> {

}
