package com.saqib.user_management_system.repository;

import com.saqib.user_management_system.dto.RegisterDto;
import com.saqib.user_management_system.entity.RegisterEntity;
import com.saqib.user_management_system.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private EntityManagerFactory emf;

    @Override
    public void save(RegisterEntity regEntity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(regEntity);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public RegisterEntity getEntityByEmail(String email) {
        RegisterEntity entity = null;
        EntityManager em = null;
        try {

            em = emf.createEntityManager();
            Query query = em.createNamedQuery("findEntityByEmail");
            query.setParameter("setEmail", email);
            entity = (RegisterEntity) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public List<UserEntity> getAllUsers() {

        List<UserEntity> list = null;
        EntityManager em = null;
        try {

            em = emf.createEntityManager();
            Query query = em.createNamedQuery("findAll");
            list = (List<UserEntity>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public boolean saveUser(UserEntity user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        boolean check = false;
        try {
            et.begin();
            em.persist(user);
            check = true;
            et.commit();
        } catch (Exception e) {
            et.rollback();
            System.err.println("Exception occurred while saving user: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
        return check;
    }

}
