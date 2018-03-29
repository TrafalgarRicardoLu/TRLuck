package controller;

import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.PersonService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/showAllPeople",method = RequestMethod.GET)
    public String showAllPeople(HttpServletRequest request){
        List<Person> people = personService.selectAllPerson();
        for(Person person:people)
            System.out.println(person.getPid());
        request.setAttribute("People",people);
        return "showAllPeople";
    }

}
