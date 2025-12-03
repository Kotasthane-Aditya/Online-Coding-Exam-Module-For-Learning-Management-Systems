package com.executor.boilerPlateCode.languageService;

import com.executor.boilerPlateCode.languageModel.LanguageModel;

import java.util.List;

public interface LanguageService {
    String saveLanguage(LanguageModel language);
    List<LanguageModel> getAllLanguages();
    LanguageModel getLanguageById(Integer id);
    LanguageModel updateLanguage(Integer id, LanguageModel updatedLanguage);
    String deleteLanguage(Integer id);
}
