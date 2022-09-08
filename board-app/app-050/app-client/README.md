# 050. 트랜잭션 다루기 - 자동 커밋과 수동 커밋

## 작업 내용

### 1단계 - 회원 데이터 삭제할 때 게시글 데이터도 묶어 함께 삭제한다. 

- com.bitcamp.board.dao.MariaDBMemberDao 클래스 변경
  - delete() 메서드에 수동 커밋을 적용한다.
