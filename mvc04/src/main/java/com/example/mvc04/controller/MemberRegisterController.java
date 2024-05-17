package com.example.mvc04.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberRegisterController implements Controller{

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "memberRegister";
//        return "/WEB-INF/member/memberRegister.jsp";
    }
}
