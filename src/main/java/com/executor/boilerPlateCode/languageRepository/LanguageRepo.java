package com.executor.boilerPlateCode.languageRepository;

import com.executor.boilerPlateCode.languageModel.LanguageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepo extends JpaRepository<LanguageModel, Integer> {
    Optional<LanguageModel> findById(int id);
}
