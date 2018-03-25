package dao;

import entity.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface personDao {

    List<Person> selectAllPerson();

    Person selectPersonById(Long id);

    void insertNewPerson(@Param("id")Long id,@Param("name")String name,@Param("sex")String sex,@Param("age")Integer age);

    void updatePersonAge(@Param("age")Integer age,@Param("id") Long id);

    void deletePersonById(Long id);


}
