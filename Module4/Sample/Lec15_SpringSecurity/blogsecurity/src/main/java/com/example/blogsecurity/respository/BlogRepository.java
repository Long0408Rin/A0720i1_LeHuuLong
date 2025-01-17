package com.example.blogsecurity.respository;

import com.example.blogsecurity.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Override
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByCategory_Id(int category_id, Pageable pageable);

    Page<Blog> findBlogByTitleContains(String title, Pageable pageable);

    Page<Blog> findBlogsByTitleContainsAndCategory_Id(String title, int category, Pageable pageable);



}
