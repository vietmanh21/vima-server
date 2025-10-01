package com.manhnv.vimaserver.repository;

import com.manhnv.vimaserver.model.Cart;
import com.manhnv.vimaserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findCartByUser(User user);
}
