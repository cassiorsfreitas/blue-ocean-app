package org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.security.jpa;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.jpa.GenericJpaDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.security.RoleDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 * A JPA {@link RoleDao} implementation
 */
@Repository
public class JpaRoleDao extends GenericJpaDao<Role> implements RoleDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaRoleDao() {
        super(Role.class);
    }

    /**
     * @see RoleDao#findByName(String)
     */
    @Override
    public Role findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Role> query = cb.createQuery(Role.class);
        Root<Role> user = query.from(Role.class);
        ParameterExpression<String> p = cb.parameter(String.class);

        query.select(user).where(cb.equal(user.get("name"), p));
        TypedQuery<Role> q = em.createQuery(query);
        q.setParameter(p, name);

        return q.getResultList().get(0);
    }
}
