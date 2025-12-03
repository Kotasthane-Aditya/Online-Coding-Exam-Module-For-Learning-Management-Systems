package com.executor.boilerPlateCode.languageService;

import com.executor.boilerPlateCode.languageModel.LanguageModel;
import com.executor.boilerPlateCode.languageRepository.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepo languageRepo;

    @Override
    public String saveLanguage(LanguageModel language) {
      //  if(languageRepo.existsById(language.getQid())){
            System.out.println("language 2" + language);
             languageRepo.save(language);
             return  "question added";
       // }else {

         //   return "save";
     //   }
    }

    @Override
    public List<LanguageModel> getAllLanguages() {
        return languageRepo.findAll();
    }

    @Override
    public LanguageModel getLanguageById(Integer id) {
        return languageRepo.findById(id).orElse(null);
    }

    @Override
    public LanguageModel updateLanguage(Integer id, LanguageModel updatedLanguage) {
        Optional<LanguageModel> existingLanguage = languageRepo.findById(id);
        if (existingLanguage.isPresent()) {
            LanguageModel language = existingLanguage.get();
            language.setJava(updatedLanguage.getJava());
            language.setC(updatedLanguage.getC());
            language.setPython(updatedLanguage.getPython());
            return languageRepo.save(language);
        }
        return null;
    }

    @Override
    public String deleteLanguage(Integer id) {
        languageRepo.deleteById(id);
        return "delete";
    }
}
