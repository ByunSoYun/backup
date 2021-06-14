/*ex21_view

뷰 , View 
- DB Object 중 하나(테이블, 시퀀스, 제약사항, 뷰)-< 데티ㅇ베이스 영구저장
- 가상 테이블, 뷰 테이블 
- 일종의 테이블의 복사본
-뷰는 테이블처럼 취급한다.
- 자주 사용하는 select 의 결과를 저장하는 객체(*****)
- 테이브르을 직접 사용하는것에 비해 간편함(구문 단축)


create view 뷰이름
as
select문
*/


create view vwInsa
as 
select * from tblInsa;

select * from tblInsa;
select * from vwInsa;




create or replace view vwInsaMaleSeoul
as
select * from tblInsa where substr(ssn, 8, 1) = '1' and city = '서울';

select * from vwInsaMaleSeoul;


select * from hr.tblInsa;

create or replace view vwVideo
as
select 
    m.name as "회원명",
    v.name as "비디오제목",
    r.rentdate as "대여날짜",
    case 
        when r.retdate is null then '반납안함'
        when r.retdate is not null then '반납완료'
    end as "반납상태"
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r 
                on v.seq = r.video
                    inner join tblMember m
                        on m.seq = r.member;
                        
select * from vwVideo;


--서울 직원 뷰 
create or replace view vwSeoul
as
select * from tblInsa where city = '서울';

select * from vwSeoul;

commit;