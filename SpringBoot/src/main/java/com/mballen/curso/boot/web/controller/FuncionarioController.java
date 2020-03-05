package com.mballen.curso.boot.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mballen.curso.boot.domain.Cargo;
import com.mballen.curso.boot.domain.Funcionario;
import com.mballen.curso.boot.domain.UF;
import com.mballen.curso.boot.service.CargoService;
import com.mballen.curso.boot.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	@Autowired
	private FuncionarioService service;
	@Autowired
private	CargoService cargoservice;
	
	
	@GetMapping("/cadastrar")
public String cadastrar(Funcionario funcionario) {
	return"/funcionario/cadastro";
}
	@GetMapping("/listar")
public String listar(ModelMap model) {
		model.addAttribute("funcionarios", service.buscarTodos());
	return "/funcionario/lista";
}
	
	@PostMapping("/salvar")
	public String Salvar(Funcionario funcionario, RedirectAttributes att){
		
		service.salvar(funcionario);
		att.addFlashAttribute("success","salvo com sucesso");
		return "redirect:/funcionarios/cadastrar";
	}
	//ATENÇAO NESTA ANOTAÇÃO E DIFERNETE DAS DEMAIS
	@ModelAttribute("cargos")
	public List<Cargo> getCargos(){
		return cargoservice.buscarTodos();
	}
	@ModelAttribute("ufs")
	public UF[]getUFs(){
		return UF.values();
	}
}
