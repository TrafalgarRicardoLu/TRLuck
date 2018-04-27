package controller;

import entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PersonService;

import java.util.List;

/**
 * @author trafalgar
 */
@RestController
@RequestMapping(value = "/person")
public class PersonRestFulController {

    private static Logger logger = LoggerFactory.getLogger(PersonRestFulController.class);

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Person> getAllPeople() {
        return personService.listPerson();
    }


    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable(value = "pid") Integer pid) {
        return personService.selectPersonById(pid.longValue());
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
    public void deletePersonById(@PathVariable(value = "pid") Integer pid) {
        personService.deletePersonById(pid.longValue());
    }


    @RequestMapping(value = "/{pid}", method = RequestMethod.POST)
    public void createNewPerson(@RequestBody Person person) {
        personService.insertNewPerson(person);
    }

    @RequestMapping(value = "/{pid}",method = RequestMethod.PUT)
    public @ResponseBody Person updatePersonById(@RequestBody Person person) {
        personService.updatePerson(person);
        return personService.selectPersonById(person.getPid());
    }
}
