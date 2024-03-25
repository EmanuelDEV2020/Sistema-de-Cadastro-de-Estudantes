package com.fourcatsdev.entitycrud.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fourcatsdev.entitycrud.modelo.Area;
import com.fourcatsdev.entitycrud.modelo.Estudante;
import com.fourcatsdev.entitycrud.servico.AreaServico;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/area")
public class AreaControle {
	
	@Autowired
	private AreaServico areaServico;
	
	@GetMapping("/novo")
	public String novoArea(Model model) {
		Area area = new Area();
		model.addAttribute("novoArea" ,area);
		return "/novo-area";
	}
	@PostMapping("/gravar")
	public String gravarArea(@ModelAttribute("novoArea") @Valid Area area,
			BindingResult erros,
			RedirectAttributes attributes) {
		if (erros.hasErrors()) {
			return "/novo-area";						
		}
		
		areaServico.gravar(area);
		attributes.addFlashAttribute("mensagem", "Área salvo com sucesso!");
		return "redirect:/area/novo";
		
	}

}
