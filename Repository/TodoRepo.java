package com.example.TodoApplication.Repository;

import com.example.TodoApplication.Entity.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepo {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void save(Todo todo) {
            entityManager.persist(todo);
    }

    public List<Todo> findAll() {
        TypedQuery<Todo> typedQuery=entityManager.createQuery("from Todo",Todo.class);
        return typedQuery.getResultList();
    }

    public Optional<Todo> findById(long id) {
        Todo todo=entityManager.find(Todo.class,id);
        return Optional.ofNullable(todo);
    }

    @Transactional
    public void update(Todo oldTodo) {
        entityManager.merge(oldTodo);
    }

    @Transactional
    public void delTodo(long id) {
        Todo todo=entityManager.find(Todo.class,id);
        if(todo!=null){
            entityManager.remove(todo);
        }
    }
}
