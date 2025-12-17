package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.dto.post.PostDTO;
import com.manhnv.vimaserver.model.Post;

public interface PostService {
    Post createPost(PostDTO dto);

    Post getPost(Long id);

    Post updatePost(Long id, PostDTO dto);

    void deletePost(Long id);
}
