package com.example.mvc04.frontcontroller;

import com.example.mvc04.controller.Controller;
import com.example.mvc04.controller.MemberListController;
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
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            MemberVO vo = new MemberVO(id, password, name, age, email, phone);
            //Model 연동부분
            MemberDAO dao = new MemberDAO();
            int cnt = dao.memberInsert(vo);
            if (cnt > 0) {
                //가입성공
                response.sendRedirect("/memberList.do");
            } else {
                //가입실패 -> 예외객체를 만들어서 WAS에게 던지자.
                throw new ServletException("not insert");
            }
        } else if (url.equals("/memberRegister.do")) { //회원가입 화면
            RequestDispatcher rd = request.getRequestDispatcher("member/memberRegister.html");
            rd.forward(request,response);
        } else if (url.equals("/memberContent.do")) {
            int num = Integer.parseInt(request.getParameter("num"));
            MemberDAO dao = new MemberDAO();
            MemberVO vo = dao.memberContent(num);
            // 객체 바인딩
            request.setAttribute("vo", vo);
            RequestDispatcher rd = request.getRequestDispatcher("member/memberContent.jsp");
            rd.forward(request, response);
        } else if (url.equals("/memberUpdate.do")) {
            int num = Integer.parseInt(request.getParameter("num"));
            int age = Integer.parseInt(request.getParameter("age"));
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");

            MemberVO vo = new MemberVO();
            vo.setNum(num);
            vo.setAge(age);
            vo.setEmail(email);
            vo.setPhone(phone);

            MemberDAO dao = new MemberDAO();
            int cnt = dao.memberUpdate(vo);
            if (cnt > 0) {
                //가입성공
                response.sendRedirect("/memberList.do");
            } else {
                throw new ServletException("not update");
            }
        } else if (url.equals("/memberDelete.do")) {
            int num = Integer.parseInt(request.getParameter("num"));
            MemberDAO dao = new MemberDAO();
            int cnt = dao.memberDelete(num);

            if (cnt > 0) {
                response.sendRedirect("/memberList.do");
            } else {
                throw new ServletException("not delete");
            }

        } //if_end
    }
}
