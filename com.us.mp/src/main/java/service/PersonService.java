package service;

import dao.PersonDao;
import entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.enums.MONTH;

import java.util.List;

/**
 * @author trafalgar
 */
@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

    public List<Person> listPerson() {
        return personDao.listPerson();
    }

    public Person selectPersonById(Long id) {
        return personDao.selectPersonById(id);
    }

    public void insertNewPerson(String name, String sex,String year,String month,String day, String depaertment) {
        MONTH[] months = MONTH.values();
        int monthIndex =0;
        for(MONTH currentMonth:months){
            if(currentMonth.toString().equals(month)){
                monthIndex=currentMonth.getMonthIndex();
                break;
            }
        }
        String birth = year + '-' +monthIndex+ '-' + day;
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
