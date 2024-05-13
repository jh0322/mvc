package com.example.mvc04.controller;

import com.example.mvc04.model.MemberDAO;
import com.example.mvc04.model.MemberVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListController implements Controller{

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // POJO가 해야할 일의 범위
        // 1. Model 연동
        MemberDAO dao = new MemberDAO();
        List<MemberVO> list = dao.memberList();

        //2. 객체 바인딩
        request.setAttribute("list", list);
        //member/memberList.jsp
        // 다음페이지는
        return "/WEB-INF/member/memberList.jsp";

    }
}
