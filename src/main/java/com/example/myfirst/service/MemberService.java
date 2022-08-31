package com.example.myfirst.service;

import com.example.myfirst.dao.MemberRepository;
import com.example.myfirst.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public Optional<Member> updateMember(String id, Member member) {

      Member member1= memberRepository.findById(Long.parseLong(id)).orElse(null);

      member1.setFirstName(member.getFirstName());
      member1.setMiddleName(member.getMiddleName());
      member1.setGender(member.getGender());
      memberRepository.save(member1);
      return Optional.of(member1);

    }
    public  String deleteMember(String id){
        memberRepository.deleteById(Long.parseLong(id));
        return  "Deleted Successfully";
    }

    public Optional<Member> addMember(Map<String,String> member) {
        Member member1=new Member();
        member1.setFirstName(member.get("firstName"));
        member1.setMiddleName(member.get("middleName"));
        member1.setLastName(member.get("lastName"));
        member1.setGender(member.get("gender"));
        member1.setGender(member.get("gender"));
      return  Optional.of(memberRepository.save(member1));

    }
}
