package controller;

import entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.PersonService;

import java.util.List;
import java.util.Map;

/**
 * @author trafalgar
 */
@Controller
@RequestMapping(value = "/mp")
public class PersonController {

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonService personService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:http://localhost/index.html";
    }

    @RequestMapping(value = "/showPeople", method = RequestMethod.GET)
    public String showAllPeoples() {
        return "showPeople.html";
    }


    @RequestMapping(value = "/addNewPerson", method = RequestMethod.GET)
    public String addNewPerson() {
        return "addNewPerson.html";
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public String insertNewPerson(@RequestParam(value = "pname") String pname,
                                  @RequestParam(value = "sex") String sex,
                                  @RequestParam(value = "year") String year,
                                  @RequestParam(value = "month") String month,
                                  @RequestParam(value = "day") String day,
                                  @RequestParam(value = "department") String department) {
        personService.insertNewPerson(pname, sex, year, month, day, department);
        return "showPeople.html";
    }

    @RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
    public String deletePerson(@RequestParam(value = "deletedPid") String pid) {
        personService.deletePersonById(Long.valueOf(pid));
        return "showPeople.html";
    }


}
