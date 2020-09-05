package com.example.demo.service;

import com.example.demo.entity.Documents;
import com.example.demo.entity.User;
import com.example.demo.entity.WorkTimes;
import com.example.demo.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService implements IDocumentService {
    @Autowired
    DocumentRepository documentRepository;

    public Documents create(Documents document, User user) {
        document.setUser(user);
        return documentRepository.save(document);
    }

    public List<Documents> getAllDocuments() {
        List<Documents> documents =documentRepository.findAll();
        return documents;
    }
}
