package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.dto.publication.PublicationPostDTO;
import com.manhnv.vimaserver.model.Publication;
import com.manhnv.vimaserver.model.User;
import com.manhnv.vimaserver.repository.PublicationRepository;
import com.manhnv.vimaserver.utils.AuthenticationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicationService {
    private final PublicationRepository publicationRepository;

    public Publication createPublication(PublicationPostDTO dto) {
        User owner = AuthenticationUtils.extractUser();
        Publication publication = Publication.builder()
                .title(dto.getName())
                .description(dto.getDescription())
                .url(dto.getUrl())
                .logo(dto.getLogo())
                .owner(owner)
                .build();
        return publicationRepository.save(publication);
    }
}
