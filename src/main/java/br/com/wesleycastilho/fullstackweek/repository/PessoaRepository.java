package br.com.wesleycastilho.fullstackweek.repository;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wesleycastilho.fullstackweek.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
