package com.example.blogsecurity.respository;

import com.example.blogsecurity.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
}
