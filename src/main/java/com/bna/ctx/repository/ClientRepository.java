package com.bna.ctx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bna.ctx.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	List<Client> findByEtatClientNotContaining(String string);

}