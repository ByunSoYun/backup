--ex11_datetime_function.sql

/*

날짜시간 함수 

sysdate 
- 현재 시스템의 시각을 반환 
- date sysdate 
- 자바의 Calendar.getInstance() ,new Date()


*/

select sysdate from dual;


/*

날짜연산 
- +연산, -연산
1. 시각 - 시각 = 시간 (단위 : 일)
2. 시각 + 시간 = 시각 
3. 시각 - 시간 = 시각 


*/

-- 홍길동 08/10/11 21/05/17  4601(일)


-- 1. 시각 - 시각 = 시간 
select 
    name,
    ibsadate as 입사일,
    sysdate as 현재,
    round(sysdate - ibsadate) as "근무기간(일)" 
    round((sysdate - ibsadate) * 24) as "근무기간(시)" 
    round((sysdate - ibsadate) * 24 * 60) as "근무기간(분)" 
    round((sysdate - ibsadate) * 24 * 60 * 60 ) as "근무기간(초)" 
    round((sysdate - ibsadate)/365) as "근무기간(년)" 
from tblInsa;

--2. 시각 + 시간 = 시각

select 
    sysdate,
    sysdate + 100, 
    sysdate - 100,
    sysdate + (2/24) --2시간 뒤 ?
from dual;


/*
last day()
- 해당 시각이 포함된 달의 마지막 날짜 
- date last_day(date)
*/

select 
    sysdate, -- 21/05/17
    last_day(sysdate) --21/05/31
from dual;


/*
monthes_between()
- 시각 - 시각 = 시간(단위:일)
- 시각 - 시각 = 시간(단위:월) ** ( 월단위 이상일때 사용) 
- number months_between(date,date)
*/

select 
    name,
    ibsadae as "입사일",
    sysdate - ibsadate as "근무시간(일)"
    (sysdate - ibsadate)/30.4 as "근무시간(개월)" -- X
    months_between(sysdate , ibsadate) as "근무시간(개월)"  - ******
    (sysdate - ibsadate) / 365 as "근무시간(년)"  -- X
    months_between(sysdate , ibsadate) /12 as "근무시간(개월)"  - ******
from tblInsa;

/*
add_months()
- number add_months(date,number)
*/

select
    sysdate,
    sysdate + 31,
    add_months(sysdate,1),
    sysdate + 100,
    add_months(sysdate,100)
from dual;






/*
시각 - 시각 = 일 
시각 - 시각 = 월(년 (months_between)

시각 + 시간(일) = 시각 
시각 - 시간(일) = 시각 
시각 + 시간(월) = 시각 -> add_months()
시각 - 시간(월) = 시각 -> add_months()
*/


--칼럼 리스트에서 사용 
-- 조건절에서 사용 
-- 정렬에서 사용 

select 
    name,
    ibsadate,
    ceil(months_between(sysdate, ibsadate)/12) as "근무년차"
from tblInsa
    where MONTHS_BETWEEN(SYSDATE,ibsadate) < (12*10)--10년 ;
