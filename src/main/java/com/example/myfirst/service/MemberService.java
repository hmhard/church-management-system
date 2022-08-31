package com.example.myfirst.service;

import com.example.myfirst.repository.MemberRepository;
import com.example.myfirst.dtos.MemberDTO;
import com.example.myfirst.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member>  getAll(){
        return  memberRepository.findAll();
    }

    public Optional<Member> getMember(String id){
        return  memberRepository.findById(Long.parseLong(id));
    }

    public Optional<Member> updateMember(String id, MemberDTO member) {

      Member existingMember= memberRepository.findById(Long.parseLong(id)).get();

      if(Objects.nonNull(existingMember)) {
          existingMember.setFirstName(member.getFirstName());
          existingMember.setMiddleName(member.getMiddleName());
          existingMember.setGender(member.getGender());
          existingMember.setRegisteredAt(new Date());

          memberRepository.save(existingMember);

      }
        return Optional.of(existingMember);


    }
    public  String deleteMember(String id){
        memberRepository.deleteById(Long.parseLong(id));
        return  "Deleted Successfully";
    }

    public Optional<Member> addMember(MemberDTO memberDto) {
        Member newMember=new Member();
        newMember.setFirstName(memberDto.getFirstName());
        newMember.setMiddleName(memberDto.getMiddleName());
        newMember.setLastName(memberDto.getLastName());
        newMember.setGender(memberDto.getGender());
        newMember.setRegisteredAt(new Date());
       if(memberDto.getFather()!=null)
        newMember.setFather(memberRepository.findById(Long.parseLong(memberDto.getFather())).orElse(null));
        if(memberDto.getMother()!=null)
        newMember.setMother(memberRepository.findById(Long.parseLong(memberDto.getMother())).orElse(null));

      return  Optional.of(memberRepository.save(newMember));

    }
}
