package com.quiz.service;
import com.quiz.model.PreguntasDAO;
import com.quiz.repository.PreguntasDAORepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories("com.quiz.repository")
@Service
public class PreguntasService implements IPreguntasService {

    @Autowired
    private PreguntasDAORepository preguntasDAORepository;

    @Override
    public PreguntasDAO create(PreguntasDAO preguntasDAO) {
        return preguntasDAORepository.save(preguntasDAO);
    }

    @Override
    public PreguntasDAO update(PreguntasDAO preguntasDAO) {
        return preguntasDAORepository.save(preguntasDAO);
    }


    @Override
    public List<PreguntasDAO> findAll() {
        return preguntasDAORepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        preguntasDAORepository.deleteById(id);
        
    }

    
    
}
