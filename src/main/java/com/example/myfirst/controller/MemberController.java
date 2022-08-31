package com.example.myfirst.controller;

import com.example.myfirst.dtos.MemberDTO;
import com.example.myfirst.model.Member;
import com.example.myfirst.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/member")
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping
    public List<Member> getAll(){
       return memberService.getAll();
    }
    @PostMapping
    public  Optional<Member> add(@RequestBody @Valid MemberDTO body){
        return memberService.addMember(body);

    }

    @GetMapping("{id}")
    public Optional<Member> show(@PathVariable String id){
        return memberService.getMember(id);
    }
    @PutMapping("{id}")
    public  Optional<Member> update(@PathVariable String id, @RequestBody MemberDTO member){
        return memberService.updateMember(id,member);
    }
    @DeleteMapping("{id}")
    public  String delete(@PathVariable String id){
        return memberService.deleteMember(id);
    }

}
