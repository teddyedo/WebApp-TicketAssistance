/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teddyedo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author edoal
 */

@Controller
public class TechController {
    
    @RequestMapping(value = "/technician/login.htm", method = RequestMethod.GET, 
            produces = "text/html;charset=UTF-8")
    public String techLogin(){
    
        return "/technician/loginTech.html";
    }
    
    @RequestMapping(value = "/technician/register.htm", method = RequestMethod.GET, 
            produces = "text/html;charset=UTF-8")
    public String techRegister(){
    
        return "/technician/registerTech.html";
    }
    
 
}
