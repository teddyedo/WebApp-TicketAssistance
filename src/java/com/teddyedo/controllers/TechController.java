/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teddyedo.controllers;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.teddyedo.DAO.ApparecchioDao;
import com.teddyedo.DAO.ClienteDao;
import com.teddyedo.DAO.PDADao;
import com.teddyedo.DAO.TicketDao;
import com.teddyedo.DAO.UtenteDao;
import com.teddyedo.entities.Cliente;
import com.teddyedo.entities.PDA;
import com.teddyedo.entities.TV;
import com.teddyedo.entities.Telefono;
import com.teddyedo.entities.Ticket;
import com.teddyedo.entities.Utente;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
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
    
    @RequestMapping(value = "/technician/newclient.htm", method = RequestMethod.GET, 
            produces = "text/html;charset=UTF-8")
    public String techNewUser(){
    
        return "/technician/registerUser.html";
    }
    
    @RequestMapping(value = "/technician/newticket.htm", method = RequestMethod.GET, 
            produces = "text/html;charset=UTF-8")
    public String newTicketPage(){
    
        return "/technician/addTicket.html";
    }
    
    
    @RequestMapping(value = "/technician/createclient.htm", method = RequestMethod.POST,
            produces = "text/html;charset=UTF-8")
    public String registerClient(HttpServletRequest request) throws ParseException {
        
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
        c.setSALT(salt);
        
        ClienteDao.insert(c);
        
        return "redirect:/technician.htm";
        
    }
    
    @RequestMapping(value = "/technician/newtechnician.htm", method = RequestMethod.POST,
            produces = "text/html;charset=UTF-8")
    public String registerTech(HttpServletRequest request) throws ParseException {
        
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        
        Random random = new SecureRandom();
                
        byte[] SaltGeneration = new byte[16];
        random.nextBytes(SaltGeneration);
        
        String salt = DatatypeConverter.printBase64Binary(SaltGeneration);
                
        String passwordEncrypted = password + salt;
        
        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putString(passwordEncrypted, Charsets.UTF_8);
        String sha256 = hasher.hash().toString();
        
        
        PDA pda = new PDA();
        pda.setLuogo("Verona");
        pda.setNomeNegozio("Euronics");
        
        PDADao.insert(pda);
        
        Utente u = new Utente();
        u.setCognome(surname);
        u.setNome(name);
        u.setPassword(sha256);
        u.setPda(pda);
        u.setSALT(salt);
        u.setUsername(username);
        
        UtenteDao.insert(u);
        
        
        return "redirect:/technician.htm";
        
    }
    
    @RequestMapping(value = "technician/signin.htm", method = RequestMethod.POST,
            produces = "text/html;charset=UTF-8")
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        
        Utente u = UtenteDao.findByUsername(username);
        
        Hasher hasher = Hashing.sha256().newHasher();

        String passwordEncrypted = u.getPassword();
        String salt = u.getSALT();

        String newPassword = password + salt;

        hasher.putString(newPassword, Charsets.UTF_8);
        String sha256 = hasher.hash().toString();
        
        if (sha256.equals(passwordEncrypted)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            //manda a pagina login succeded


            request.setCharacterEncoding("UTF-8");
            request.getRequestDispatcher("ticketList.html").forward(request, response);
            
            
        } else {
            //error
        }
    }
    
    @RequestMapping(value = "technician/createticket.htm", method = RequestMethod.POST,
            produces = "text/html;charset=UTF-8")
    public String newTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String reason = request.getParameter("reason");
        String timeLeft = request.getParameter("timeleft");
        String brand  = request.getParameter("brand");
        String model = request.getParameter("model");
        Date dataRichiesta = new Date();
        
        
        //Find the technician that make the ticket
        String usernameTech = (String) request.getSession(false).getAttribute("username");
        Utente u = UtenteDao.findByUsername(usernameTech);
        
        String customerUsername = request.getParameter("customers");
        Cliente c = ClienteDao.findByUsername(customerUsername);
                
        if ("1".equals(request.getParameter("q1"))){
            
            String hdmi = request.getParameter("hdmi");
            String inches = request.getParameter("inches");
            
            TV tv = new TV();
            tv.setMarca(brand);
            tv.setModello(model);
            tv.setNumeroPorteHDMI(Integer.parseInt(hdmi));
            tv.setPollici(Integer.parseInt(inches));
            ApparecchioDao.insert(tv);
            
            Ticket ticket = new Ticket();
            ticket.setApparecchio(tv);
            ticket.setCliente(c);
            ticket.setDataRichiesta(dataRichiesta);
            ticket.setMotivoRichiesta(reason);
            ticket.setStato("In riparazione");
            ticket.setTempoRimanente(Integer.parseInt(timeLeft));
            ticket.setUtente(u);
            TicketDao.insert(ticket);
                        
        }else if("2".equals(request.getParameter("q1"))){
            
            String color = request.getParameter("color");
            String os = request.getParameter("os");
            
            Telefono t = new Telefono();
            t.setMarca(brand);
            t.setSistemaOp(os);
            t.setModello(model);
            t.setColore(color);
            ApparecchioDao.insert(t);
            
            Ticket ticket = new Ticket();
            ticket.setApparecchio(t);
            ticket.setCliente(c);
            ticket.setDataRichiesta(dataRichiesta);
            ticket.setMotivoRichiesta(reason);
            ticket.setStato("In riparazione");
            ticket.setTempoRimanente(Integer.parseInt(timeLeft));
            ticket.setUtente(u);
            TicketDao.insert(ticket);
      
        }
        
        return "ticketList.html";
    }
    
    
    
    
 
}
