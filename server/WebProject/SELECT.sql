select * from tblMember;
select * from vwMember where id like '%Jang1212%';
SELECT * FROM VWMEMBER;
SELECT * FROM VWMEMBER2;
select * from tblTechQna order by techqnaseq desc;
select * from tblTechQnaComment;
select * from tblCommunity;
select * from tblCommunityComment;
select * from tblTechQnaRecommend;
select * from tblTechQnaScrap;
select * from tblStudyPost;
select * from tblJobPost;
select * from tblMemberProfile order by memberseq;
select * from tblcomrecommend;
select * from tblcomscrap;
select * from tblAdmin;
select * from vwTechQna order by techQnaSeq desc;
select count(*) from vwTechQna where column like search;
select * from vwTechQnaComment order by techQnaCommentSeq desc;
select readCount from vwTechQna where techQnaSeq = 3;
select * from vwTechQna where rnum between 11 and 15 order by rnum desc;
select * from vwTechQna where rnum between 1 and 10 order by regdate desc;
select * from vwTechQna where rnum between 11 and 20 order by regdate desc;
select * from vwTechQna where rnum between (select max(rownum)-9 from vwTechQna) and (select max(rownum) from vwTechQna) order by regdate desc;
select * from tblTechQnaRecommend;
select * from vwTechQna where techQnaSeq = 5;
select * from vwTechQna where title like '%질문%';
select * from vwTechQna where rownum between 1 and (select max(rownum) from vwTechQna) order by regdate desc;
select * from tblMemberProfile where memberSeq = 1;
select * from tblStudyPost where memberSeq = 1;
select * from tblCommunity where memberSeq = 1;
select * from tblTechQna where memberSeq = 1;
select name, (select count(*) from tblTechQna where memberSeq = 2) as qnaCount, (select count(*) from tblCommunity where memberSeq = 2) as comCount, (select count(*) from tblStudyPost where memberSeq = 1) as studyCount from tblMember where memberSeq = 2;
select name, (select count(*) from tblTechQnaComment where memberSeq = 1) as qnaCommentCount, (select count(*) from tblCommunityComment where memberSeq = 1) as communityCommentCount, (select count(*) from tblStudyComment where memberSeq = 1) as studyCommentCount from tblMember where memberSeq = 1;
select * from tblStudyComment;
select * from tblMember;
select * from vwMember;
select * from tblCompany where name like '%오픈서베이%';
select * from vwCompany;
select * from tblCompany;
select * from vwTechQna where memberSeq = 1;
select * from tblMember;
select * from tblCompany;

commit;

-- 검색창에서 검색어를 입력하고 난 결과물을 페이징할 수 있도록 출력하는 셀렉트문
select * from 
(select b.*, rownum as rnum from (select a.* from
                (select
                techQnaSeq,
                memberSeq,
                title,
                content,
                regdate,
                (sysdate - regdate) as isNew,
                readCount,
                image,
                (select nickName from tblMember where memberSeq = tblTechQna.memberSeq) as nickName,
                (select id from tblMember where memberSeq = tblTechQna.memberSeq) as id,
                (select count(*) from tblTechQnaComment where techQnaSeq = tblTechQna.techQnaSeq) as ccnt,
                (select count(*) from tblTechQnaRecommend where techQnaSeq = tblTechQna.techQnaSeq and recommend = 'y') as recommendCount,
                (select count(*) from tblTechQnaRecommend where techQnaSeq = tblTechQna.techQnaSeq and recommend = 'n') as decommendCount
from tblTechQna order by regdate desc) a where title like '%질문%') b) where rnum between 11 and 20;

-- 1 10
-- 11 20
-- 21 30
-- 31 40
-- x  x+9
-- x+10 x+19
-- x+20 x+29
select * from tblTechQnaScrap where techQnaSeq = 93;

