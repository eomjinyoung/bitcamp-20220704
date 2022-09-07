-- 회원 데이터 입력
insert into app_member(name,email,pwd) values('user1','user1@test.com',sha2('1111',256));
insert into app_member(name,email,pwd) values('user2','user2@test.com',sha2('1111',256));
insert into app_member(name,email,pwd) values('user3','user3@test.com',sha2('1111',256));
insert into app_member(name,email,pwd) values('user4','user4@test.com',sha2('1111',256));
insert into app_member(name,email,pwd) values('user5','user5@test.com',sha2('1111',256));

-- 회원 게시글 데이터 입력
insert into app_board(title,cont,mno) values('제목1','내용',1);
insert into app_board(title,cont,mno) values('제목2','내용',1);
insert into app_board(title,cont,mno) values('제목3','내용',1);
insert into app_board(title,cont,mno) values('제목4','내용',2);
insert into app_board(title,cont,mno) values('제목5','내용',2);
insert into app_board(title,cont,mno) values('제목6','내용',4);

-- 비회원 게시글 데이터 입력
insert into app_board(title,cont,pwd) values('제목101','내용',sha2('1111',256));
insert into app_board(title,cont,pwd) values('제목102','내용',sha2('1111',256));
insert into app_board(title,cont,pwd) values('제목103','내용',sha2('',256));
insert into app_board(title,cont,pwd) values('제목104','내용',sha2('',256));




