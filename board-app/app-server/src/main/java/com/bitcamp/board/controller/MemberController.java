package com.bitcamp.board.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {

  MemberService memberService;
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("form")
  public void form() throws Exception {
  }

  @PostMapping("add")
  public String add(Member member) throws Exception {
    memberService.add(member);
    return "redirect:list";
  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    // 프론트 컨트롤러가 건네준 Model 객체에 작업 결과를 담아 두면 
    // 핸들러 호출이 끝났을 때 JSP 를 실행하기 전에
    // 먼저 Model 객체에 담아둔 값을 ServletRequest 보관소로 옮긴다.
    model.addAttribute("members", memberService.list());
  }

  @GetMapping("detail")
  public void detail(int no, Map map) throws Exception {
    Member member = memberService.get(no);

    if (member == null) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    }

    map.put("member", member);
  }

  @PostMapping("update")
  public String update(Member member) throws Exception {
    if (!memberService.update(member)) {
      throw new Exception("회원 변경 오류입니다!");
    }

    return "redirect:list";
  }

  @GetMapping("delete")
  public String delete(int no) throws Exception {
    if (!memberService.delete(no)) {
      throw new Exception("회원 삭제 오류입니다!");
    }

    return "redirect:list";
  }
}






