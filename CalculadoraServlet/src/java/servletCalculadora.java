/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author EQUIPO
 */
@WebServlet(urlPatterns = {"/servletCalculadora"})
public class servletCalculadora extends HttpServlet {

    double numUno;
    double numDos;
    double k;
    double resultado;
    
    String operacion, MSJ="";
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        numUno =Integer.parseInt(request.getParameter("numUno"));
        numDos =Integer.parseInt(request.getParameter("numDos"));
        operacion = request.getParameter("operacion");

        if(operacion.equals("+")){
            resultado = numUno + numDos;
            MSJ="";
        }else
        if(operacion.equals("-")){
            resultado = numUno - numDos;
            MSJ=""; 
        }else
        if(operacion.equals("*")){
            resultado = numUno * numDos;
            MSJ="";
        }else
        if(operacion.equals("/")){
            resultado = numUno / numDos;
            MSJ="";
        }else
        if(operacion.equals("sen")){
            resultado = (Math.sin(Math.toRadians(numUno)));
            MSJ="";

        }else
        if(operacion.equals("tan")){
            if(numUno == 90 || numUno == 270)
                MSJ="LA TANGENTE DE 90 O 270 SE INDETERMINA";
            else{
             resultado = (Math.tan(Math.toRadians(numUno)));
             MSJ="";
            }
        }else
        if(operacion.equals("raiz")){
            if(numUno < 0){
                MSJ="Raíz imaginaria";
            }else{
                resultado = Math.sqrt(numUno);
            }
        }else
        if(operacion.equals("ln")){
            resultado = Math.log(numUno);
        }else
        if(operacion.equals("log10")){
            resultado = Math.log10(numUno);
        }
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<link rel='stylesheet' href='CSS.css'>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>RESULTADO</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado:" +resultado+ "</h1>");
            out.println("<h2>" +MSJ+ "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}