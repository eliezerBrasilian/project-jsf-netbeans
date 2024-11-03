package _jpa;

import static _jpa.JpaUtil.getSession;
import _jpa.exceptions.PerformEntityOperationException;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Session;

/**
 * A GenericDao is an abstract class that provides basic CRUD operations for a
 * specified entity type. This class uses JPA (Java Persistence API) to interact
 * with the database.
 *
 * @version 1.0
 * @param <T> the type of the entity to be managed by this DAO.
 * @author Eliezer Brasilian
 *
 * Visit repository link on GitHub:
 * <a href="https://github.com/eliezerBrasilian/jsf-template">GitHub</a>
 */
public abstract class GenericDao<T> {

    protected Class<T> entityClass;

    /**
     * Constructs a GenericDao for the specified entity class.
     *
     * @param entityClass the class of the entity to be managed.
     */
    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Saves a new entity to the database.
     *
     * @param entity the entity to be saved.
     */
    public void save(T entity) throws PerformEntityOperationException {
        Session session = getSession();
        session.beginTransaction();

        try {
            session.save(entity);
            session.getTransaction().commit();
        } catch (JDBCException e) {
            e.printStackTrace();
            throw new PerformEntityOperationException();

        } finally {
            try {
                if (session.isOpen()) {
                    session.close();
                }
            } catch (HibernateException e) {
                throw new PerformEntityOperationException("Erro ao fechar operação de salvar. \n" + e.getMessage());
            }
        }
    }

    /**
     * Updates an existing entity in the database.
     *
     * @param entity the entity to be updated.
     * @return the updated entity.
     * @throws EntityNotFoundException if the entity is null.
     */
    public void update(T entity) throws PerformEntityOperationException, IllegalArgumentException {
        Session session = getSession();
        session.beginTransaction();

        try {
            if (entity != null) {
                session.update(entity);
            } else {
                throw new IllegalArgumentException("O objeto a ser atualizado não pode ser nulo.");
            }

            session.getTransaction().commit();

        } catch (JDBCException e) {
            e.printStackTrace();
            throw new PerformEntityOperationException();
        } finally {
            try {
                if (session.isOpen()) {
                    session.close();
                }
            } catch (HibernateException e) {
                throw new PerformEntityOperationException("Erro ao fechar operação de atualizar. \n" + e.getMessage());
            }
        }
        
        
    }
    
     public T findById(Serializable id) throws PerformEntityOperationException {
        Session session = getSession();

        try {
            session.beginTransaction();
            T entity = (T) session.get(entityClass, id);
            session.getTransaction().commit();
            return entity;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new PerformEntityOperationException("Erro ao buscar entidade por ID. \n" + e.getMessage());
        } finally {
            try {
                if (session.isOpen()) {
                    session.close();
                }
            } catch (HibernateException e) {
                throw new PerformEntityOperationException("Erro ao fechar operação de busca por ID. \n" + e.getMessage());
            }
    }
  }
}
