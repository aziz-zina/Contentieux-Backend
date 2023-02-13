package com.bna.ctx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bna.ctx.model.DebiteurCtx;
import com.bna.ctx.model.Risque;

@Repository
public interface RisqueRepository extends JpaRepository<Risque, Integer>{

	List<DebiteurCtx> findByDebiteurCtxNumCtx(int numRisque);
}
