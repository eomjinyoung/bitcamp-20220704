# 033. 파일 API를 사용하여 데이터를 바이너리 형식으로 입출력하기: FileInputStream/FileOutputStream
## 작업 내용

### 1단계 - DAO 클래스에 파일에 데이터를 저장하고 로딩하는 메서드를 추가한다.

- com.bitcamp.board.dao.XxxDao 클래스 변경
  - 생성자에 파일 이름을 받는 파라미터를 추가한다.
  - load(), save() 메서드 추가

### 2단계 - Handler 클래스에서 입력, 변경, 삭제할 때 파일로 출력한다.

- com.bitcamp.board.handler.XxxHandler 클래스 변경