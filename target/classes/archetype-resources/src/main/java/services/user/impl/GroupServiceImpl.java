package ${package}.services.user.impl;

import java.util.List;

import ${package}.security.Group;
import ${package}.services.user.IGroupService;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupServiceImpl implements IGroupService<Group> {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Group> findAll() throws Exception {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Group.class);
        return (List<Group>) criteria.list();        
    }

    @Override
    public Group findById(Long id) throws Exception {
        return (Group) sessionFactory.getCurrentSession().get(Group.class, id);
    }

    public void save(Group group) throws Exception {
        sessionFactory.getCurrentSession().saveOrUpdate(group);
    }
    
    public void update(Group group) throws Exception {
        sessionFactory.getCurrentSession().update(group);
    }
    
    public void delete(Long id) throws Exception {
        Group group = (Group) sessionFactory.getCurrentSession().load(Group.class, id);
        if (null != group) {
            sessionFactory.getCurrentSession().delete(group);
        }
    }

}
