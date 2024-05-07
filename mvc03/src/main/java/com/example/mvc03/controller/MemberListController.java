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
import java.util.ArrayList;

@Slf4j
@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 클라이언트의 요청을 받기(memberList.do)
        // 2. 회원전체 리스트 가져오기(Model 연동)
        MemberDAO dao = new MemberDAO();
        ArrayList<MemberVO> list = dao.memberList();

        // 객체 바인딩 (request 바인딩)
        request.setAttribute("list", list);

        //forward 기법
        RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
        rd.forward(request, response);

    }
}
