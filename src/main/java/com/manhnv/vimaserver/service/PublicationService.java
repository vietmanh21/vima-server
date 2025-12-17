package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.dto.publication.PublicationPostDTO;
import com.manhnv.vimaserver.model.Publication;

public interface PublicationService {
    Publication createPublication(PublicationPostDTO dto);

    Publication getPublication(Long id);

    Publication getPublicationById(Long id);

    Publication updatePublication(Long id, PublicationPostDTO dto);

    void deletePublication(Long id);
}
