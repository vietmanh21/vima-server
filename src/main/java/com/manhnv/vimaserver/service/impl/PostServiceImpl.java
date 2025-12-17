package com.manhnv.vimaserver.service.impl;

import com.manhnv.vimaserver.dto.post.PostDTO;
import com.manhnv.vimaserver.exception.NotFoundException;
import com.manhnv.vimaserver.model.Post;
import com.manhnv.vimaserver.model.User;
import com.manhnv.vimaserver.repository.PostRepository;
import com.manhnv.vimaserver.service.PostService;
import com.manhnv.vimaserver.utils.AuthenticationUtils;
import com.manhnv.vimaserver.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Post createPost(PostDTO dto) {
        User author = AuthenticationUtils.getCurrentUser();
        Post post = Post.builder()
                .title(dto.getTitle())
                .subTitle(dto.getSubTitle())
                .content(dto.getContent())
                .author(author)
                .build();
        return postRepository.save(post);
    }

    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.POST_NOT_FOUND, id));
    }

    @Override
    public Post updatePost(Long id, PostDTO dto) {
        Post post = getPost(id);
        post.setTitle(dto.getTitle());
        post.setSubTitle(dto.getSubTitle());
        post.setContent(dto.getContent());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        Post post = getPost(id);
        postRepository.delete(post);
    }
}
