package com.barretto.agendamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barretto.agendamento.modelo.Agendamento;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

	
}
