package com.example.mvc04.frontcontroller;

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

        // 클라이언트가 어떤 요청을 했는지 파악하기
        String url = request.getRequestURI();

        if (url.equals("/memberList.do")) { // 회원리스트보기
            MemberDAO dao = new MemberDAO();
            List<MemberVO> list = dao.memberList();
            request.setAttribute("list", list);
            RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
            rd.forward(request,response);
        } else if (url.equals("/memberInsert.do")) { // 회원가입

        } else if (url.equals("/memberRegister.do")) { //회원가입 화면

        } else if (url.equals("/memberContent.do")) {

        } else if (url.equals("/memberUpdate.do")) {

        } else if (url.equals("/memberDelete.do")) {

        } //if_end
    }
}
