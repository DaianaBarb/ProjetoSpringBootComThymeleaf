package com.mballen.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.mballen.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario , Long> implements FuncionarioDao {

}
