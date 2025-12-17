package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.model.Subscription;

public interface SubscriptionService {
    Subscription subscribe(Long publicationId);

    Subscription unsubscribe(Long subscriptionId);
}
