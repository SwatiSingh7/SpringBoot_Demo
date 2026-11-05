package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

//after (fixed lines)
//java


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SpringBootApplication
@RestController
public class DemoApplication {

 public static void main(String[] args) {
     SpringApplication.run(DemoApplication.class, args);
 }

 
 @PostMapping("/PostParameterSpringBoot")
 public void process(HttpServletRequest request,
                     HttpServletResponse response)
         throws IOException {

     PrintWriter pw = response.getWriter();

     // Get enumeration of parameter names
     Enumeration<String> e = request.getParameterNames();

     // Display parameter names and values
     while (e.hasMoreElements()) {

         String paramName = e.nextElement();

         String paramValue =
                 request.getParameter(paramName);

         pw.println(paramName + " = " + paramValue);
     }
 }
 
 @PostMapping("/ColorGetSpringBoot")
 public void ColorGet(HttpServletRequest request,
                     HttpServletResponse response)
         throws IOException {
	 String color = request.getParameter("color");
	 PrintWriter pw = response.getWriter();
	 pw.println("Your favorite color is: " + color);
	 
 }
	
 @GetMapping("/")
 public String home(Model model) {

     model.addAttribute("color", "white");

     return "color";
 }

 @PostMapping("/showColor")
 public String showColor(
         @RequestParam String selectedColor,
         Model model) {

     model.addAttribute("color", selectedColor);
     String color = selectedColor;

     return color;
 } 
	 //=====================================
 
}
