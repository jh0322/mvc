package com.example.mvc04.frontcontroller;

import com.example.mvc04.controller.*;
import com.example.mvc04.model.MemberDAO;
import com.example.mvc04.model.MemberVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        // 클라이언트가 어떤 요청을 했는지 파악하기
        String url = request.getRequestURI();
        Controller controller = null;
        String nextPage = null;
        //핸들러 매핑
        HandlerMapping mapping = new HandlerMapping();
        controller = mapping.getController(url);
        nextPage = controller.requestHandler(request, response);
        // forward, redirect
        if (nextPage != null) {
            if (nextPage.indexOf("redirect:") != -1) {
                response.sendRedirect(nextPage.split(":")[1]); //redirect
            } else {
                RequestDispatcher rd = request.getRequestDispatcher(nextPage); //forward
                rd.forward(request, response);
            }
        }

    }
}
