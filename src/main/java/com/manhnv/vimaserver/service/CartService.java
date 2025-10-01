package com.manhnv.vimaserver.service;

import com.manhnv.vimaserver.dto.request.TicketPostRequest;
import com.manhnv.vimaserver.dto.response.CartResponse;
import com.manhnv.vimaserver.dto.response.TicketResponse;
import com.manhnv.vimaserver.exception.ApiException;
import com.manhnv.vimaserver.model.Cart;
import com.manhnv.vimaserver.model.Ticket;
import com.manhnv.vimaserver.model.User;
import com.manhnv.vimaserver.repository.CartRepository;
import com.manhnv.vimaserver.repository.UserRepository;
import com.manhnv.vimaserver.utils.AuthenticationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public Cart createCart() {
        User currentUser = userRepository.findByUsername(AuthenticationUtils.extractUsername()).orElseThrow(() -> new ApiException("User not found"));
        Cart userCart = cartRepository.findCartByUser(currentUser);
        if (userCart != null) {
            return userCart;
        }
        return cartRepository.save(new Cart(currentUser));
    }

    public List<TicketResponse> getAllTicketsInCart() {
        String currentUsername = AuthenticationUtils.extractUsername();
        User user = userRepository.findByUsername(currentUsername).orElseThrow(() -> new ApiException("User not found"));
        return user.getCart().getTickets().stream().map(TicketResponse::toResponse).toList();
    }
}
