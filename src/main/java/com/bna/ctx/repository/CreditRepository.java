package com.bna.ctx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bna.ctx.model.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Integer>{
}