package com.example.CourseTest.contoller;

import com.example.CourseTest.model.Technique;
import com.example.CourseTest.repository.TechniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/technique")
public class TechniqueController {
    private final TechniqueRepository techniqueRepository;

    @Autowired
    public TechniqueController(TechniqueRepository techniqueRepository) {
        this.techniqueRepository = techniqueRepository;
    }

    @GetMapping("/list")
    public String listTechnique(Model model) {
        List<Technique> list = techniqueRepository.findAll();
        model.addAttribute("techniques", list);
        return "list-techniques";
    }

    @GetMapping("/details/{id}")
    public String detailsTechnique(@PathVariable Long id, Model model) {
        Technique technique = techniqueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Техника с id=" + id + " не найдена."));
        model.addAttribute("technique", technique);
        return "details-technique";
    }
}
