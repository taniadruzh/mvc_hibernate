package com.mvcTest.controller;

import com.mvcTest.dao.MenuDao;
import com.mvcTest.dto.Employee;
import com.mvcTest.entity.MenuObject;
import com.mvcTest.entity.Student;
import com.mvcTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class StartController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private MenuDao menuDao;


    List<Student> studentListModify = null;

    @RequestMapping(method = RequestMethod.GET)
    public String getStudentList(Model model, @ModelAttribute("employee") Employee employee) {
        model.addAttribute("userList", studentService.userList());
        // model.addAttribute("userListModify", userListModify);
        model.addAttribute("menuList", menuDao.menuList());

        System.out.println("show redirect attribute in base controller /");

        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getContactNumber());

        return "start";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String getModifyStudentList(Model model) {
        studentListModify = studentService.userListWithModific();
        return "redirect:/";
    }

    @RequestMapping(value = "/salary", method = RequestMethod.GET)
    public String getStudentSalary(Model model) {
        System.out.println(" in salary contr");
        studentService.userListWithCel().forEach((k, v) -> System.out.println(k.getName() + " -- " + v));
        return "redirect:/";
    }


    // show update form
    @RequestMapping(value = "/menu/{id}/update", method = RequestMethod.GET)
    public String updateMenu(@PathVariable("id") int id) {
        System.out.println("in update menu by id->"+ id);

        return "redirect:/";

    }

    // delete user
    @RequestMapping(value = "/menu/{id}/delete", method = RequestMethod.GET)
    public String deleteMenu(@PathVariable("id") int id) {
        System.out.println("in delete mune id ->" +id);

        return "redirect:/";

    }

    // show user
    @RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
    public String showMenu(@PathVariable("id") int id) {
        System.out.println("in show menu, menu id is -> " + id);

        return "redirect:/";

    }


    @RequestMapping(value = "add_employee", method = RequestMethod.POST)
    public String addEmployer(@ModelAttribute("employee") Employee employee) {
        System.out.println("in add method");
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getContactNumber());

        return "redirect:/";
    }


    @RequestMapping(value = "redirect_employee", method = RequestMethod.POST)
    public String redirectEmployer(@ModelAttribute("employee") Employee employee, RedirectAttributes ra) {
        System.out.println("in redirect method");
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getContactNumber());


        ra.addFlashAttribute("employee", employee);

        return "redirect:/";
    }

    @RequestMapping(value = "test/{id}", method = RequestMethod.GET)
    public String testPatch(@PathVariable("id") String id) {
        System.out.println("in test patch method");
        System.out.println(id);
        return "redirect:/";
    }

    @RequestMapping(value = "{id}/{name}", method = RequestMethod.GET)
    public String testPatch2(@PathVariable("id") int id, @PathVariable("name") String name) {
        System.out.println("in test patch method 2");

        System.out.println(id);
        System.out.println(name);
        return "redirect:/";
    }


}
