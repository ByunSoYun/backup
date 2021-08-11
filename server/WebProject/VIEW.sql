-- Q&A VIEW

-- Q&A 게시판의 댓글을 보기위한 뷰
create or replace view vwTechQnaComment
as select
    techQnaCommentSeq,
    techQnaSeq,
    memberSeq,
    regdate,
    content,
    (select nickname from tblMember where memberSeq = tblTechQnaComment.memberSeq) as nickname,
    (select id from tblMember where memberSeq = tblTechQnaComment.memberSeq) as id
from tblTechQnaComment;

-- Q&A게시판에서 추천수, 비추천수, isNew, 댓글수, 조회수를 추가한 뷰
create or replace view vwTechQna
as 
    select a.*, rownum as rnum from
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
                    from tblTechQna order by techQnaSeq desc) a;
    

-- 최신순으로 게시글을 볼 때 페이징을 위한 뷰
create or replace view vwTechQnaOrderRegdate
as 
    select a.*, rownum as rnum from
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
                    from tblTechQna order by regdate desc) a;
                    
                    

                    

-- 추천순으로 게시글을 볼 때 페이징을 위한 뷰
create or replace view vwTechQnaOrderRecommendCount
as 
    select a.*, rownum as rnum from
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
                    from tblTechQna order by recommendCount desc) a;


-- 댓글순으로 게시글을 볼 때 페이징을 위한 뷰
create or replace view vwTechQnaOrderCcnt
as 
    select a.*, rownum as rnum from
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
                    from tblTechQna order by ccnt desc) a;


-- 조회순으로 게시글을 볼 때 페이징을 위한 뷰
create or replace view vwTechQnaOrderReadCount
as 
    select a.*, rownum as rnum from
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
                    from tblTechQna order by readCount desc) a;
                    
                    

create or replace view vwTechQnaScrap
as
    (select tq.* from tblTechQna tq
        inner join tblTechQnaScrap tqs
            on tq.memberSeq = tqs.memberSeq);


-- 관리자가 회원 관리를 위해 필요한 회원 목록을 불러오는 뷰
create or replace view vwMember
as
    select m.*,
    (select score from tblMemberProfile where memberSeq = m.memberSeq) as score
from tblMember m;


-- 관리자가 회원 관리를 위해 필요한 회원 목록을 불러오면서 페이징하는 뷰
create or replace view vwMember2
as
    select a.*, rownum as rnum from 
                    (select *
                from vwMember) a;
                
                
create or replace view vwCompany
as
    select a.*, rownum as rnum from 
                    (select *
                from tblCompany) a;
                


----------------------------------------------------------------------------------------------------------------


-- 커뮤니티 뷰
-- 게시글 보여야하는거 가진 view 
create or replace view vwpost
as

select a.*,rownum as rnum from

(select
    c.communitySeq as seq,
    c.category as category,
    c.memberseq,
    c.title as title,
    c.content as content,
    c.regdate as regdate,
    c.readCount as readCount,
    (select count(commentSeq) from tblCommunityComment where tblCommunityComment.communitySeq = c.communitySeq) as commentCount,   --댓글수 
    m.nickName as nickName,     
    (sysdate) - (c.regdate) as isNew,
    (select count(comScrapSeq) from tblComScrap where tblComScrap.communitySeq = c.communitySeq) as scrapCount,      --스크랩수 
    (select count(comRecSeq) from tblComrecommend where tblComrecommend.communitySeq = c.communitySeq and tblComrecommend.recommend ='y') as recommendCount, --추천수
    (select count(comRecSeq) from tblComrecommend where tblComrecommend.communitySeq = c.communitySeq and tblComrecommend.recommend ='n') as decommendCount
from tblCommunity c
    inner join tblmember m
        on m.memberSeq = c.memberSeq
            order by regdate desc)a;

      
