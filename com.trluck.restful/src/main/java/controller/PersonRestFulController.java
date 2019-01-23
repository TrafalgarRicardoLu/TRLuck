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


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable(value = "id") Integer id) {
        return personService.selectPersonById(id.longValue());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePersonById(@PathVariable(value = "id") Integer id) {
        personService.deletePersonById(id.longValue());
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void createNewPerson(@RequestBody Person person) {
        personService.insertNewPerson(person);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public @ResponseBody Person updatePersonById(@RequestBody Person person) {
        personService.updatePerson(person);
        return personService.selectPersonById(person.getId());
    }
}
