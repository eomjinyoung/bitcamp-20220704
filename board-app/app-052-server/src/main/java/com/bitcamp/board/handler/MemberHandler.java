/*
 * 회원 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;

public class MemberHandler {

  private MemberDao memberDao;

  public MemberHandler(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  public void list(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<style>");
    out.println("tr:hover {");
    out.println("  background-color: navy;");
    out.println("  color: white;");
    out.println("}");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");
    out.println("<a href='form'>새 회원</a>");
    out.println("<table border='1'>");
    out.println("  <tr>");
    out.println("    <th>번호</th>");
    out.println("    <th>이름</th>");
    out.println("    <th>이메일</th>");
    out.println("  </tr>");

    List<Member> members = memberDao.findAll();
    for (Member member : members) {
      out.println("<tr>");
      out.printf("  <td>%d</td>", member.no);
      out.printf("  <td><a href='detail?no=%d'>%s</a></td>", member.no, member.name);
      out.printf("  <td>%s</td>", member.email);
      out.println("</tr>");
    }

    out.println("</table>");
    out.println("<p><a href='/'>메인</a></p>");
    out.println("</body>");
    out.println("</html>");
  }

  public void detail(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 상세 정보</h1>");

    int no = Integer.parseInt(paramMap.get("no"));
    Member member = memberDao.findByNo(no);

    if (member == null) {
      out.println("<p>해당 번호의 회원이 없습니다.</p>");

    } else {
      out.println("<form action='update'>");
      out.println("<table border='1'>");
      out.println("  <tr>");
      out.printf("    <th>번호</th><td><input name='no' type='number' value='%d' readonly></td>", member.no);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>이름</th><td><input name='name' type='text' value='%s' size='60'></td>", member.name);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>이메일</th><td><input name='email' type='email' value='%s' size='60'></td>", member.email);
      out.println("  </tr>");
      out.println("  <tr>");
      out.println("    <th>암호</th><td><input name='password' type='password' size='10'></td>");
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>등록일</th><td>%s</td>", member.createdDate);
      out.println("  </tr>");
      out.println("</table>");
      out.println("<p>");
      out.println("  <button type='submit'>변경</button>");
      out.printf("  <a href='delete?no=%d'>삭제</a>", member.no);
      out.println("</p>");
      out.println("</form>");
    }

    out.println("</body>");
    out.println("</html>");
  }

  public void delete(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<meta http-equiv='Refresh' content='1; url=list'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 삭제</h1>");

    int no = Integer.parseInt(paramMap.get("no"));

    if (memberDao.delete(no) == 0) {
      out.println("<p>해당 번호의 회원이 없습니다.</p>");

    } else {
      out.println("<p>해당 회원을 삭제했습니다.</p>");
    }

    out.println("</body>");
    out.println("</html>");

  }

  public void update(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<meta http-equiv='Refresh' content='1; url=list'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 변경</h1>");

    Member member = new Member();
    member.no = Integer.parseInt(paramMap.get("no"));
    member.name = paramMap.get("name");
    member.email = paramMap.get("email");
    member.password = paramMap.get("password");

    if (memberDao.update(member) == 0) {
      out.println("<p>해당 번호의 회원이 없습니다.</p>");

    } else {
      out.println("<p>해당 회원을 변경했습니다.</p>");
    }

    out.println("</body>");
    out.println("</html>");
  }

  public void form(Map<String, String> paramMap, PrintWriter out) {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 입력</h1>");

    out.println("<form action='add'>");
    out.println("<table border='1'>");
    out.println("  <tr>");
    out.println("    <th>이름</th><td><input name='name' type='text' size='60'></td>");
    out.println("  </tr>");
    out.println("  <tr>");
    out.println("    <th>이메일</th><td><input name='email' type='email' size='60'></td>");
    out.println("  </tr>");
    out.println("  <tr>");
    out.println("    <th>암호</th><td><input name='password' type='password' size='10'></td>");
    out.println("  </tr>");
    out.println("</table>");
    out.println("<p>");
    out.println("  <button type='submit'>등록</button>");
    out.println("  <a href='list'>목록</a>");
    out.println("</p>");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");

  }

  public void add(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<meta http-equiv='Refresh' content='1; url=list'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 입력</h1>");

    Member member = new Member();
    member.name = paramMap.get("name");
    member.email = paramMap.get("email");
    member.password = paramMap.get("password");

    if (memberDao.insert(member) == 0) {
      out.println("<p>회원을 등록할 수 없습니다!</p>");

    } else {
      out.println("<p>회원을 등록했습니다.</p>");
    }

    out.println("</body>");
    out.println("</html>");

  }
}




