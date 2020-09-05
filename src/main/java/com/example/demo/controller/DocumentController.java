package com.example.demo.controller;


import com.example.demo.auth.ReqUser;
import com.example.demo.entity.Documents;
import com.example.demo.entity.User;
import com.example.demo.service.DocumentService;
import com.example.demo.service.contract.DTOBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/documents")
public class DocumentController {
    @Autowired
    DTOBuilderService dtoBuilderService;

    @Autowired
    DocumentService documentService;

    @PostMapping()
    public ResponseEntity<Documents> create(@RequestBody Documents document, @ReqUser User user) {
        documentService.create(document, user);
        return ResponseEntity.ok(document);
    }


    @GetMapping()
    public ResponseEntity<List<Documents>> getAllDocument(@ReqUser User user) {
        List<Documents> documents = documentService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }



}
