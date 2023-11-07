package com.example.CourseTest.contoller;

import com.example.CourseTest.model.Technique;
import com.example.CourseTest.repository.TechniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/technique/add")
public class AddTechniqueController {
    private final TechniqueRepository techniqueRepository;

    @Autowired
    public AddTechniqueController(TechniqueRepository techniqueRepository) {
        this.techniqueRepository = techniqueRepository;
    }

    @GetMapping
    public String formAddedTechnique(Model model) {
        model.addAttribute("technique", new Technique());
        return "form-add-techniques";
    }

    @PostMapping
    public String добавлениеТехники(@ModelAttribute Technique technique) {
        techniqueRepository.save(technique);
        return "redirect:/technique/list";
    }
}
