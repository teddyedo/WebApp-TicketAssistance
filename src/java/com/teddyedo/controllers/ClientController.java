/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teddyedo.controllers;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.teddyedo.DAO.ClienteDao;
import com.teddyedo.entities.Cliente;
import com.teddyedo.entities.Utente;

/**
 *
 * @author edoal
 */

@Controller
public class ClientController {
    
    @RequestMapping(value = "/client/login.htm", method = RequestMethod.GET, 
            produces = "text/html;charset=UTF-8")
    public String clientLoginPage(){
    
        return "/user/loginUser.html";
    }
    
    @RequestMapping(value = "/client/register.htm", method = RequestMethod.GET, 
            produces = "text/html;charset=UTF-8")
    public String clientRegisterPage(){
    
        return "/user/registerUser.html";
    }
    
    @RequestMapping(value = "client/signin.htm", method = RequestMethod.POST,
            produces = "text/html;charset=UTF-8")
    public String registration(HttpServletRequest request) throws ParseException {
        
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String cap = request.getParameter("cap");
        String username = request.getParameter("username");
        String telephone = request.getParameter("telephone");
        Date birthday = new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("birthday"));
        String password = request.getParameter("pass");
        String address = request.getParameter("address");
        
        Random random = new SecureRandom();
                
        byte[] SaltGeneration = new byte[16];
        random.nextBytes(SaltGeneration);
        
        String salt = DatatypeConverter.printBase64Binary(SaltGeneration);
                
        String passwordEncrypted = password + salt;
        
        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putString(passwordEncrypted, Charsets.UTF_8);
        String sha256 = hasher.hash().toString();
        
        Cliente c = new Cliente();
        
        c.setCAP(cap);
        c.setCognome(surname);
        c.setDataNascita(birthday);
        c.setEmail(email);
        c.setIndirizzo(address);
        c.setNome(name);
        c.setTelefono(telephone);
        c.setUsername(username);
        c.setPassword(sha256);
        
        ClienteDao.insert(c);
        
        return "redirect:/login.htm";
        
    }
    
}
