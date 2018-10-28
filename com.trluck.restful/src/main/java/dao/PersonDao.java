package dao;

import entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author trafalgar
 */
public interface PersonDao {

    List<Person> listPerson();

    Person selectPersonById(Long id);

    void insertNewPerson(@Param("pname") String name, @Param("sex") String sex, @Param("birth") String bitrh, @Param("department") String department);


    void deletePersonById(@Param("pid") Long id);

    void updateBirthById(@Param("birth") String birth, @Param("pid") Long id);

    void updateDepartmentById(@Param("department") String department, @Param("pid") Long id);

    void updatePnameById(@Param("pname") String pname, @Param("pid") Long id);
}