-- 코멘트 , 멤버 -> 댓글의 멤버 닉네임 알아야함 
create or replace view vwcomcomment
as

select a.*,rownum as rnum from

(select 
    c.commentSeq as commentseq,
    c.memberSeq as memberseq,
    c.communitySeq as communityseq,
    c.content as content,
    c.regdate as regdate,
    m.nickName as nickname,
    cm.category as category
    
from tblCommunityComment c
    inner join tblmember m
        on m.memberSeq = c.memberSeq 
            inner join tblCommunity cm
                on cm.communitySeq = c.communitySeq
            order by regdate desc) a;
            
            
            
        

create or replace view vwlivestory
as

select a.*,rownum as rnum from

(select
    c.communitySeq as seq,
    c.category as category,
    c.memberseq,
    c.title as title,
    c.content as content,
    c.regdate as regdate,
    c.readCount as readCount,
    (select count(commentSeq) from tblCommunityComment where tblCommunityComment.communitySeq = c.communitySeq) as commentCount,   --댓글수 
    m.nickName as nickName,  
    (sysdate) - (c.regdate) as isNew,
    (select count(comScrapSeq) from tblComScrap where tblComScrap.communitySeq = c.communitySeq) as scrapCount,      --스크랩수 
    (select count(comRecSeq) from tblComrecommend where tblComrecommend.communitySeq = c.communitySeq and tblComrecommend.recommend ='y') as recommendCount, --추천수
    (select count(comRecSeq) from tblComrecommend where tblComrecommend.communitySeq = c.communitySeq and tblComrecommend.recommend ='n') as decommendCount
from tblCommunity c
    inner join tblmember m
        on m.memberSeq = c.memberSeq
            where category ='사는얘기'
            order by regdate desc)a;
            
 create or replace view vwitevent
as

select a.*,rownum as rnum from

(select
    c.communitySeq as seq,
    c.category as category,
    c.memberseq,
    c.title as title,
    c.content as content,
    c.regdate as regdate,
    c.readCount as readCount,
    (select count(commentSeq) from tblCommunityComment where tblCommunityComment.communitySeq = c.communitySeq) as commentCount,   --댓글수 
    m.nickName as nickName,     
    (sysdate) - (c.regdate) as isNew,
    (select count(comScrapSeq) from tblComScrap where tblComScrap.communitySeq = c.communitySeq) as scrapCount,      --스크랩수 
    (select count(comRecSeq) from tblComrecommend where tblComrecommend.communitySeq = c.communitySeq and tblComrecommend.recommend ='y') as recommendCount, --추천수
    (select count(comRecSeq) from tblComrecommend where tblComrecommend.communitySeq = c.communitySeq and tblComrecommend.recommend ='n') as decommendCount
from tblCommunity c
    inner join tblmember m
        on m.memberSeq = c.memberSeq
            where category ='IT 행사'
            order by regdate desc)a;
            
                        
 create or replace view vwreview
as

select a.*,rownum as rnum from

(select
    c.communitySeq as seq,
    c.category as category,
    c.memberseq,
    c.title as title,
    c.content as content,
    c.regdate as regdate,
    c.readCount as readCount,
    (select count(commentSeq) from tblCommunityComment where tblCommunityComment.communitySeq = c.communitySeq) as commentCount,   --댓글수 
    m.nickName as nickName,
    (sysdate) - (c.regdate) as isNew,
    (select count(comScrapSeq) from tblComScrap where tblComScrap.communitySeq = c.communitySeq) as scrapCount,      --스크랩수 
    (select count(comRecSeq) from tblComrecommend where tblComrecommend.communitySeq = c.communitySeq and tblComrecommend.recommend ='y') as recommendCount, --추천수
    (select count(comRecSeq) from tblComrecommend where tblComrecommend.communitySeq = c.communitySeq and tblComrecommend.recommend ='n') as decommendCount
from tblCommunity c
    inner join tblmember m
        on m.memberSeq = c.memberSeq
            where category ='기술 서적 리뷰'
            order by regdate desc)a;
                       
                       
                                               
 create or replace view vwlicense
