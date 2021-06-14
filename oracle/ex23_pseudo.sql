
/*

ex23_pseudo.sql

Pseudo Column, 의사 컬럼
- 실제 컬럼이 아닌데 컬럼처럼 행동하는 객체

rownum
- 오라클 전용, MS-SQL(top), MySQL(limit)
- 행번호를 반환하는 컬럼
- 서브 쿼리에 많이 의존(인라인 뷰)
- rownum은 주로 from절이 호출될 때 같이 실행된다.(*********)

*/

-- 와일드카드(*)와 다른 컬럼(표현식 등)은 
select * from tblCountry;

select tblCountry.*, sysdate from tblCountry;

select c.*, sysdate from tblCountry c;


-- 질문의 조건에 1행이 포함되면 결과O, 포함 안되면 결과 X
select c.*, rownum from tblCountry c where rownum = 1;
select c.*, rownum from tblCountry c where rownum <= 5;
select c.*, rownum from tblCountry c where rownum = 5;
select c.*, rownum from tblCountry c where rownum >= 3 and rownum <= 7;


-- 급여를 많이 받는 순으로 1~10등까지 가져오기
select                              --2.
    name,
    basicpay,
    rownum
from tblInsa                        --1. 60명 + rownum 할당
    order by basicpay desc;         --3. rownum 이미 1번에서 할당이 끝남.
    
    

-- 인라인 뷰(from절 서브쿼리)
select name, basicpay, rnum, rownum from (select name, basicpay, rownum as rnum from tblInsa order by basicpay desc);

select name, basicpay, rownum from (select name, basicpay from tblInsa order by basicpay desc) where rownum <= 10;


-- 급여 순위 3~5등
-- rnum: 가운데 쿼리의 rownum, 정적인 번호
-- rownum: 바깥쪽 쿼리의 rownum, 동적인 번호
select name, basicpay, rnum from (select name, basicpay, rownum as rnum from (select name, basicpay from tblInsa order by basicpay desc))
    where rnum between 3 and 5;
    
    
-- basicpay + sudang -> 급여 순위

-- 정리.  이 2가지 경우만 이해하면 끝
-- Case A.
select name, basicpay + sudang as salary from tblInsa order by basicpay + sudang desc;

select name, salary, rownum as rnum from (select name, basicpay + sudang as salary from tblInsa order by basicpay + sudang desc)
    where rownum <= 3;

-- Case B.
select * from (select name, salary, rownum as rnum from (select name, basicpay + sudang as salary from tblInsa order by basicpay + sudang desc))
    where rnum between 5 and 10;



-- 지역별(hometown) 거주자가 몇명
select hometown, cnt, rownum as rnum from (select
                                        hometown,
                                        count(*) as cnt
                                    from tblAddressBook
                                        group by hometown
                                            order by count(*) desc)
                                                where rownum <= 3;
                                                
                                                

select * from (select hometown, cnt, rownum as rnum from (select
                                        hometown,
                                        count(*) as cnt
                                    from tblAddressBook
                                        group by hometown
                                            order by count(*) desc))
                                                where rnum = 5;
                                                
                                                
                                                
                                                
                                                
-- tblAddressBook. 직업별 인원수 -> 순위 1~10등, 11~20등
select
    job,
    count(*)
from tblAddressBook
    group by job
        order by count(*) desc;


select job, cnt, rownum as rnum from (select
                    job,
                    count(*) as cnt
                from tblAddressBook
                    group by job
                        order by count(*) desc);



select * from (select a.*, rownum as rnum from (select
                                                            job,
                                                            count(*) as cnt
                                                        from tblAddressBook
                                                            group by job
                                                                order by count(*) desc) a)
                                                                    where rnum between 1 and 10;


select * from (select a.*, rownum as rnum from (select
                                                            job,
                                                            count(*) as cnt
                                                        from tblAddressBook
                                                            group by job
                                                                order by count(*) desc) a)
                                                                    where rnum between 11 and 20;












