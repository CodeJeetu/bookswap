package com.book.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.OrderDetails;

public interface OrderReposatory  extends JpaRepository<OrderDetails, Integer>{

}
