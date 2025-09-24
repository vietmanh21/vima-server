package com.manhnv.vimaserver.controller;

import com.manhnv.vimaserver.dto.request.MediaRequest;
import com.manhnv.vimaserver.model.Media;
import com.manhnv.vimaserver.service.MediaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/minio")
@RequiredArgsConstructor
public class MinioController {
    private final MediaService mediaService;

    @PostMapping("/upload")
    public ResponseEntity<Media> upload(@Valid @ModelAttribute MediaRequest request) {
        return ResponseEntity.ok(mediaService.uploadMedia(request));
    }
}
