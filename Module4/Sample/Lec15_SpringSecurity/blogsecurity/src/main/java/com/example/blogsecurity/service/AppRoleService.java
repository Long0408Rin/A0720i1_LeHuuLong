package com.example.blogsecurity.service;

import com.example.blogsecurity.entity.AppRole;
import org.springframework.stereotype.Service;

@Service
public interface AppRoleService  {
    AppRole findById(int id);
}
