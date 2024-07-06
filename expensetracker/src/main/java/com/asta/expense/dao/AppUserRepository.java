package com.asta.expense.dao;

import com.asta.expense.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findAllByDeleted(String deleted);

}
