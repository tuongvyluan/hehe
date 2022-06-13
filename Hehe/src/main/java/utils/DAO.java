package utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    
    public List<T> get(int pageNumber, int rowsOfPage) throws SQLException;
    
    public Optional<T> get(int id);

    public void add(T t);
    
    public boolean update(T t);
    
    public T delete(T t);
    
    public T delete(int id);
}
