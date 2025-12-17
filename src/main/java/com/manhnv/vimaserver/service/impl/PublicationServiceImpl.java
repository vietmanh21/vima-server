package com.manhnv.vimaserver.service.impl;

import com.manhnv.vimaserver.dto.publication.PublicationPostDTO;
import com.manhnv.vimaserver.exception.NotFoundException;
import com.manhnv.vimaserver.model.Publication;
import com.manhnv.vimaserver.model.User;
import com.manhnv.vimaserver.repository.PublicationRepository;
import com.manhnv.vimaserver.service.PublicationService;
import com.manhnv.vimaserver.utils.AuthenticationUtils;
import com.manhnv.vimaserver.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {
    private final PublicationRepository publicationRepository;

    public Publication createPublication(PublicationPostDTO dto) {
        User owner = AuthenticationUtils.getCurrentUser();
        Publication publication = Publication.builder()
                .title(dto.getName())
                .description(dto.getDescription())
                .url(dto.getUrl())
                .logo(dto.getLogo())
                .owner(owner)
                .build();
        return publicationRepository.save(publication);
    }

    private void validatePublication(PublicationPostDTO dto) {

    }

    public Publication getPublicationById(Long id) {
        return publicationRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.PUBLICATION_NOT_FOUND, id));
    }

    public Publication getPublication(Long id) {
        Publication publication = getPublicationById(id);
        publication.incrementViews();
        return publicationRepository.save(publication);
    }

    public Publication updatePublication(Long id, PublicationPostDTO dto) {
        Publication publication = getPublicationById(id);
        publication.setTitle(dto.getName());
        publication.setDescription(dto.getDescription());
        publication.setUrl(dto.getUrl());
        publication.setLogo(dto.getLogo());
        return publicationRepository.save(publication);
    }

    public void deletePublication(Long id) {
        Publication publication = getPublicationById(id);
        publicationRepository.delete(publication);
    }
}
