package com.maituananh.Controller;

import com.maituananh.Beans.Shoe;
import com.maituananh.Database.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ShoeController {
    @Autowired
    SessionFactory sessionFactory;

    @GetMapping(path = "/data")
    @Transactional
    public String data(ModelMap modelMap) {
        Session session = sessionFactory.getCurrentSession();
        session.load(Student.class, 2);
        String sql = "from student";
        List<Student> listStudent = session.createQuery(sql).getResultList();
        modelMap.addAttribute("listStudent", listStudent);
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println(listStudent.get(i).getNameStudent());
        }
        return "page/listStudent";
    }

    @GetMapping(path = "/list/{name}")
    public String home(ModelMap modelMap, @PathVariable(value = "name") String name) {
        modelMap.addAttribute("name", name);
        return "page/list";
    }

    @GetMapping(path = "/form")
    public String form(ModelMap modelMap) {
        return "page/form";
    }

    @PostMapping(path = "/list")
    public String post(ModelMap modelMap, @RequestParam(value = "name") String name) {
        modelMap.addAttribute("name", name);
        System.out.println(name );
        return "page/list";
    }

    @PostMapping(path = "/modelAtri") // khi sử dụng ModelAttribute cần constructor mặc định
    public String model(ModelMap modelMap, @ModelAttribute Shoe shoe) {
        modelMap.addAttribute("shoe", shoe);
        return "page/listShoe";
    }
}
