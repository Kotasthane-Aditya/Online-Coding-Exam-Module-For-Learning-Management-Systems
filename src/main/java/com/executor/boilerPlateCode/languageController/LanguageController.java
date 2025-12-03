package com.executor.boilerPlateCode.languageController;

import com.executor.boilerPlateCode.languageModel.LanguageModel;
import com.executor.boilerPlateCode.languageRepository.LanguageRepo;
import com.executor.boilerPlateCode.languageService.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;
    @Autowired
    private LanguageRepo languageRepo;

    @PostMapping
    public String saveLanguage(@RequestBody LanguageModel language) {
        int id = language.getQid();
        Optional<LanguageModel> existingLanguage = languageRepo.findById(id);
        if (existingLanguage.isPresent()) {
            return "failed to add / already exists";
        } else {
            return languageService.saveLanguage(language);
        }
    }

    @GetMapping
    public List<LanguageModel> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @GetMapping("/{id}")
    public LanguageModel getLanguageById(@PathVariable Integer id) {
        return languageService.getLanguageById(id);
    }

    @PutMapping("/{id}")
    public LanguageModel updateLanguage(@PathVariable Integer id, @RequestBody LanguageModel language) {
        return languageService.updateLanguage(id, language);
    }

    @DeleteMapping("/{id}")
    public String deleteLanguage(@PathVariable Integer id) {
        languageService.deleteLanguage(id);
        return "Language entry deleted!";
    }
}
