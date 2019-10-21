package com.myth.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JumpController {
    //页面跳转-----------------------------------------------------------------
//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }
    @RequestMapping("/")
    public String index(){
        return "login";
    }
    @RequestMapping("/a")
    public String a(){
        return "aaa";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "index";
    }
    //
    @RequestMapping("/toStudentList")
    public String toStudentList(){
        return "student/student-list";
    }
    @RequestMapping("/toStudentAdd")
    public String toStudentAdd(){
        return "student/student-add";
    }

    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    //
    @RequestMapping("/toTeacherList")
    public String toTeacherList(){
        return "teacher/teacher-list";
    }
    @RequestMapping("/toTeacherAdd")
    public String toTeacherAdd(){
        return "teacher/teacher-add";
    }
    @RequestMapping("/toWelcome")
    public String toWelcome(){
        return "welcome";
    }


    //
    @RequestMapping("/toClassList")
    public String toClassList(){
        return "class/class-list";
    }

    @RequestMapping("/toClassAdd")
    public String toClassAdd(){
        return "class/class-add";
    }




    //
    @RequestMapping("/tcCourseList")
    public String tcCourseList(){
        return "course/course-list";
    }
    @RequestMapping("/tcCourseAdd")
    public String tcCourseAdd(){
        return "course/course-add";
    }


    //
    @RequestMapping("/toDeptList")
    public String toDeptList(){
        return "dept/dept-list";
    }
    @RequestMapping("toDeptAdd")
    public String toDeptAdd(){
        return "dept/dept-add";
    }


    //

    @RequestMapping("/toUserList")
    public String toUserList(){
        return "user/user-list";
    }
    @RequestMapping("/toUserAdd")
    public String toUserAdd(){
        return "user/user-add";
    }


    //
    @RequestMapping("/toTypeList")
    public String toTypeList(){
        return "type/type-list";
    }
    @RequestMapping("/toTypeAdd")
    public String toTypeAdd(){
        return "type/type-add";
    }

    //
    @RequestMapping("/toTeachingList")
    public String toTeachingList(){
        return "teaching/teaching-list";
    }
    @RequestMapping("/toTeachingAdd")
    public String toTeachingAdd(){
        return "teaching/teaching-add";
    }

    //

    @RequestMapping("/toBatchList")
    public String toBatchList(){
        return "batch/batch-list";
    }
    @RequestMapping("/toBatchAdd")
    public String toBatchAdd(){
        return "batch/batch-add";
    }


    //
    @RequestMapping("/toResultList")
    public String toResultList(){
        return "result/result-list";
    }

    //
    @RequestMapping("toList")
    public String toList(){
        return "s/list";
    }
    @RequestMapping("toS")
    public String toS(){
        return "s/s-list";
    }
    @RequestMapping("toS1")
    public String toS1(){
        return "s/s-list1";
    }

    @RequestMapping("toT")
    public String toT(){
        return "t/t-list";
    }
    @RequestMapping("toT1")
    public String toT1(){
        return "t/list";
    }



    //跳转到学生试题添加页面
    @RequestMapping("/toQuestionAdd")
    public String toQuestionAdd(){
        return "question/question-add";
    }
    //跳转到学生试题查看页面
    @RequestMapping("/toQuestionList")
    public String toQuestionList(){
        return "question/question-list";
    }
    //跳转到学生试题修改页面
    @RequestMapping("/toQuestionUpdate")
    public String toQuestionUpdate(){
        return "question/question-update";
    }

    //跳转到教师试题添加页面
    @RequestMapping("/toQuestionsAdd")
    public String toQuestionsAdd(){
        return "questions/questions-add";
    }
    //跳转到教师试题查看页面
    @RequestMapping("/toQuestionsList")
    public String toQuestionsList(){
        return "questions/questions-list";
    }
    //跳转到教师试题修改页面
    @RequestMapping("/toQuestionsUpdate")
    public String toQuestionsUpdate(){
        return "questions/questions-update";
    }

    ////得到数据表
    @RequestMapping("/show")
    public String toShow(){
        return "t/show";
    }
    @RequestMapping("/toUpdatePass")
    public String toUpdatePass(){
        return "/updatePassword";
    }
}
