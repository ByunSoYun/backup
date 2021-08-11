--1단계
commit;

--관리자
CREATE TABLE tblAdmin (
 adminSeq number NOT NULL,
 id varchar2(20) NOT NULL,
 pw varchar2(20) NOT NULL
);

CREATE SEQUENCE adminSeq;

ALTER TABLE tblAdmin ADD CONSTRAINT PK_TBLADMIN PRIMARY KEY (
 adminSeq
);

--일반사용자
CREATE TABLE tblMember (
 memberSeq number NOT NULL,
 name varchar2(50) NOT NULL,
 id varchar2(50) NOT NULL,
 pw varchar2(50) NOT NULL,
 nickName varchar2(50) NOT NULL,
 registrationNumber varchar2(50) NOT NULL,
 tel varchar2(50) NOT NULL,
 address varchar2(100) NOT NULL,
 email varchar2(50) NOT NULL
);

CREATE SEQUENCE memberSeq;

ALTER TABLE tblMember ADD CONSTRAINT PK_TBLMEMBER PRIMARY KEY (
 memberSeq
);

--기업사용자
CREATE TABLE tblCompany (
 companySeq number NOT NULL,
 name varchar2(100) NOT NULL,
 id varchar2(100) NOT NULL,
 pw varchar2(100) NOT NULL,
 registrationNumber varchar2(200) NOT NULL,
 companyTel varchar2(200) NOT NULL,
 managerName varchar2(300) NOT NULL,
 managerEmail varchar2(300) NOT NULL,
 companyURL varchar2(500) NOT NULL
);
CREATE SEQUENCE companySeq;

ALTER TABLE tblCompany ADD CONSTRAINT PK_TBLCOMPANY PRIMARY KEY (
 companySeq
);


--2단계
--대여공간, 채용공고, 일반회원프로필, 커뮤니티, 스터디공고

--대여공간 
CREATE TABLE tblSpaceRental (
 rentalSeq number NOT NULL,
 name varchar2(100) NOT NULL,
 regDate date NOT NULL,
 hourpay number NOT NULL,
 address varchar2(500) NOT NULL,
 limitperson number NOT NULL,
 purpose varchar2(200) NOT NULL,
 startDate date NOT NULL,
 endDate date NOT NULL
);

CREATE SEQUENCE rentalSeq;

ALTER TABLE tblSpaceRental ADD CONSTRAINT PK_TBLSPACERENTAL PRIMARY KEY (
 rentalSeq
);



--일반회원프로필

CREATE TABLE tblMemberProfile (
 memberProfileSeq number NOT NULL,
 memberSeq number NOT NULL,
 career varchar2(50) ,
 academicBackground varchar2(50) ,
 gender varchar2(20) NULL,
 interestOccupation varchar2(100) ,
 availableLanguage varchar2(100) ,
 major varchar2(20),
 score number DEFAULT 0 
);

CREATE SEQUENCE memberProfileSeq;

ALTER TABLE tblMemberProfile ADD CONSTRAINT PK_TBLMEMBERPROFILE PRIMARY KEY (
 memberProfileSeq
);

ALTER TABLE tblMemberProfile ADD CONSTRAINT FK_Member_MemberProfile FOREIGN KEY (
 memberSeq
)
REFERENCES tblMember (
 memberSeq
);


--채용공고
CREATE TABLE tblJobPost (
 jobPostSeq number NOT NULL,
 companySeq number NOT NULL,
 postName varchar2(100) NOT NULL,
 regdate date DEFAULT sysdate NOT NULL,
 jobGroup varchar2(100) NOT NULL,
 career varchar2(200) NOT NULL,
 educationLevel varchar2(200) NOT NULL,
 jobType varchar2(100) NOT NULL,
 salary varchar2(200) NOT NULL,
 attachedFile varchar2(1000) NOT NULL,
 postContent varchar2(4000) NOT NULL,
 startDate date NOT NULL,
 endDate date NOT NULL
);

CREATE SEQUENCE jobPostSeq;

ALTER TABLE tblJobPost ADD CONSTRAINT PK_TBLJOBPOST PRIMARY KEY (
 jobPostSeq
);

