package controller;

import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.PersonService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "redirect:index.html";
    }

    @RequestMapping(value = "/showAllPeople",method = RequestMethod.GET)
    public String showAllPeople(Map<String,Object> map){
        List<Person> people = personService.selectAllPerson();
        map.put("People",people);
        return "showAllPeople";
    }

    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
    public String addNewPerson(@RequestParam(value = "pname")String pname,
                               @RequestParam(value = "sex")String sex,
                               @RequestParam(value = "department")String department){
        Integer age = 20;
        personService.insertNewPerson(pname,sex,age,department);
        return "redirect:showAllPeople";
    }

    @RequestMapping(value = "/deletePerson",method = RequestMethod.GET)
    public String deletePerson(@RequestParam(value = "deletedPid")String pid){
        personService.deletePersonById(Long.valueOf(pid));
        return "redirect:showAllPeople";
    }


}
