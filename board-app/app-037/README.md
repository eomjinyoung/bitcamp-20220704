# 037. 인스턴스를 텍스트 형식으로 입출력하기: FileReader/FileWriter

## 작업 내용

### 1단계 - byte 스트림 클래스 대신 character 스트림 클래스로 교체한다.

- com.bitcamp.board.dao.XxxDao 클래스 변경
  - FileInputStream/FileOutputStream 대신 FileReader/FileWriter로 교체한다.
  - 데이터를 입출력 할 때는 CSV(Comma-Seperated Values) 형식을 사용한다.
- com.bitcamp.board.App 클래스 변경
  - 파일명의 확장자를 data 에서 csv 로 바꾼다.






