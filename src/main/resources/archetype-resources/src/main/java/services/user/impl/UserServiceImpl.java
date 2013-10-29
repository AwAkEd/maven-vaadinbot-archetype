package ${package}.services.user.impl;

import java.util.List;

import ${package}.security.User;
import ${package}.services.user.IUserService;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService<User> {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<User> findAll() throws Exception {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return (List<User>) criteria.list();        
    }

    @Override
    public User findById(Long id) throws Exception {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    public void save(User user) throws Exception {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
    
    public void update(User user) throws Exception {
        sessionFactory.getCurrentSession().update(user);
    }
    
    public void delete(Long id) throws Exception {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

}
