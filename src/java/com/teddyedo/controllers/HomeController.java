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
public class HomeController {
    
    @RequestMapping(value = "/client.htm", method = RequestMethod.GET, 
            produces = "text/html;charset=UTF-8")
    public String clientMenu(){
    
        return "user/menuUser.html";
    }
    
    @RequestMapping(value = "/technician.htm", method = RequestMethod.GET, 
            produces = "text/html;charset=UTF-8")
    public String techMenu(){
    
        return "technician/menuTech.html";
    }
    
}
