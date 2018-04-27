package dao;

import entity.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author trafalgar
 */
public interface AuthorityDao {

    List<Authority> listAuthority();

    Authority selectAuthorityById(@Param("arid") Long arid);

    void updateEnableById(@Param("arid")Long arid, @Param("enabled")boolean enabled);

    void updateRoleById(@Param("arid")Long arid,@Param("role")String role);

}
