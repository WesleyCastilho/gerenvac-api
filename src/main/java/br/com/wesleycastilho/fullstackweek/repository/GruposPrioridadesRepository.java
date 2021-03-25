package br.com.wesleycastilho.fullstackweek.repository;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wesleycastilho.fullstackweek.domain.GruposPrioridades;

public interface GruposPrioridadesRepository extends JpaRepository<GruposPrioridades, Long>{

}
