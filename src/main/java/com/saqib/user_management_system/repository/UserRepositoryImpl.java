package com.saqib.user_management_system.repository;

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

//    Override
//    public List getAllUsers() {
//
//        EntityManager em = emf.createEntityManager();
//        Query query = em.createNamedQuery("findAll");
//        return  query.getResultList();
//        @
//    }


    @Override
    public List<UserEntity> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("getAllUsers");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            em.close();
        }
    }

    public void saveUser(UserEntity user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            if (user.getId() == null) {
                em.persist(user);
            } else {
                em.merge(user);
            }
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        }
    }

    public UserEntity findById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(UserEntity.class, id);
    }

    public boolean updateUserProfile(UserEntity entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            Query query = em.createNamedQuery("updateUserProfileById");
            query.setParameter("id", entity.getId());
            query.setParameter("name", entity.getName());
            query.setParameter("email", entity.getEmail());
            query.setParameter("country", entity.getCountry());
            query.setParameter("phNo", entity.getPhNo());
            int updatedRows = query.executeUpdate();
            et.commit();
            System.out.println("Rows affected: " + updatedRows);
            return updatedRows > 0;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }



    @Override
    public boolean deleteUserById(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean isDeleted = false;

        try {
            transaction.begin(); // Start transaction

            Query query = entityManager.createNamedQuery("deleteUserById");
            query.setParameter("id", id);

            int rowsAffected = query.executeUpdate();
            isDeleted = rowsAffected > 0;
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return isDeleted;
    }
}
