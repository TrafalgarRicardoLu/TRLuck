package dao;

import entity.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author trafalgar
 */
public interface AuthorityDao {

    List<Authority> listAuthority();

    Authority selectAuthorityById(@Param("id") Long id);

    void updateEnableById(@Param("id") Long id, @Param("enabled") boolean enabled);

    void updateRoleById(@Param("id") Long arid, @Param("role") String role);

    void updateRoleByAname(@Param("name") String name, @Param("role") String role);
}
