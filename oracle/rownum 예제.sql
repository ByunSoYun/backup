
--1. tblInsa. 남자 급여(기본급+수당)을 (내림차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)

select * from tblInsa;
select name, 급여, rownum from (
select
    name, 
    basicpay + sudang as 급여 
from tblInsa
    where substr(ssn,8,1) = 1 
        order by basicpay + sudang desc);
                                                

--2. tblInsa. 여자 급여(기본급+수당)을 (오름차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)

select name, 급여, rownum from (
select
    name, 
    basicpay + sudang as 급여 
from tblInsa
    where substr(ssn,8,1) = 2 
        order by basicpay + sudang asc);
        
        
--3. tblInsa. 여자 인원수가 가장 많은 부서 및 인원수 가져오시오.
select buseo, inwon, rownum  from 
(select 
buseo,
count(*) as inwon
from tblInsa
    where substr(ssn,8,1) = 2 
        group by buseo
            order by count(*) desc)
            where rownum = 1 ;

--4. tblInsa. 지역별 인원수 (내림차순)순위를 가져오시오.(city, 인원수)
select *
from tblInsa;


select city,지역별인원수,rownum as 순위 from(
select 
city,
count(*) as 지역별인원수

from tblInsa 
    group by city
        order by 지역별인원수 desc);
        


--5. tblInsa. 부서별 인원수가 가장 많은 부서 및 인원수 출력.

select buseo, inwon, rownum  from 
(select 
buseo,
count(*) as inwon
from tblInsa
        group by buseo
            order by count(*) desc)
            where rownum = 1 ;

--6. tblInsa. 남자 급여(기본급+수당)을 (내림차순) 3~5등까지 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)

select * from tblInsa;
select name,buseo,jikwi, 급여, rnum as 순위 
from(select name,buseo,jikwi, 급여, rownum as rnum from (
select
    name, 
    buseo,
    jikwi,
    basicpay + sudang as 급여 
from tblInsa
    where substr(ssn,8,1) = 1 
        order by basicpay + sudang desc))
        where rnum between 3 and 5;
        
                                                
--7. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.
select * from tblInsa;

select 
name,
buseo,
jikwi,
ibsadate,
rownum as 입사순위 
from
(select 
name,
buseo,
jikwi,
ibsadate
from tblInsa
    order by ibsadate asc)
    where rownum<6;



--8. tblhousekeeping. 지출 내역(가격 * 수량) 중 가장 많은 금액을 지출한 내역 3가지를 가져오시오.
select *
from tblhousekeeping;

select item, 지출내역, rownum as 순위 from
(select 
    price*qty as 지출내역,
    item
from tblhousekeeping
    order by 지출내역 desc)
    where rownum <4;
    
    
--9. tblinsa. 평균 급여 2위인 부서에 속한 직원들을 가져오시오.

select *
from (select e.*, rowNum as rNum
from (select buseo, count(*), round(avg(basicpay)) from tblInsa group by buseo order by round(avg(basicpay)) desc) e)
where rNum=2;

select e.*, rowNum
from ( select buseo, count(*), round(avg(basicpay)) from tblInsa group by buseo order by round(avg(basicpay)) desc) e;

        
select buseo, count(*), round(avg(basicpay)) from tblInsa group by buseo order by round(avg(basicpay)) desc;


select * from tblInsa;
--10. tbltodo. 등록 후 가장 빠르게 완료한 할일을 순서대로 5개 가져오시오.
select
*
from tbltodo;

select 
title,
adddate,
completedate,
걸린일수,
rownum 

from(
select 
title,
adddate,
completedate,
round(completedate-adddate) as 걸린일수
from tbltodo
    where completedate is not null
        order by completedate-adddate asc)
        
        where rownum < 6;
        
        
--32. tblInsa. 남자 직원 중에서 급여를 3번째로 많이 받는 직원과 9번째로 많이 받는 직원의 급여 차액은 얼마?

select * from tblInsa;

select 
sum(case
    when rNum =3 then basicpay+sudang
end)-
sum(case
    when rNum =9 then basicpay+sudang
end) as "차액"
from (select e.*, rowNum as rNum
from (select * from tblInsa where substr(ssn,8,1) = 1  order by basicpay + sudang desc ) e);



select basicpay - (select basicpay from (select a.*, rownum as rnum from (select
                                                                                *
                                                                            from tblInsa
                                                                                where substr(ssn, 8, 1) = 1
                                                                                    order by basicpay desc) a)
                                                                                        where rnum = 9) from (select a.*, rownum as rnum from (select
                                                                                                                                                    *
                                                                                                                                                from tblInsa
                                                                                                                                                    where substr(ssn, 8, 1) = 1
                                                                                                                                                        order by basicpay desc) a)
                                                                                                                                                            where rnum = 3;
                                                                                                                                                            

--70. employees, departments. 
--커미션(commission_pct)을 가장 많이 받은 상위 4명의 부서명(department_name), 사원명 (first_name), 급여(salary), 커미션(commission_pct) 정보를 가져오시오. 
--결과는 커미션 을 많이 받는 순서로 가져오되 동일한 커미션에 대해서는 급여가 높은 사원을 먼저 정렬하시오.


