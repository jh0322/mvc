package com.example.mvc03.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/rc.do")
public class RedirectController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = "shin";
        int age = 26;
        String email = "sinmagic1@naver.com";
        response.sendRedirect("view/result.jsp?name="+name+"&age="+age+"&email="+email);

    }
}
