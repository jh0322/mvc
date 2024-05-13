package com.example.mvc04.controller;

import com.example.mvc04.model.MemberDAO;
import com.example.mvc04.model.MemberVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberInsertController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String nextPage = null;
        if (cnt > 0) {
            //가입성공
            nextPage = "redirect:/memberList.do";
        } else {
            //가입실패 -> 예외객체를 만들어서 WAS에게 던지자.
            throw new ServletException("not insert");
        }
        return nextPage;
    }
}
