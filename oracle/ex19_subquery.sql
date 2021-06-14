--ex19_subquery.sql


/*
메인쿼리, Main Query
- 하나의 select(insert, update, delete)로만 구성된 쿼리

서브쿼리, Sub Query
- 하나의 문장에 2개 이상의 select를 추가해서 구성된 쿼리
- 하나의 쿼리안에 또다른 쿼리가 들어있는 형태
- 삽입 위치: select절, from절, where절, order by절 등..

- select + select x N
- insert + select x N
- update + select x N
- delete + select x N

*/

--tblCountry. 인구수가 가장 많은 나라의 인구수는?
SELECT MAX(population) FROM tblcountry;
SELECT NAME FROM tblcountry WHERE population = 120660;

SELECT NAME FROM tblcountry WHERE populatioN = MAX(population); -- ORA-00934: group function is not allowed here

SELECT NAME FROM tblcountry WHERE population = (SELECT MAX(population) FROM tblcountry);


--tblInsa. 급여가 가장 많은 사람의 이름?
SELECT MAX(basicpay) FROM tblinsa; --2650000
SELECT NAME FROM tblinsa WHERE basicpay = 2650000; --허경운

SELECT NAME FROM tblinsa WHERE basicpay = (SELECT MAX(basicpay) FROM tblinsa);


-- tblInsa. 평균 급여보다 많이 받는 직원들?
SELECT AVG(basicpay) FROM tblinsa; 
SELECT * FROM tblinsa WHERE basicpay > 1556526;

SELECT * FROM tblinsa WHERE basicpay > (SELECT AVG(basicpay) FROM tblinsa);


--tblInsa. '홍길동'과 같은 부서에 근무하는 사람들?
SELECT * FROM tblinsa WHERE buseo = (SELECT buseo FROM tblinsa WHERE NAME = '홍길동') and name <> '홍길동';


-- 서브쿼리의 용도
-- 1. 조건절 비교값으로 사용
--  a. 반환값이 1행 1열 > 단일값, 값 1개 > 스칼라 쿼리(1행 1열) > 연산자 사용
--  b. 반환값이 N행 1열 > 다중값, 값 N개 > in 사용(열거형 비교)
--  c. 반환값이 1행 N열 > 복합값, 값 N개 > 연산자 사용(N:N)
--  d. 반환값이 N행 N열 > b + c > b와 C의 방식을 혼합해서 사용


--1.a
select
    *
from tblInsa
    where basicpay = (select max(basicpay) from tblInsa);

--1.b
--급여가 260만원 이상 받는 사람들이 근무하는 부서의 명단?
select
    *
from tblInsa 
    --where buseo = (select buseo from tblInsa where basicpay >= 2600000); 
    where buseo in (select buseo from tblInsa where basicpay >= 2600000); 


--기획부 대리와 같은 지역에 사는 사람들
select city from tblInsa where buseo = '기획부' and jikwi = '대리';
select * from tblInsa where city in (select city from tblInsa where buseo = '기획부' and jikwi = '대리');

select 
    * 
from tblInsa
    where city in (select city from tblInsa where buseo = '기획부' and jikwi = '대리');


--1.c
-- '홍길동'이 사는 지역과 같은 지역에 살고, 같은 직위를 가지는 직원? 

select city, jikwi from tblInsa where name = '홍길동';

select * from tblInsa where city = '서울' and jikwi = '부장';

--2:2 -> N:N비교
select 
    *
from tblInsa
    where (city, jikwi) = (select city, jikwi from tblInsa where name = '홍길동');


--1.d
-- 급여를 2600000원 이상 받는 직원의 부서와 사는곳이 동일한 직원들?
select buseo, city from tblInsa where basicpay >= 2600000;

select * from tblInsa
    where (buseo, city) in (select buseo, city from tblInsa where basicpay >= 2600000);


-- 서브쿼리의 용도
-- 1. 조건절 비교값으로 사용
--  a. 반환값이 1행 1열 > 단일값, 값 1개 > 스칼라 쿼리(1행 1열) > 연산자 사용
--  b. 반환값이 N행 1열 > 다중값, 값 N개 > in 사용(열거형 비교)
--  c. 반환값이 1행 N열 > 복합값, 값 N개 > 연산자 사용(N:N)
--  d. 반환값이 N행 N열 > b + c > b와 C의 방식을 혼합해서 사용

--2. 컬럼리스트에서 사용 
-- a. 반환값이 1행 1열 > 스칼라 쿼리
--      1. 정적 쿼리 (모든 행에 동일한 값을 반환)
--      2. 상관 서브 쿼리 (서브 쿼리의 값과 바깥쪽 메인 쿼리의 값을 연계시켜서 값을 변환)**********************


select 
  name,
  basicpay,
  avg(basicpay)
 from tblInsa;



select 
  name,
  basicpay,
  (select 100 from dual),
  100,
  (select round(avg(basicpay)) from tblInsa)
 from tblInsa;



select 
    name,
    buseo,
    (select round(avg(basicpay)) from tblInsa) as 평균급여,
    (select jikwi from tblInsa where name = '홍길동')
from tblInsa;



select * from tblMen;
select * from tblWomen;

--남자 이름 , 남자키, 여자이름 ,여자키 -> 홍길동
select 
    name as 남자이름,
    height as 남자키,
    couple as 여자이름,
   -- 여자테이블의 height
    (select height from tblWomen where name ='장도연') as 여자키
    
from tblMen
    where name = '홍길동';
    
    
    
--남자 이름 , 남자키, 여자이름 ,여자키 -> 모든커플
select 
    name as 남자이름,
    height as 남자키,
    couple as 여자이름,
   -- 여자테이블의 height
    (select height from tblWomen where name = tblmen.couple) as 여자키
    
from tblMen
    where couple is not null; --커플
    
    
    


select * from employees; -- 직원

select * from departments; -- 부서 

-- 직원의 이름과 부서명을 가져오시오
select
    first_name||' '|| last_name as name,
    department_id ,
    (select department_name from departments where department_id = employees.department_id ) as department
from employees;