ALTER TABLE tblJobPost ADD CONSTRAINT FK_tblCompany_TO_tblJobPost_1 FOREIGN KEY (
 companySeq
)
REFERENCES tblCompany (
 companySeq
);



--커뮤니티
CREATE TABLE tblCommunity (
 communitySeq number NOT NULL,
 memberSeq number NOT NULL,
 category varchar2(50) NOT NULL,
 title varchar2(200) NOT NULL,
 content varchar(4000) NOT NULL,
 regdate date NOT NULL,
 readCount number DEFAULT 0 NOT NULL
);

CREATE SEQUENCE communitySeq;

ALTER TABLE tblCommunity ADD CONSTRAINT PK_TBLCOMMUNITY PRIMARY KEY (
 communitySeq
);

ALTER TABLE tblCommunity ADD CONSTRAINT FK_tblMember_TO_tblCommunity_1 FOREIGN KEY (
 memberSeq
)
REFERENCES tblMember (
 memberSeq
);

--스터디 공고
CREATE TABLE tblStudyPost (
 studyPostSeq number NOT NULL,
 memberSeq number NOT NULL,
 postTitle varchar2(100) NOT NULL,
 content varchar2(2000) NOT NULL,
 name varchar2(100) NOT NULL,
 regdate date DEFAULT sysdate NOT NULL,
 readCount number NOT NULL,
 memberCount number NOT NULL,
 ageGroup varchar2(100) NOT NULL,
 career varchar2(100) NOT NULL,
 major varchar2(100) NOT NULL,
 jobGroup varchar2(100) NOT NULL,
 language varchar2(100) NOT NULL,
 period varchar2(100) NOT NULL,
 startDate date NOT NULL,
 endDate date NOT NULL,
 purpose varchar2(100) NOT NULL,
 close varchar2(100) DEFAULT 'n' NOT NULL
);
CREATE SEQUENCE studyPostSeq;
select * from tblStudyPost order by regdate;


ALTER TABLE tblStudyPost ADD CONSTRAINT PK_TBLSTUDYPOST PRIMARY KEY (
 studyPostSeq
);

ALTER TABLE tblStudyPost ADD CONSTRAINT FK_Member_tblSPost FOREIGN KEY (
 memberSeq
)
REFERENCES tblMember (
 memberSeq
);


--공간대여예약
CREATE TABLE tblSpaceReservation (
 reservationSeq number NOT NULL,
 memberSeq number NOT NULL,
 rentalSeq number NOT NULL,
 purpose varchar2(200) NOT NULL,
 reservationDate date NOT NULL, --예약을 한 날짜
 payDate date NOT NULL,
 request varchar2(2000) NOT NULL,
 startDate number NOT NULL,
 endDate number NOT NULL,
 personCount number NOT NULL,
 totalPay number NOT NULL
);
CREATE SEQUENCE reservationSeq;

ALTER TABLE tblSpaceReservation ADD CONSTRAINT PK_TBLSPACERESERVATION PRIMARY KEY (
 reservationSeq
);

ALTER TABLE tblSpaceReservation ADD CONSTRAINT FK_Member_SpaceRes FOREIGN KEY (
 memberSeq
)
REFERENCES tblMember (
 memberSeq
);

ALTER TABLE tblSpaceReservation ADD CONSTRAINT FK_SpaceRental_SpaceRes FOREIGN KEY (
 rentalSeq
)
REFERENCES tblSpaceRental (
 rentalSeq
);


--공간 대여 세부내용

CREATE TABLE tblSpaceContent (
 spaceContentSeq number NOT NULL,
 rentalSeq number NOT NULL,
 content1 varchar2(3000) NOT NULL,
 content2 varchar2(3000) NOT NULL,
 content3 varchar2(3000) NOT NULL,
 content4 varchar2(3000) NOT NULL,
 content5 varchar2(3000) NULL
);

CREATE SEQUENCE spaceContentSeq; 

ALTER TABLE tblSpaceContent ADD CONSTRAINT PK_tblSpaceContentN PRIMARY KEY (
 spaceContentSeq 
);

ALTER TABLE tblSpaceContent ADD CONSTRAINT FK_SpaceRent_Content FOREIGN KEY (
 rentalSeq
)
REFERENCES tblSpaceRental (
 rentalSeq
);

