package com.example.mvc03.controller;

import com.example.mvc03.model.MemberDAO;
import com.example.mvc03.model.MemberVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        MemberDAO dao = new MemberDAO();
        MemberVO vo = dao.memberContent(num);

        // 객체 바인딩
        request.setAttribute("vo", vo);
        RequestDispatcher rd = request.getRequestDispatcher("member/memberContent.jsp");
        rd.forward(request, response);

    }
}
