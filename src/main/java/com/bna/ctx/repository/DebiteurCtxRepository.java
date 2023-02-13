package com.bna.ctx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bna.ctx.model.DebiteurCtx;

@Repository
public interface DebiteurCtxRepository extends JpaRepository<DebiteurCtx, Integer>{

	List<DebiteurCtx> findByEtatCtxContaining(String string);

	DebiteurCtx findByLesRisquesNumRisque(int numRisque);
}
