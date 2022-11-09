-- 회원 데이터 입력
insert into app_member(mno,name,email,pwd) values(1,'user1','user1@test.com',sha2('1111',256));
insert into app_member(mno,name,email,pwd) values(2,'user2','user2@test.com',sha2('1111',256));
insert into app_member(mno,name,email,pwd) values(3,'user3','user3@test.com',sha2('1111',256));
insert into app_member(mno,name,email,pwd) values(4,'user4','user4@test.com',sha2('1111',256));
insert into app_member(mno,name,email,pwd) values(5,'user5','user5@test.com',sha2('1111',256));
insert into app_member(mno,name,email,pwd) values(6,'admin','admin@test.com',sha2('1111',256));

-- 회원 게시글 데이터 입력
insert into app_board(bno,title,cont,mno) values(11,'제목1','내용',1);
insert into app_board(bno,title,cont,mno) values(12,'제목2','내용',1);
insert into app_board(bno,title,cont,mno) values(13,'제목3','내용',1);
insert into app_board(bno,title,cont,mno) values(14,'제목4','내용',2);
insert into app_board(bno,title,cont,mno) values(15,'제목5','내용',2);
insert into app_board(bno,title,cont,mno) values(16,'제목6','내용',4);
insert into app_board(bno,title,cont,mno) values(17,'제목7','내용',4);
insert into app_board(bno,title,cont,mno) values(18,'제목8','내용',4);
insert into app_board(bno,title,cont,mno) values(19,'제목9','내용',4);
insert into app_board(bno,title,cont,mno) values(20,'제목10','내용',4);
insert into app_board(bno,title,cont,mno) values(21,'제목11','내용',4);
insert into app_board(bno,title,cont,mno) values(22,'제목12','내용',4);
insert into app_board(bno,title,cont,mno) values(23,'제목13','내용',4);
insert into app_board(bno,title,cont,mno) values(24,'제목14','내용',4);
insert into app_board(bno,title,cont,mno) values(16,'제목6','내용',4);





