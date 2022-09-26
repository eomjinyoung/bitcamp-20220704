-- 게시글
DROP TABLE IF EXISTS app_board RESTRICT;

-- 회원
DROP TABLE IF EXISTS app_member RESTRICT;

-- 게시글
CREATE TABLE app_board (
  bno    INTEGER      NOT NULL COMMENT '게시글번호', -- 게시글번호
  title  VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
  cont   MEDIUMTEXT   NULL     COMMENT '내용', -- 내용
  mno    INTEGER      NULL     COMMENT '회원번호', -- 회원번호
  pwd    VARCHAR(100) NULL     COMMENT '암호', -- 암호
  cdt    DATETIME     NOT NULL DEFAULT now() COMMENT '등록일', -- 등록일
  vw_cnt INTEGER      NOT NULL DEFAULT 0 COMMENT '조회수' -- 조회수
)
COMMENT '게시글';

-- 게시글
ALTER TABLE app_board
  ADD CONSTRAINT PK_app_board -- 게시글 기본키
    PRIMARY KEY (
      bno -- 게시글번호
    );

ALTER TABLE app_board
  MODIFY COLUMN bno INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시글번호';

-- 회원
CREATE TABLE app_member (
  mno   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  name  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  email VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  pwd   VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
  cdt   DATETIME     NOT NULL DEFAULT now() COMMENT '등록일' -- 등록일
)
COMMENT '회원';

-- 회원
ALTER TABLE app_member
  ADD CONSTRAINT PK_app_member -- 회원 기본키
    PRIMARY KEY (
      mno -- 회원번호
    );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_app_member
  ON app_member ( -- 회원
    email ASC -- 이메일
  );

-- 회원 인덱스
CREATE INDEX IX_app_member
  ON app_member( -- 회원
    name ASC -- 이름
  );

ALTER TABLE app_member
  MODIFY COLUMN mno INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 게시글
ALTER TABLE app_board
  ADD CONSTRAINT FK_app_member_TO_app_board -- 회원 -> 게시글
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES app_member ( -- 회원
      mno -- 회원번호
    );