select * from vwTechQna order by ccnt desc;
select * from tblTechQnaScrap where memberSeq = 1;
select * from tblTechQna where techQnaSeq = 99;
select * from vwTechQna q
    inner join tblTechQnaScrap s
        on q.techQnaSeq = s.techQnaSeq
            where s.memberSeq = 1;
select * from tblMember where memberSeq = 1;
select name, (select count(*) from tblComScrap where memberSeq = 1) as communityScrapCount, (select count(*) from tblTechQnaScrap where memberSeq = 1) as qnaScrapCount, (select count(*) from tblStudyScrap where memberSeq = 1) as studyScrapCount, (select count(*) from tblJobPostScrap where memberSeq = 1) as jobPostScrapCount, (select count(*) from tblSpaceScrap where memberSeq = 1) as spaceScrapCount from tblMember where memberSeq = 1;
select * from vwMember where memberSeq = 2;
select * from vwMemberProfile;
select count(*) as jobPostScrapCount from tblJobPostScrap where memberSeq = 1;
select * from vwTechQna where memberSeq = 99;
select techQnaSeq from tblTechQna where memberSeq = 99;
select * from tblTechQnaRecommend where memberSeq = 99;

select b.*, rownum as rnum from (select a.*, rownum from
                (select
                techQnaSeq,
                memberSeq,
                title,
                content,
                regdate,
                (sysdate - regdate) as isNew,
                readCount,
                image,
                (select nickName from tblMember where memberSeq = tblTechQna.memberSeq) as nickName,
                (select id from tblMember where memberSeq = tblTechQna.memberSeq) as id,
                (select count(*) from tblTechQnaComment where techQnaSeq = tblTechQna.techQnaSeq) as ccnt,
                (select count(*) from tblTechQnaRecommend where techQnaSeq = tblTechQna.techQnaSeq and recommend = 'y') as recommendCount,
                (select count(*) from tblTechQnaRecommend where techQnaSeq = tblTechQna.techQnaSeq and recommend = 'n') as decommendCount
from tblTechQna order by regdate desc) a where rownum between 11 and 20 and title like '%질문%') b;



select a.*, rownum as rnum1 from
                (select
                techQnaSeq,
                memberSeq,
                title,
                content,
                regdate,
                (sysdate - regdate) as isNew,
                readCount,
                image,
                (select nickName from tblMember where memberSeq = tblTechQna.memberSeq) as nickName,
                (select id from tblMember where memberSeq = tblTechQna.memberSeq) as id,
                (select count(*) from tblTechQnaComment where techQnaSeq = tblTechQna.techQnaSeq) as ccnt,
                (select count(*) from tblTechQnaRecommend where techQnaSeq = tblTechQna.techQnaSeq and recommend = 'y') as recommendCount,
                (select count(*) from tblTechQnaRecommend where techQnaSeq = tblTechQna.techQnaSeq and recommend = 'n') as decommendCount
from tblTechQna where rownum between 11 and 20 and title like '%자바%' order by regdate desc) a;



select * from
    (select b.*, rownum as rnum from (select a.* from 
                                                (select
                                                techQnaSeq,
                                                memberSeq,
                                                title,
                                                content,
                                                regdate,
                                                (sysdate - regdate) as isNew,
                                                readCount,
                                                image,
                                                (select nickName from tblMember where memberSeq = tblTechQna.memberSeq) as nickName,
                                                (select id from tblMember where memberSeq = tblTechQna.memberSeq) as id,
                                                (select count(*) from tblTechQnaComment where techQnaSeq = tblTechQna.techQnaSeq) as ccnt,
                                                (select count(*) from tblTechQnaRecommend where techQnaSeq = tblTechQna.techQnaSeq and recommend = 'y') as recommendCount,
                                                (select count(*) from tblTechQnaRecommend where techQnaSeq = tblTechQna.techQnaSeq and recommend = 'n') as decommendCount
                                                from tblTechQna order by regdate desc) a where content like '%질문%') b) where rnum between 11 and 20;

select * from tblMember;


commit;
