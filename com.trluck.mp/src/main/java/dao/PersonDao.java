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

    void insertNewPerson(@Param("name") String name, @Param("sex") String sex, @Param("birth")String bitrh, @Param("department") String department);


    void deletePersonById(@Param("id") Long id);

    void updateBirthById(@Param("birth")String birth, @Param("id") Long id);

    void updateDepartmentById(@Param("department")String department,@Param("id")Long id);

    void updatePnameById(@Param("name")String name,@Param("id")Long id);
}
