package com.example.mvc04.frontcontroller;

import com.example.mvc04.controller.*;

import java.util.HashMap;

public class HandlerMapping {

    private HashMap<String, Controller> mappings;
    public HandlerMapping(){
        mappings = new HashMap<String, Controller>();
        mappings.put("/memberList.do", new MemberListController());
        mappings.put("/memberInsert.do", new MemberInsertController());
        mappings.put("/memberRegister.do", new MemberRegisterController());
        mappings.put("/memberContent.do", new MemberContentController());
        mappings.put("/memberUpdate.do", new MemberUpdateController());
        mappings.put("/memberDelete.do", new MemberDeleteController());
    }

    public Controller getController(String key) { //key=>/memberList.do
        return mappings.get(key);
    }
}
