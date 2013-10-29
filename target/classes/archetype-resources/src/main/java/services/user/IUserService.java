package ${package}.services.user;

import java.util.List;

import ${package}.security.User;
import ${package}.services.IService;

public interface IUserService<User> extends IService {

    List<User> findAll() throws Exception;

    User findById(Long id) throws Exception;

    void save(User user) throws Exception;
    
    void update(User user) throws Exception;
    
    void delete(Long id) throws Exception;

}
