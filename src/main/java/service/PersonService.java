package service;

import dao.personDao;
import entity.Person;

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

    public Person selectPersonById(Long id) {
        return personDao.selectPersonById(id);
    }

    public void insertNewPerson(String name, String sex, Integer age, String depaertment) {

        personDao.insertNewPerson(name, sex, age, depaertment);
    }
    public void updatePerson(Person person){
        Person origin = selectPersonById(person.getPid());
        if(!origin.getAge().equals(person.getAge())){
            personDao.updateAgeById(person.getAge(),person.getPid());
        }
        if(!origin.getDepartment().equals(person.getDepartment())){
            personDao.updateDepartmentById(person.getDepartment(),person.getPid());
        }
    }

    public void deletePersonById(Long id) {
        personDao.deletePersonById(id);
    }

}
