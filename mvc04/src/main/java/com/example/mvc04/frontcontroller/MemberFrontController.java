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

        if (url.equals("/memberList.do")) { // 회원리스트보기
            controller = new MemberListController();
            nextPage = controller.requestHandler(request,response);
            RequestDispatcher rd = request.getRequestDispatcher(nextPage);
            rd.forward(request,response);
        } else if (url.equals("/memberInsert.do")) { // 회원가입
            controller = new MemberInsertController();
            nextPage = controller.requestHandler(request, response);
            response.sendRedirect(nextPage);
        } else if (url.equals("/memberRegister.do")) { //회원가입 화면
            controller = new MemberRegisterController();
            nextPage = controller.requestHandler(request, response);
            RequestDispatcher rd = request.getRequestDispatcher(nextPage);
            rd.forward(request,response);
        } else if (url.equals("/memberContent.do")) {
            controller = new MemberContentController();
            nextPage = controller.requestHandler(request, response);
            RequestDispatcher rd = request.getRequestDispatcher(nextPage);
            rd.forward(request, response);
        } else if (url.equals("/memberUpdate.do")) {
            controller = new MemberUpdateController();
            nextPage = controller.requestHandler(request, response);
            response.sendRedirect(nextPage);
        } else if (url.equals("/memberDelete.do")) {
            controller = new MemberDeleteController();
            nextPage = controller.requestHandler(request, response);
            response.sendRedirect(nextPage);
        } //if_end
    }
}