--공간대여 이미지 
CREATE TABLE tblSpaceImage (
 spaceImageSeq number NOT NULL,
 rentalSeq number NOT NULL,
 imagename varchar2(1000) NOT NULL
);

CREATE SEQUENCE spaceImageSeq; 

ALTER TABLE tblSpaceImage ADD CONSTRAINT PK_tblSpaceImage PRIMARY KEY (
 spaceImageSeq
);

ALTER TABLE tblSpaceImage ADD CONSTRAINT FK_SpaceRent_image FOREIGN KEY (
 rentalSeq
)
REFERENCES tblSpaceRental (
 rentalSeq
);

--공간대여위치

CREATE TABLE tblSpaceLocation (
 spaceLocSeq number NOT NULL,
 rentalSeq number NOT NULL,
 city varchar2(50) NOT NULL,
 gu varchar2(50) NULL,
 dong varchar2(50) NOT NULL,
 address varchar2(100) NOT NULL,
 latitude number NOT NULL,
 longitude number NOT NULL
);

CREATE SEQUENCE spaceLocSeq; 

ALTER TABLE tblSpaceLocation ADD CONSTRAINT PK_TBLSPACELOCATION PRIMARY KEY (
 spaceLocSeq
);

ALTER TABLE tblSpaceLocation ADD CONSTRAINT FK_SpaceRent_SpaceLocation FOREIGN KEY (
 rentalSeq
)
REFERENCES tblSpaceRental (
 rentalSeq
);


--테크QnA

CREATE TABLE tblTechQna (
 techQnaSeq number NOT NULL,
 memberSeq number NOT NULL,
 title varchar2(200) NOT NULL,
 content varchar2(2000) NOT NULL,
 regdate date DEFAULT sysdate NOT NULL,
 readCount number DEFAULT 0 NOT NULL,
 image varchar2(100) NULL
);

CREATE SEQUENCE techQnaSeq;

ALTER TABLE tblTechQna ADD CONSTRAINT PK_TBLTECHQNA PRIMARY KEY (
 techQnaSeq
);

ALTER TABLE tblTechQna ADD CONSTRAINT FK_tblMember_TO_tblTechQna_1 FOREIGN KEY (
 memberSeq
)
REFERENCES tblMember (
 memberSeq
);


--3단계
--채용공고위치, 채용지원자 정보, 커뮤댓글, 스터디댓글, 스터디지원정보, 스터디공고위치, 공간대여서비스평가, QnA댓글

--채용공고위치
CREATE TABLE tblJobLocation (
 jobLocSeq number NOT NULL,
 jobPostSeq number NOT NULL,
 city varchar2(50) NOT NULL,
 gu varchar2(50) NULL,
 dong varchar2(50) NOT NULL,
 address varchar2(500) NOT NULL,
 latitude number NOT NULL,
 longitude number NOT NULL
);

CREATE SEQUENCE jobLocSeq;

ALTER TABLE tblJobLocation ADD CONSTRAINT PK_TBLJOBLOCATION PRIMARY KEY (
 jobLocSeq
);

ALTER TABLE tblJobLocation ADD CONSTRAINT FK_JPost_tblJLocation FOREIGN KEY (
 jobPostSeq
)
REFERENCES tblJobPost (
 jobPostSeq
);



--채용지원자정보
CREATE TABLE tblJobSeekerInfo (
 seekerSeq number NOT NULL,
 memberSeq number NOT NULL,
 jobPostSeq number NOT NULL,
 attachedFile varchar2(1000) NOT NULL,
 readStatus varchar2(100) DEFAULT 'n' NOT NULL
);

CREATE SEQUENCE seekerSeq;

ALTER TABLE tblJobSeekerInfo ADD CONSTRAINT PK_TBLJOBSEEKERINFO PRIMARY KEY (
 seekerSeq
);

ALTER TABLE tblJobSeekerInfo ADD CONSTRAINT FK_Member_JSeekerInfo FOREIGN KEY (
 memberSeq
)
REFERENCES tblMember (
 memberSeq
);

ALTER TABLE tblJobSeekerInfo ADD CONSTRAINT FK_JobPost_JSeekerInfo1 FOREIGN KEY (
 jobPostSeq
)
REFERENCES tblJobPost (
 jobPostSeq
);


