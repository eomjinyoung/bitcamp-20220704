# 033. 입출력 API를 사용하여 데이터를 파일로 저장하기: 바이너리 저장

## 작업 내용

### 1단계 - DAO 클래스에 파일에 데이터를 저장하고 로딩하는 메서드를 추가한다.

- com.bitcamp.board.dao.XxxDao 클래스 변경
  - 생성자에 파일 이름을 받는 파라미터를 추가한다.
  - load(), save() 메서드 추가

### 2단계 - Handler 클래스에서 입력, 변경, 삭제할 때 파일로 출력한다.

- com.bitcamp.board.handler.XxxHandler 클래스 변경