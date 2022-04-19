package sbtl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sbtl.model.Tag;
import sbtl.repository.FitRepository;

@Controller
public class FitController {

	@Autowired
	FitRepository fR;
	
    @GetMapping("/signup")
    public String showSignUpForm(Tag tag) {
        return "add-tagName";
    }
    
    @GetMapping("/showLabel")
    public String showLabelForm(Tag tag) {
        return "add-tag";
    }
    	
    @PostMapping("/addtag")
    public String addUebung(@Valid Tag tag, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-tag";
        }
        
        fR.save(tag);
        return "redirect:/index";
    }
   	
   
    //Muss man noch anpassen, bzw. / direkt auf index weiterleiten
    @GetMapping("/")
    public String showUebungenList1(Model model) {
        model.addAttribute("tage", fR.findAll());
        return "index";
    }
    @GetMapping("/index")
    public String showUebungenList(Model model) {
        model.addAttribute("tage", fR.findAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Tag tag = fR.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
        
        model.addAttribute("tag", tag);
        return "update-tag";
    }
    @PostMapping("/update/{id}")
    public String updateTag(@PathVariable("id") long id, @Valid Tag tag, 
      BindingResult result, Model model) {
        if (result.hasErrors()) {
            tag.setId(id);
            return "update-tag";
        }
            
        fR.save(tag);
        return "redirect:/index";
    }
        
    @GetMapping("/delete/{id}")
    public String deleteUebung(@PathVariable("id") long id, Model model) {
        Tag tag = fR.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
        fR.delete(tag);
        return "redirect:/index";
    }

}
