package com.manhnv.vimaserver.controller;

import com.manhnv.vimaserver.dto.post.PostDTO;
import com.manhnv.vimaserver.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostDTO dto) {
        return ResponseEntity.ok(postService.createPost(dto));
    }
}
