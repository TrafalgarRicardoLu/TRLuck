package dao;

import entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface adminDao {

    void insertAdmin(@Param("aname")String aname,@Param("password") String password);

    Admin selectAdminByName(@Param("aname") String aname);

    void updatePasswordById(@Param("aid") Long id,@Param("password")String password);

    void updateAuthorityById(@Param("aid") Long id,@Param("authority")Integer authority);

    void deleteAdminById(@Param("aid")Long id);
}
