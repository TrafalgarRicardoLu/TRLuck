package dao;

import entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author trafalgar
 */
public interface AdminDao {


    void insertAdmin(@Param("name") String name, @Param("password") String password);

    List<Admin> listAdmin();

    Admin selectAdminById(@Param("id") Long id);

    void updatePasswordById(@Param("id") Long id, @Param("password") String password);

    void updateAnameById(@Param("id") Long id, @Param("name") String name);

    void deleteAdminById(@Param("id") Long id);
}