--커뮤니티댓글
CREATE TABLE tblCommunityComment (
 commentSeq number NOT NULL,
 memberSeq number NOT NULL,
 communitySeq number NOT NULL,
 content varchar2(2000) NOT NULL,
 regdate date DEFAULT sysdate NOT NULL
);

CREATE SEQUENCE commentSeq;

ALTER TABLE tblCommunityComment ADD CONSTRAINT PK_TBLCOMMUNITYCOMMENT PRIMARY KEY (
 commentSeq
);

ALTER TABLE tblCommunityComment ADD CONSTRAINT FK_Member_CommuComment FOREIGN KEY (
 memberSeq
)
REFERENCES tblMember (
 memberSeq
);

ALTER TABLE tblCommunityComment ADD CONSTRAINT FK_Community_tblCommuComment FOREIGN KEY (
 communitySeq
)
REFERENCES tblCommunity (
 communitySeq
);



--스터디댓글
CREATE TABLE tblStudyComment (
 studyCommentSeq number NOT NULL,
 studyPostSeq number NOT NULL,
 memberSeq number NOT NULL,
 regdate date DEFAULT sysdate NOT NULL,
 content varchar2(1000) NOT NULL
);

CREATE SEQUENCE studyCommentSeq;

ALTER TABLE tblStudyComment ADD CONSTRAINT PK_TBLSTUDYCOMMENT PRIMARY KEY (
 studyCommentSeq
);

ALTER TABLE tblStudyComment ADD CONSTRAINT FK_SPost_tblSComment FOREIGN KEY (
 studyPostSeq
)
REFERENCES tblStudyPost (
 studyPostSeq
);

ALTER TABLE tblStudyComment ADD CONSTRAINT FK_Member_tblSComment_1 FOREIGN KEY (
 memberSeq
)
REFERENCES tblMember (
 memberSeq
);


--QnA댓글

CREATE TABLE tblTechQnaComment (
 techQnaCommentSeq number NOT NULL,
 techQnaSeq number NOT NULL,
 memberSeq number NOT NULL,
 regdate date DEFAULT sysdate NOT NULL,
 content varchar2(2000) NOT NULL
);

CREATE SEQUENCE techQnaCommentSeq;

ALTER TABLE tblTechQnaComment ADD CONSTRAINT PK_TBLTECHQNACOMMENT PRIMARY KEY (
 techQnaCommentSeq
);

ALTER TABLE tblTechQnaComment ADD CONSTRAINT FK_Qna_TechQnaComment FOREIGN KEY (
 techQnaSeq
)
REFERENCES tblTechQna (
 techQnaSeq
);

ALTER TABLE tblTechQnaComment ADD CONSTRAINT FK_Member_QnaComment FOREIGN KEY (
 memberSeq
)
REFERENCES tblMember (
 memberSeq
);


--스터디지원정보
CREATE TABLE tblStudySeekerInfo (
 studySeekerInfoSeq number NOT NULL,
 studyPostSeq number NOT NULL,
 memberSeq number NOT NULL,
 seekerCheck varchar(15)  default 'n' NOT NULL,
 evalComplete varchar2(100) DEFAULT 'n' NOT NULL
);

CREATE SEQUENCE studySeekerInfoSeq;

ALTER TABLE tblStudySeekerInfo ADD CONSTRAINT PK_TBLSTUDYSEEKERINFO PRIMARY KEY (
 studySeekerInfoSeq
);

ALTER TABLE tblStudySeekerInfo ADD CONSTRAINT FK_SPost_SSeekerInfo FOREIGN KEY (
 studyPostSeq
)
REFERENCES tblStudyPost (
 studyPostSeq
);

ALTER TABLE tblStudySeekerInfo ADD CONSTRAINT FK_Member_StudySeekerInfo FOREIGN KEY (
 memberSeq
)
REFERENCES tblMember (
 memberSeq
);


--스터디공고위치
CREATE TABLE tblStudyLocation (
 studyLocSeq number NOT NULL,
 studyPostSeq number NOT NULL,
 city varchar2(50) NOT NULL,
 gu varchar2(50) NULL,
 latitude number NOT NULL,
 longitude number NOT NULL
);

CREATE SEQUENCE studyLocSeq;

