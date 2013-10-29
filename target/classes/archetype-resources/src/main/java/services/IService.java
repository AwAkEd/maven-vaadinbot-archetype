package ${package}.services;

import java.util.List;

public interface IService<T> {

    List<T> findAll() throws Exception;

    T findById(Long id) throws Exception;

}
