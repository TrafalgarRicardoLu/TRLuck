package dao;

import entity.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface personDao {

    List<Person> selectAllPerson();

    Person selectPersonById(Long id);

    void insertNewPerson(@Param("pname") String name, @Param("sex") String sex, @Param("age") Integer age, @Param("password") String password);


    void deletePersonById(@Param("pid") Long id);

    void updatePersonAge(@Param("age") Integer age, @Param("pid") Long id);

    void updatePersonPasswordById(@Param("password")String password,@Param("pid")Long id);


}
