package com.bna.ctx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bna.ctx.model.Frais;
import com.bna.ctx.model.Risque;

@Repository
public interface FraisRepository  extends JpaRepository<Frais, Integer>{

	List<Frais> findByEtatFraisContaining(String string);

	List<Frais> findByRisqueNumRisque(int id);

}
