package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cliente;

@Controller
public class ClientesController {
	
	@RequestMapping("/clientes/novo")
	public String novo(Cliente cliente) {
		return "cliente/CadastroCliente"; // Forward encaminha direto e já retorna (Padrão) 
	}
	
	@RequestMapping(value = "/clientes/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes attributes) {  
		if(result.hasErrors()){ // verifica erro
			return novo(cliente);
		}
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
		return "redirect:/clientes/novo"; // Redirect força o navegador a fazer uma nova requisição e começar tudo de novo
	}
	
}