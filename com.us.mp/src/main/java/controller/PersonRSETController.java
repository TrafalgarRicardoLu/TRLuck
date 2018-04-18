package controller;

import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PersonService;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonRSETController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Person> getAllPeople(){
        return personService.selectAllPerson();
    }


    @RequestMapping(value = "/{pid}",method = RequestMethod.GET)
    public Person getPersonById(@PathVariable(value = "pid")Integer pid){
        return personService.selectPersonById(pid.longValue());
    }

    @RequestMapping(value = "/{pid}",method = RequestMethod.DELETE)
    public void deletePersonById(@PathVariable(value = "pid")Integer pid){
        personService.deletePersonById(pid.longValue());
    }


    @RequestMapping(value = "/{pid}",method = RequestMethod.PUT)
    public void createNewPerson(@RequestBody Person person){
        personService.insertNewPerson(person.getPname(),person.getSex(),person.getBirth(),person.getDepartment());
    }

    @RequestMapping(value = "/{pid}",method = RequestMethod.POST)
    public void updatePersonById(@RequestBody Person person){
        personService.updatePerson(person);
    }
}
