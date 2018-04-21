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


    @RequestMapping(value = "/{pid}", method = RequestMethod.PUT)
    public void createNewPerson(@RequestParam(value = "pname") String pname,
                                @RequestParam(value = "sex") String sex,
                                @RequestParam(value = "year") String year,
                                @RequestParam(value = "month") String month,
                                @RequestParam(value = "day") String day,
                                @RequestParam(value = "department") String department) {
        personService.insertNewPerson(pname,sex,year,month,day,department);
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.POST)
    public void updatePersonById(@RequestBody Person person) {
        personService.updatePerson(person);
    }
}
