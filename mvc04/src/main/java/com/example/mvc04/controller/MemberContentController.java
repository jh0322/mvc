package com.example.mvc04.controller;

import com.example.mvc04.model.MemberDAO;
import com.example.mvc04.model.MemberVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberContentController implements Controller{

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        MemberDAO dao = new MemberDAO();
        MemberVO vo = dao.memberContent(num);
        // 객체 바인딩
        request.setAttribute("vo", vo);
        return "/WEB-INF/member/memberContent.jsp";
    }
}
