package dao;

import entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface adminDao {

    void insertAdmin(@Param("aname")String aname,@Param("password") String password);

    List<Admin> selectAdmins();

    Admin selectAdminById(@Param("aid") Long id);

    void updatePasswordById(@Param("aid") Long id,@Param("password")String password);

    void updateAuthorityById(@Param("aid") Long id,@Param("authority")String  authority);

    void deleteAdminById(@Param("aid")Long id);
}
