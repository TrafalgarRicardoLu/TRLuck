package service;

import dao.personDao;
import entity.Person;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    personDao personDao;

    public List<Person> selectAllPerson() {
        return personDao.selectAllPerson();
    }

    public Person selectPersonById(Long id){
        return personDao.selectPersonById(id);
    }

    public void insertNewPerson(String name, String sex, Integer age,String password){
        password = BCrypt.hashpw(password,BCrypt.gensalt());
        personDao.insertNewPerson(name,sex,age,password);
    }

    public void updatePersonAge(Integer age, Long id){
        personDao.updatePersonAge(age,id);
    }

    public void deletePersonById(Long id){
        personDao.deletePersonById(id);
    }
}