ALTER TABLE tblStudyLocation ADD CONSTRAINT PK_TBLSTUDYLOCATION PRIMARY KEY (
 studyLocSeq
);

ALTER TABLE tblStudyLocation ADD CONSTRAINT FK_SPost_StudyLocation FOREIGN KEY (
 studyPostSeq
)
REFERENCES tblStudyPost (
 studyPostSeq
);

--공간대여서비스평가 --3단계

CREATE TABLE tblSpaceEvaluation (
 evaluationSeq number NOT NULL,
 reservationSeq number NOT NULL,
 review varchar2(2000) NOT NULL,
 cleanliness number NOT NULL,
 accessibility number NOT NULL,
 convenience number NOT NULL,
 price number NOT NULL,
 answer number NOT NULL
);

--공간대여스크랩
CREATE TABLE tblSpaceScrap (
    spaceScrapSeq VARCHAR(255)   NOT NULL,
    rentalSeq number NOT NULL,
    memberSeq number NOT NULL
);
CREATE SEQUENCE spaceScrapSeq;

ALTER TABLE tblSpaceScrap ADD CONSTRAINT PK_TBLSPACESCRAP PRIMARY KEY (
    spaceScrapSeq 
);

ALTER TABLE tblSpaceScrap ADD CONSTRAINT FK_SpaceRental_SpaceScrap FOREIGN KEY (
    rentalSeq 
)
REFERENCES tblSpaceRental (
    rentalSeq 
);

ALTER TABLE tblSpaceScrap ADD CONSTRAINT FK_tblMember_SpaceScrap FOREIGN KEY (
    memberSeq 
)
REFERENCES tblMember (
    memberSeq 
);

CREATE SEQUENCE evaluationSeq;

ALTER TABLE tblSpaceEvaluation ADD CONSTRAINT PK_TBLSPACEEVALUATION PRIMARY KEY (
 evaluationSeq
);

ALTER TABLE tblSpaceEvaluation ADD CONSTRAINT FK_SpaceRe_SpaceEval FOREIGN KEY (
 reservationSeq
)
REFERENCES tblSpaceReservation (
 reservationSeq
);



--채용공고스크랩
CREATE TABLE  tblJobPostScrap (
    jobScrapSeq VARCHAR(255) NOT NULL,
    jobPostSeq number NOT NULL,
    memberSeq number NOT NULL
);
CREATE SEQUENCE jobScrapSeq;


ALTER TABLE tblJobPostScrap ADD CONSTRAINT PK_TBLJOBPOSTSCRAP PRIMARY KEY (
    jobScrapSeq 
);

ALTER TABLE tblJobPostScrap ADD CONSTRAINT FK_tblJobPost_tblJobScrap FOREIGN KEY (
    jobPostSeq 
)
REFERENCES tblJobPost (
    jobPostSeq 
);

ALTER TABLE tblJobPostScrap ADD CONSTRAINT FK_tblMember_tblJobScrap FOREIGN KEY (
    memberSeq 
)
REFERENCES tblMember (
    memberSeq 
);




--스터디스크랩
CREATE TABLE tblStudyScrap (
   studyScrapSeq   number   NOT NULL,
   memberSeq   number   NOT NULL,
   studyPostSeq   number   NOT NULL
);

CREATE SEQUENCE studyScrapSeq;

ALTER TABLE tblStudyScrap ADD CONSTRAINT PK_TBLSTUDYSCRAB PRIMARY KEY (
   studyScrapSeq
);
ALTER TABLE tblStudyScrap ADD CONSTRAINT FK_tblMem_StudyScrap FOREIGN KEY (
   memberSeq
)
REFERENCES tblMember (
   memberSeq
);
ALTER TABLE  tblStudyScrap  ADD CONSTRAINT FK_StudyPost_StudyScrap FOREIGN KEY (
   studyPostSeq
)
REFERENCES tblStudyPost (
   studyPostSeq
);

--스터디추천
CREATE TABLE tblStudyrecommend (
   studyRecommendSeq number NOT NULL,
   recommend varchar2(20) NULL,
   memberSeq number NOT NULL,
   studyPostSeq number NOT NULL
);

CREATE SEQUENCE studyRecommendSeq;

