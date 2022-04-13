package sbtl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sbtl.model.Uebung;
import sbtl.repository.FitRepository;

@Controller
public class FitController {

	@Autowired
	FitRepository fR;
	
    @GetMapping("/signup")
    public String showSignUpForm(Uebung uebung) {
        return "add-uebung";
    }
    	
    @PostMapping("/adduebung")
    public String addUebung(@Valid Uebung uebung, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-uebung";
        }
        
        fR.save(uebung);
        return "redirect:/index";
    }
    
    @GetMapping("/index")
    public String showUebungenList(Model model) {
        model.addAttribute("uebungen", fR.findAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Uebung uebung = fR.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
        
        model.addAttribute("uebung", uebung);
        return "update-uebung";
    }
    @PostMapping("/update/{id}")
    public String updateUebung(@PathVariable("id") long id, @Valid Uebung uebung, 
      BindingResult result, Model model) {
        if (result.hasErrors()) {
            uebung.setId(id);
            return "update-uebung";
        }
            
        fR.save(uebung);
        return "redirect:/index";
    }
        
    @GetMapping("/delete/{id}")
    public String deleteUebung(@PathVariable("id") long id, Model model) {
        Uebung uebung = fR.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
        fR.delete(uebung);
        return "redirect:/index";
    }

}
