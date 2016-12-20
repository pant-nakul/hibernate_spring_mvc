package ID1.web.controller;

import ID1.model.student.Student;
import ID1.services.StudentService;
import ID1.services.ViewResolverUtil;
import ID1.services.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private WelcomeService welcomeService;
    @Autowired
    private ViewResolverUtil viewResolverUtil;


    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public ModelAndView create() {
        System.out.println("***************************Create******************************");
        System.out.println("***************************Create******************************");

//        studentService.create();
//        studentService.persist();
//        studentService.saveOrUpdate();
        studentService.merge();
//        studentService.refresh();


        System.out.println("***************************Create******************************");
        System.out.println("***************************Create******************************");

        return viewResolverUtil.renderModelAndView();
    }


}