ALTER TABLE tblStudyrecommend ADD CONSTRAINT PK_TBLSTUDYRECOMMEND PRIMARY KEY (
   studyRecommendSeq
);
ALTER TABLE tblStudyrecommend ADD CONSTRAINT FK_Member_Studyrec FOREIGN KEY (
   memberSeq
)
REFERENCES tblMember (
   memberSeq
);
ALTER TABLE tblStudyrecommend ADD CONSTRAINT FK_StudyPost_tblStudyrec FOREIGN KEY (
   studyPostSeq
)
REFERENCES tblStudyPost (
   studyPostSeq
);

--커뮤니티 추천수
CREATE TABLE  tblComrecommend  (
    ComRecSeq    number   NOT NULL,
    memberSeq    number   NOT NULL,
    communitySeq    number   NOT NULL,
    recommend    varchar2(20)   NOT NULL 
);

CREATE SEQUENCE ComRecSeq;

ALTER TABLE  tblComrecommend  ADD CONSTRAINT  PK_TBLCOMRECOMMEND  PRIMARY KEY (
    ComRecSeq 
);



ALTER TABLE  tblComrecommend  ADD CONSTRAINT  FK_Member_Comrecommend  FOREIGN KEY (
    memberSeq 
)
REFERENCES  tblMember  (
    memberSeq 
);


ALTER TABLE  tblComrecommend  ADD CONSTRAINT  FK_Community_Comrecommend  FOREIGN KEY (
    communitySeq 
)
REFERENCES  tblCommunity  (
    communitySeq 
);



--커뮤니티스크랩
CREATE TABLE  tblComScrap  (
    comScrapSeq VARCHAR(255)   NOT NULL,
    communitySeq number   NOT NULL,
    memberSeq number   NOT NULL
);

CREATE SEQUENCE comScrapSeq;

ALTER TABLE  tblComScrap  ADD CONSTRAINT  PK_TBLCOMSCRAP  PRIMARY KEY (
    comScrapSeq 
);


ALTER TABLE  tblComScrap  ADD CONSTRAINT  FK_Community_ComScrap  FOREIGN KEY (
    communitySeq 
)
REFERENCES  tblCommunity  (
    communitySeq 
);


ALTER TABLE  tblComScrap  ADD CONSTRAINT  FK_Member_tblComScrap  FOREIGN KEY (
    memberSeq 
)
REFERENCES  tblMember  (
    memberSeq 
);

-- 테크 Q&A 추천
CREATE TABLE tblTechQnaRecommend (
   techQnaRecSeq number NOT NULL,
   memberSeq number NOT NULL,
   techQnaSeq number NOT NULL,
   recommend varchar2(20) default 'n' NOT NULL
);

CREATE SEQUENCE TechQnaRecSeq;

ALTER TABLE tblTechQnaRecommend ADD CONSTRAINT PK_TBLTECHQNARECOMMEND PRIMARY KEY (
   techQnaRecSeq
);

ALTER TABLE tblTechQnaRecommend ADD CONSTRAINT FK_tblMember_tblTQRecommend FOREIGN KEY (
   memberSeq
)
REFERENCES tblMember (
   memberSeq
);

ALTER TABLE tblTechQnaRecommend ADD CONSTRAINT FK_tblTechQna_tblTQRecommend FOREIGN KEY (
   techQnaSeq
)
REFERENCES tblTechQna (
   techQnaSeq
);

-- 테크 Q&A 스크랩
CREATE TABLE tblTechQnaScrap (
   techQnaScSeq   number      NOT NULL,
   memberSeq   number      NOT NULL,
   techQnaSeq   number      NOT NULL
);

CREATE SEQUENCE techQnaScSeq;

ALTER TABLE tblTechQnaScrap ADD CONSTRAINT PK_TBLTECHQNASCRAP PRIMARY KEY (
   techQnaScSeq
);

ALTER TABLE tblTechQnaScrap ADD CONSTRAINT FK_tblMember_tblTQScrap FOREIGN KEY (
   memberSeq
)
REFERENCES tblMember (
   memberSeq
);

ALTER TABLE tblTechQnaScrap ADD CONSTRAINT FK_tblTechQna_tblTQScrap FOREIGN KEY (
   techQnaSeq
)
REFERENCES tblTechQna (
   techQnaSeq
);