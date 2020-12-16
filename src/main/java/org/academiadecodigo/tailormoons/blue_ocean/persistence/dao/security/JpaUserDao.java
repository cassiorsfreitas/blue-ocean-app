package org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.security;


import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.jpa.GenericJpaDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 * A JPA {@link UserDao} implementation
 */
@Repository
public class JpaUserDao extends GenericJpaDao<User> implements UserDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaUserDao() {
        super(User.class);
    }

    /**
     * @see UserDao#findByName(String)
     */
    @Override
    public User findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);
        ParameterExpression<String> p = cb.parameter(String.class);

        query.select(user).where(cb.equal(user.get("name"), p));
        TypedQuery<User> q = em.createQuery(query);
        q.setParameter(p, name);

        return q.getResultList().get(0);
    }
}
