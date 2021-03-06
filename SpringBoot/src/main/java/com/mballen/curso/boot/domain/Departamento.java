package com.mballen.curso.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
@SuppressWarnings("serial")
@Entity
@Table(name="DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {
	@Column(name="nome", nullable = false, unique=true, length=60)
private String nome;
@OneToMany(mappedBy="departamento" ) //chave estrangeira 1 para muitos cargos
private List<Cargo> cargos;
public String getNome() {
	return nome;
}

public List<Cargo> getCargos() {
	return cargos;
}

public void setCargos(List<Cargo> cargos) {
	this.cargos = cargos;
}

public void setNome(String nome) {
	this.nome = nome;
}

}
