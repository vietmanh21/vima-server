package com.manhnv.vimaserver.controller;

import com.manhnv.vimaserver.dto.publication.PublicationPostDTO;
import com.manhnv.vimaserver.model.Publication;
import com.manhnv.vimaserver.service.impl.PublicationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publications")
@RequiredArgsConstructor
public class PublicationController {
    private final PublicationServiceImpl publicationService;
    @PostMapping
    public ResponseEntity<Publication> createPublication(@RequestBody PublicationPostDTO dto) {
        return ResponseEntity.ok(publicationService.createPublication(dto));
    }

}
