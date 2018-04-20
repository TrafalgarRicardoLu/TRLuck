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

@Controller
public class PersonController {

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

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
                               @RequestParam(value = "department")String department,
                               @RequestParam(value = "year")String year,
                               @RequestParam(value = "month")String month,
                               @RequestParam(value = "day")String day){
        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        Integer month_int;
        for(month_int=0;month_int<months.length;month_int++){
            if (month.equals(months[month_int])){
                break;
            }
        }
        month_int++;
        String birth = year+'-'+month_int.toString()+'-'+day;
        personService.insertNewPerson(pname,sex,birth,department);
        return "redirect:showAllPeople";
    }

    @RequestMapping(value = "/deletePerson",method = RequestMethod.GET)
    public String deletePerson(@RequestParam(value = "deletedPid")String pid){
        personService.deletePersonById(Long.valueOf(pid));
        return "redirect:showAllPeople";
    }


}