as

select a.*,rownum as rnum from

(select
    c.communitySeq as seq,
    c.category as category,
    c.memberseq,
    c.title as title,
    c.content as content,
    c.regdate as regdate,
    c.readCount as readCount,
    (select count(commentSeq) from tblCommunityComment where tblCommunityComment.communitySeq = c.communitySeq) as commentCount,   --댓글수 
    m.nickName as nickName,         
     (sysdate) - (c.regdate) as isNew,
    (select count(comScrapSeq) from tblComScrap where tblComScrap.communitySeq = c.communitySeq) as scrapCount,      --스크랩수 
    (select count(comRecSeq) from tblComrecommend where tblComrecommend.communitySeq = c.communitySeq and tblComrecommend.recommend ='y') as recommendCount, --추천수
    (select count(comRecSeq) from tblComrecommend where tblComrecommend.communitySeq = c.communitySeq and tblComrecommend.recommend ='n') as decommendCount
from tblCommunity c
    inner join tblmember m
        on m.memberSeq = c.memberSeq
            where category ='자격증 정보'
            order by regdate desc)a;
                       


create or replace view vwCategory
as
(select 
    category as name,
    count(*) as num
from tblCommunity 
    group by category);
    

create or replace view vwCategoryComment 
as 
(select 
    category as name,
    count(*) as num
from vwcomcomment
    group by category);
    





-- 채용공고 뷰

create or replace view vwJobPost
as 
select j.*, rownum as rnum from
(select
    c.companySeq as companySeq,
    c.name as name,
    p.jobPostSeq as jobPostSeq,
    p.postname as postName,
    p.career as career,
    p.educationlevel as educationLevel,
    p.attachedFile as attachedFile,
    p.regdate as regdate,
    p.jobGroup as jobGroup,
    p.jobType as jobType,
    p.startDate as startDate,
    p.endDate as endDate,
    l.city as city,
    l.gu as gu,
    l.dong as dong,
    l.address
from tblCompany c 
    inner join tblJobPost p 
        on c.companySeq = p.companySeq
            inner join tblJobLocation l
                on p.jobpostseq = l.jobpostseq
                order by p.regdate asc) j;

create or replace view vwJobView
as 
select
    c.companySeq as companySeq,
    p.jobPostSeq as jobPostSeq,
    c.name as name,
    p.postname as postName,
    p.career as career,
    p.educationlevel as educationLevel,
    p.jobGroup as jobGroup,
    p.salary as salary,
    p.attachedFile as attachedFile,
    p.jobType as jobType,
    p.postContent as postContent,
    p.startDate as startDate,
    p.endDate as endDate,
    l.jobLocSeq as jobLocSeq,
    l.city as city,
    l.gu as gu,
    l.dong as dong,
    l.address as address,
    l.latitude as latitude,
    l.longitude as longitude
from tblCompany c 
    inner join tblJobPost p 
        on c.companySeq = p.companySeq
            inner join tblJobLocation l
                on p.jobpostseq = l.jobpostseq;
                
create or replace view vwJobScrap
as
select 
    c.companySeq as companySeq,
    j.jobPostSeq as jobPostSeq,
    ps.memberSeq as memberSeq
from tblCompany c 
    inner join tblJobPost j
        on c.companySeq = j.companySeq 
    inner join tblJobPostScrap ps 
        on j.jobPostSeq = ps.jobPostSeq;


create or replace view vwSeekerInfo
as 
select 
    si.jobpostseq as jobpostseq,
    m.name as name, 
    m.memberSeq as memberSeq,
    m.registrationnumber as registrationnumber,
    mp.career as career,
    mp.major as major,
    mp.interestoccupation as interestoccupation,
    mp.academicbackground as academicbackground, 
    mp.availablelanguage as availablelanguage,
    si.readstatus as readstatus,
    si.attachedfile as attachedfile
