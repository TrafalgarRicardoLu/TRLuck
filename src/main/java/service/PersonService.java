package service;

import dao.personDao;
import entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    personDao personDao;

    public List<Person> selectAllPerson() {
        return personDao.selectAllPerson();
    }

    public Person selectPersonById(Long id) {
        return personDao.selectPersonById(id);
    }

    public void insertNewPerson(String name, String sex,String birth, String depaertment) {

        personDao.insertNewPerson(name, sex, birth, depaertment);
    }
    public void updatePerson(Person person){
        Person origin = selectPersonById(person.getPid());
        if(!origin.getBirth().equals(person.getBirth())){
            personDao.updateBirthById(person.getBirth(),person.getPid());
        }
        if(!origin.getDepartment().equals(person.getDepartment())){
            personDao.updateDepartmentById(person.getDepartment(),person.getPid());
        }
    }

    public void deletePersonById(Long id) {
        personDao.deletePersonById(id);
    }

}
