-- ex03_selet.sql


/*


select 문
 - DML, DQL
 - 데이터베이스로부터 원하는 데이터를 가져오는 명령어(읽기)
 
 select 구문 
 
[WITH <Sub Query>]
SELECT column_list - with 절
FROM table_name - selct 절
[WHERE search_condition] - from절
[GROUP BY group_by_expression]
[HAVING serach_condition]
[ORDER BY order_expression [ASC|DESC]];  --하나의 문장 

***** select를 구성하는 모든 절들은 실행 순서가 있다. (불변) -> 무조건 암기 (이해)
1. FROM 절 
2. SELECT 절

SELECT 컬럼리스트 -- 데이터를 가져올 컬럼을 지정한다. (지정된 컬럼만 가져온다.) - 원하는 열을 가져옴 
FROM 테이블명; -- 데이터를 가져올 테이블을 지정한다.(데이터소스 지정) 


SELECT column_list 
FROM table_name
*/

--hr -> 샘플(테이블 + 데이터) 제공 
-- 현재 계정이 소유하고 있는 테이블 목록 가져오기 
select * from tabs;


select * from employees;

-- select 문 작성 -> 실행 -> 서버전달 -> 처리 -> 결과값반환 ->클라이언트 반환 -> 결과값 -> ResultSet


-- full select
select *    -- 2. 어떤 컬럼 명을 가져올거냐? -> *(wildcard) 모든 컬럼 
from employees; -- 1. employees테이블로부터 데이터를 가져오겠다.

select   first_name
from employees; 

select   first_name, last_name
from employees; 

--ORA-00942: table or view does not exist
select *
from employee;

--ORA-00904: "FIRSTNAME": invalid identifier
select firstname
from employees;
