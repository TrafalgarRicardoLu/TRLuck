package dao;

import entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface personDao {

    List<Person> selectAllPersonById(Long id);

    Person selectPersonById(Long id);

    void insertNewPerson(@Param("id")Long id,@Param("name")String name,@Param("sex")String sex,@Param("age")Integer age);

    void updatePersonName(@Param("name") String name,@Param("id") Long id);

    void deletePersonById(Long id);


}
