package com.manhnv.vimaserver.service.impl;

import com.manhnv.vimaserver.exception.NotFoundException;
import com.manhnv.vimaserver.model.Publication;
import com.manhnv.vimaserver.model.Subscription;
import com.manhnv.vimaserver.model.User;
import com.manhnv.vimaserver.repository.PublicationRepository;
import com.manhnv.vimaserver.repository.SubscriptionRepository;
import com.manhnv.vimaserver.service.PublicationService;
import com.manhnv.vimaserver.service.SubscriptionService;
import com.manhnv.vimaserver.utils.AuthenticationUtils;
import com.manhnv.vimaserver.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final PublicationService publicationService;

    @Override
    public Subscription subscribe(Long publicationId) {
        User user = AuthenticationUtils.getCurrentUser();
        Publication publication = publicationService.getPublicationById(publicationId);

        Subscription subscription = Subscription.builder()
                .user(user)
                .publication(publication)
                .build();

        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription unsubscribe(Long subscriptionId) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.SUBSCRIPTION_NOT_FOUND, subscriptionId));

        subscriptionRepository.delete(subscription);
        return subscription;
    }
}