from tblJobSeekerInfo si
    inner join tblMember m
        on m.memberseq = si.memberSeq
    inner join tblmemberprofile mp
        on m.memberseq = mp.memberseq;
        
create or replace view vwMyJob
as
select 
    m.memberSeq as memberSeq,
    m.name as name,
    j.jobPostSeq as jobPostSeq,
    c.name as companyName,
    j.postName as postName ,
    j.attachedFile as attachedFile
from tblJobPost j
    inner join tblCompany c
    on c.companySeq = j.companySeq
    inner join tblJobSeekerInfo s
    on j.jobPostSeq = s.jobPostSeq
    inner join tblMember m
    on m.memberseq = s.memberSeq;

--------------------------------------------------------------------------------------
-- 스터디 공고
create or replace view vwstudy
as
select a.*,rownum as rnum from
(select
    s.studyPostSeq as studyPostSeq,
    s.postTitle as postTitle,
    s.memberseq,
    s.content as content,
    s.name as name,
    s.regdate as regdate,
    s.readCount as readCount,
    s.memberCount as memberCount,
    s.ageGroup as ageGroup,
    s.career as career,
    s.major as major,
    s.jobGroup as jobGroup,
    s.language as language,
    s.period as period,
    s.startDate as startDate,
    s.endDate as endDate,
    s.purpose as purpose,
    s.close as close,
    (sysdate - s.regdate) as isnew,
    (select count(studyCommentSeq) from tblStudyComment where tblStudyComment.studyPostSeq = s.studyPostSeq) as commentCount,   --댓글수 
    m.nickName as nickName,         
    (select count(studyScrapSeq) from tblStudyScrap where tblStudyScrap.studyPostSeq = s.studyPostSeq) as scrapCount,      --스크랩수 
    (select count(studyRecommendSeq) from tblStudyrecommend where tblStudyrecommend.studyPostSeq = s.studyPostSeq and tblStudyrecommend.recommend ='y') as recommendCount, --추천수
    (select count(studyRecommendSeq) from tblStudyrecommend where tblStudyrecommend.studyPostSeq = s.studyPostSeq and tblStudyrecommend.recommend ='n') as decommendCount, 
    p.score as score,
    l.city as city,
    l.gu as gu,
    l.latitude as latitude,
    l.longitude as longitude
from tblStudyPost s
    inner join tblmember m
        on m.memberSeq = s.memberSeq
            inner join tblMemberProfile p
                on m.memberSeq = p.memberSeq
                    inner join tblStudyLocation l
                        on s.studypostseq = l.studypostseq
                            order by s.regdate desc) a;


create or replace view vwcomment
as
select a.*,rownum as rnum from
(select
    c.studyCommentSeq as studyCommentSeq,
    c.studyPostSeq as studyPostSeq,
    c.memberSeq as memberSeq,
    c.regdate as regdate,
    c.content as content,
    (sysdate - c.regdate) as isnew,
    m.nickName as nickName
from tblStudyComment c
    inner join tblmember m
        on c.memberseq = m.memberseq
            order by c.regdate desc) a;
            


create or replace view vwmempro
as
select
    m.memberSeq as memberSeq,
    m.name as name,
    m.id as id,
    m.pw as pw,
    m.nickName as nickName,
    m.registrationNumber as registrationNumber,
    m.tel as tel,
    m.address as address,
    m.email as email,
    p.memberProfileSeq as memberProfileSeq,
    p.career as career,
    p.academicBackground as academicBackground,
    p.gender as gender,
    p.interestOccupation as interestOccupation,
    p.availableLanguage as availableLanguage,
    p.major as major,
    p.score as score
from tblmember m
    inner join tblMemberProfile p
        on m.memberSeq = p.memberSeq;

-------------------------------------------------------










commit;