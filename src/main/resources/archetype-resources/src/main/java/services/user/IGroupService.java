package ${package}.services.user;

import java.util.List;

import ${package}.security.Group;
import ${package}.services.IService;

public interface IGroupService<Group> extends IService {

    List<Group> findAll() throws Exception;

    Group findById(Long id) throws Exception;
    
    void save(Group group) throws Exception;
    
    void update(Group group) throws Exception;
    
    void delete(Long id) throws Exception;

}
