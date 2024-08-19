package com.example.app_blog.repository.blog;

import com.example.app_blog.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Blog> findAll() {
        String findAllQuery = "SELECT b FROM Blog b";
        TypedQuery<Blog> query = em.createQuery(findAllQuery, Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        String findByIdQuery = "SELECT b FROM Blog b WHERE b.id = :id";
        TypedQuery<Blog> query = em.createQuery(findByIdQuery, Blog.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null) {
            em.merge(blog);
        } else {
            em.persist(blog);
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if (blog != null) {
            em.remove(blog);
        }

    }
}
