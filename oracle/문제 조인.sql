-- 33. employees, departments. 사원들의 이름, 부서번호, 부서명을 가져오시오.

select
    e.first_name || e.last_name as 사원명,
    e.department_id as 부서번호 ,
    d.department_name as 부서명 
    from employees e
    inner join departments d
        on e.department_id = d.department_ID;
        
        
select * from employees;
select * from departments;
        
-- 34. employees, jobs. 사원들의 정보와 직위명을 가져오시오.

select 
    e.*,
    j.job_title
from employees e
    inner join jobs j
        on e.job_id = j.job_id;
        
    
select * from employees;
select * from jobs;

-- 35. employees, jobs. 직무(job_id)별 최고급여(max_salary) 받는 사원 정보를 가져오시오.

select 
e.*,
j.max_salary
from employees e
    inner join jobs j
        on j.max_salary = e.salary and j.job_id = e.job_id;


select * from employees;
select * from jobs;

-- 36. departments, locations. 모든 부서와 각 부서가 위치하고 있는 도시의 이름을 가져오시오.



select 
    d.department_name,
    l.city
from departments d
    left outer join locations l
        on d.location_id = l.location_id;
    


select * from departments;
select * from locations;

-- 37. locations, countries. location_id 가 2900인 도시가 속한 국가 이름을 가져오시오.


select 
    country_name
from countries c
        where c.country_id = (select country_id from locations where location_id = 2900);

select country_id from locations where location_id = 2900;

select * from locations;

select * from countries;

--쌤답
select l.location_id, c.country_name from HR.locations l inner join HR.countries c
on l.country_id = c.country_id
where l.location_id=2900;

-- 38. employees. 급여를 12000 이상 받는 사원과 같은 부서에서 근무하는 사원들의 이름, 급여, 부서번호를 가져오시오.

select first_name||' '||last_name, salary, department_Id from employees where employees.department_Id in (select  distinct department_id from employees where salary >=12000 );
select  distinct department_id from employees where salary >=12000 

-- 39. employees, departments. locations.  'Seattle'에서(LOC) 근무하는 사원의 이름, 직위, 부서번호, 부서이름을 가져오시오.

select 
    e.first_name || ' '|| last_name, e.job_id, e.department_id , d.department_name 
    from departments d
        inner join locations l
                on d.location_id = l.location_id
            inner join employees e
                on e.department_id = d.department_id
                    where city = 'Seattle';


select location_id from locations where city = 'Seattle'

select * from employees
select * from locations
select * from departments
-- 40. employees, departments. first_name이 'Jonathon'인 직원과 같은 부서에 근무하는 직원들 정보를 가져오시오.

select * from employees where department_id = 
(select department_id from employees where first_name = 'Jonathon')

-- 41. employees, departments. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을 출력하는데 월급이 3000이상인 사원을 가져오시오.

select 
first_name||' '||last_name,
department_id ,localhost.hr

salary 
from employees 
where salary > 3000;

-- 42. employees, departments. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름, 월급을 가져오시오.
select 
    e.department_id ,
    d.department_name,
    e.first_name||' '||last_name,
    e.salary 
from employees e
    inner join departments d
        on e.department_id = d.department_id 
            where e.department_id = 10
-- 43. employees, departments. 모든 부서의 정보를 가져오되 부서장이 있는 부서는 부서장의 정보도 같이 가져오시오.
select 
d.*,
e.*
from departments d
    left outer join employees e
        on d.manager_id = e.manager_id 
    
-- 44. departments, job_history. 퇴사한 사원의 입사일, 퇴사일, 근무했던 부서 이름을 가져오시오.

select 
j.start_date,
j.end_date,
d.department_name
from departments d
    inner join job_history j
        on d.department_id = j.department_id


select 
*
from job_history
select 
*
from departments

-- 45. employees. 사원번호와 사원이름, 그리고 그 사원을 관리하는 
--관리자의 사원번호와 사원이름을 출력하되 각각의 컬럼명을 '사원번호', '사원이름', '관리자번호', '관리자이름'으로 하여 가져오시오.

select 
s.employee_id as 사원번호
s.first_name || ' ' || s.last_name as 사원이름,
s.employee_id as 관리자 번호,
s1.first_name || ' ' || s1.last_name as 관리자이름
from employees s -- 사원 
   left outer join employees s1 -- 사원관리자 
        on s.manager_id = s.employee_id;
    
select 
s.employee_id as "사원번호",
s.first_name||' '||s.last_name as "사원이름",
s.manager_id as "관리자번호",
s1.first_name||' '||s1.last_name
from employees s
    left outer join employees s1
        on s.manager_id = s1.employee_id;

select
    s1.name as "직원명",
    s1.deparment as "소속부서",
    s2.name as "상사명"
from tblSelf s1 --직원(부하)
    inner join tblSelf s2 --상사
        on s1.super = s2.seq; --***** 중요!!!!!
        
select * from tblSelf

select 
*
from employees

-- 46. employees, jobs. 직책(Job Title)이 Sales Manager인 사원들의 입사년도와 입사년도(hire_date)별 평균 급여를 가져오시오.
--년도를 기준으로 오름차순 정렬.


select 
hire_date,
avg(salary)
from employees e 
    inner join jobs j 
        on j.job_id = e.job_id
        where j.job_title = 'Sales Manager'
        group by e.hire_date
        order by e.hire_date asc;
    --답

select 
*
from employees
select 
*
from jobs
-- 47. employees, departments. locations. 
--각 도시(city)에 있는 모든 부서 사원들의 평균급여가 가장 낮은 도시부터 도시명(city)과 평균연봉,
--해당 도시의 사원수를 가져오시오.
--단, 도시에 근 무하는 사원이 10명 이상인 곳은 제외하고 가져오시오.

select
city,
count(*),
round(avg(e.salary))
from employees e
    inner join departments d
        on e.department_id = d.department_id
            inner join locations l
               on l.location_id = d.location_id 
                    group by l.city 
                        having count(*)<10  
                           order by round(avg(e.salary)) asc;

select * from employees
    


-- 48. employees, jobs, job_history. ‘Public  Accountant’의 직책(job_title)으로 
--과거에 근무한 적이 있는 모든 사원의 사번과 이름을 가져오시오. 
--현재 ‘Public Accountant’의 직책(job_title)으로 근무하는 사원은 고려 하지 말것
select
e.first_name || ' '|| e.last_name,
e.employee_id
from employees e
    inner join job_history h
        on e.employee_id = h.employee_id 
            inner join jobs j
                on h.job_id = j.job_id
                    where j.job_title = 'Public Accountant';
                
      

select *from jobs
select * from employees
select * from departments
select * from locations
select * from job_history
-- 49. employees, departments, locations. 커미션을 받는 모든 사람들의 first_name, last_name, 부서명, 지역 id, 도시명을 가져오시오.
select 
e.commission_pct,
e.first_name,
e.last_name,
d.department_name,
l.location_id,
l.city
from employees e
    left outer join departments d
        on e.department_id = d.department_id
            left outer join locations l
                on l.location_id = d.location_id
                    where e.commission_pct is not null;


select * from employees
-- 50. employees. 자신의 매니저보다 먼저 고용된 사원들의 first_name, last_name, 고용일을 가져오시오.
    select 
    e.first_name,
    e.last_name,
    e.hire_date 
    from employees e
        inner join employees e1
           on e.manager_id = e1.employee_id
                where e.hire_date < e1.hire_date
                
    select e.first_name, e.last_name, e.hire_date
from hr.employees e left outer join hr.employees e2
on e.manager_id = e2.employee_id
where e.hire_date < e2.hire_date
order by e.employee_id;
    
      select * from employees
      
select hire_date from employees order by hire_date asc;
-- 51. employees. 매니저로 근무하는 사원이 총 몇명인가?
select
count(*) 
from employees 
    where employee_id in (select distinct (manager_id) from employees where manager_id is not null);
    
-- 52. employees. 자신의 매니저보다 연봉(salary)를 많이 받는 사원들의 성(last_name)과 연봉(salary)를 가져오시오.
select 
e.last_name ,
e.salary 
from employees e 
    inner join employees e1 
       on e.manager_id = e1.employee_id 
            where e.salary > e1.salary
            
             select * from employees
-- 53. employees. 총 사원 수 및 2003, 2004, 2005, 2006 년도 별 고용된 사원들의 총 수를 가져오시오.
select
count(*) as 총사원수 ,
count(case  
        when substr(hire_date,1,2) = 03 then 1
        end)  as "2003고용사원수",
count(case  
        when substr(hire_date,1,2) = 04 then 1
        end)  as "2004고용사원수",
count(case  
        when substr(hire_date,1,2) = 05 then 1
        end)  as "2005고용사원수",
count(case  
        when substr (hire_date,1,2) = 06 then 1
        end)  as "2006고용사원수"

from employees;
    
-- 54. employees, departments. 2007년에 입사(hire_date)한 사원들의 사번(employee_id), 이름(first_name), 성(last_name), 부서명(department_name)을 가져오시오. 
--단, 부서에 배치되지 않은 사원은 'Not Assigned'로 가져오시오.
select 
e.employee_id,
e.first_name,
e.last_name,
case
    when e.department_id is null then 'Not Assigned'
    when e.department_id is not null then d.department_name
end as "부서명",
e.hire_date
from employees e
    left outer join departments d
        on d.department_id = e.department_id 
           where substr(e.hire_date ,1,2) =07;
           
           
           
             select * from employees
-- 55. employees. 직업이 'AD_PRESS' 인 사람은 A 등급을, 'ST_MAN' 인 사람은 B 등급을,
--'IT_PROG' 인 사람은 C 등급을, 'SA_REP' 인 사람은 D 등급을, 'ST_CLERK' 인 사람은 E 등급을 기타는 0 을 부여하여 가져오시오.

select 
job_id,
case    when job_id = 'AD_PRES' then 'A' 
        when job_id = 'ST_MAN' then 'B' 
        when job_id = 'IT_PROG' then 'C' 
        when job_id = 'SA_REP' then 'D'
        when job_id = 'ST_CLERK' then 'E'
        else '0'
end as "등급"
from employees;
        


from employees 

-- 56. employees, jobs. 업무명(job_title)이 ‘Sales Representative’인 사원 중에서 
--연봉(salary)이 9,000이상, 10,000 이하인 사원들의 이름(first_name), 성(last_name)과 연봉(salary)를 가져오시오.
select 
j.job_title,
e.first_name ,
e.last_name,
e.salary
from employees e
    inner join jobs j 
      on  j.job_id = e.job_id 
            where j.job_title = 'Sales Representative' and e.salary between 9000 and 10000;
            
            
select * from employees
select * from departments
-- 57. employees, departments. 부서별로 가장 적은 급여를 받고 있는 사원의 이름, 부서이름, 급여를 가져오시오. 이름은 last_name만 가져오고,
--부서이름으로 오름차순 정렬하고, 부서가 같은 경우 이름을 기준 으로 오름차순 정렬하여 가져오시오. 
select 
e.last_name,
d.department_name,
e.salary 
from  employees e
    left outer join departments d
        on e.department_id = d.department_id 
        where (e.department_id,e.salary ) in 
                 (select e.department_id,min(e.salary) from employees e 
                        left outer join departments d 
                                on e.department_id = d.department_id
                    group by e.department_id )
        order by d.department_name,e.last_name;
        
-- 58. employees, departments, locations. 사원의 부서가 속한 도시(city)가 ‘Seattle’인 사원의 이름, 해당 사원의 매니저 이름, 
--사원 의 부서이름을 가져오시오. 이때 사원의 매니저가 없을 경우 ‘없음’이라고 가져오시오. 
--이름은 last_name만 가져오고, 사원의 이름을 오름차순으로 정렬하시오.
select 
e.last_name,
case 
    when e.manager_id is not null then m.last_name
    when e.manager_id is null then '없음'
end as "매니저 이름",
d.department_name
from employees e
    left outer join employees m 
        on e.manager_id = m.employee_id 
            left outer join departments d
                on d.department_id =e.department_id 
                    left outer join locations l
                        on l.location_id = d.location_id
                            where l.city = 'Seattle'
                                order by e.last_name;



-- 59. employees, jobs. 각 업무(job) 별로 연봉(salary)의 총합을 구하고자 한다. 
--연봉 총합이 가장 높은 업무부터 업무명(job_title)과 연봉 총합을 가져오시오. 단 연봉총합이 30,000보다 큰 업무만 가져오시오.
select 
j.job_id,
sum(e.salary)
from employees e
    left outer join jobs j
      on j.job_id = e.job_id 
            group by j.job_id
                having sum(e.salary) >30000
                     order by sum(e.salary) desc;   
    
    
select * from jobs

-- 60. employees, departments, locations, jobs. 
--각 사원(employee)에 대해서 사번(employee_id), 이름(first_name), 업무명(job_title), 부서 명(department_name)을 가져오시오. 
--단 도시명(city)이 ‘Seattle’인 지역(location)의 부서 (department)에 근무하는 사원을 사원번호 오름차순으로 가져오시오.


select 
e.employee_id,
e.first_name,
j.job_title,
d.department_name
from employees e
    left outer join jobs j
       on e.job_id = j.job_id 
       left outer join departments d 
          on  e.department_id = d.department_id 
                left outer join locations l
                  on  d.location_id = l.location_id
                    where l.city = 'Seattle'
                    order by e.employee_id;
            





-- 61. employees. 2001~20003년사이에 입사한 사원의 이름(first_name), 입사일(hire_date), 관리자사번 (employee_id), 관리자 이름(fist_name)을 가져오시오. 
--단, 관리자가 없는 사원정보도 결과에 포함시켜 가져오시오.
select 
e.first_name ,
e.hire_date,
m.employee_id,
m.first_name 
from employees e
    left outer join employees m
        on e.manager_id = m.employee_id
            where substr(e.hire_date,1,2) between 01 and 03;
select * from employees

-- 62. employees, departments. ‘Sales’ 부서에 속한 사원의 이름(first_name), 급여(salary), 부서이름(department_name)을 가져오시오.
--단, 급여는 100번 부서의 평균보다 적게 받는 사원 정보만 가져오시오.


select 
e.first_name ,
e.salary,
d.department_name 
from employees e 
    left outer join departments d
        on d.department_id = e.department_id 
            where e.salary < (select avg(salary) from employees where department_id =100) and d.department_name = 'Sales'


-- 63. employees. last_name 에 'u' 가 포함되는 사원들과 동일 부서에 근무하는 사원들의 사번 및 last_name을 가져오시오.
select 
employee_id,
last_name
from employees
where department_id  in (select distinct department_id from employees where instr(last_name,'u') >0)
-- 64. employees, departments. 부서별 사원들의 최대, 최소, 평균급여를 조회하되, 평균급여가 ‘IT’ 부서의 평균급여보다 많고, 
-- ‘Sales’ 부서의 평균보다 적은 부서 정보만 가져오시오. 
select 
department_id,
max(salary),
min(salary),
round(avg(salary))
from employees 
         group by department_id
            having avg(salary) > (select avg(e.salary) from employees e left outer join departments d on e.department_id = d.department_id where d.department_name = 'IT')
                and  avg(salary) < ( select round(avg(e.salary)) from employees e left outer join departments d on e.department_id = d.department_id where d.department_name = 'Sales'
)


select department_id, max(salary), min(salary), round(avg(salary),1)
from hr.employees
group by department_id
having round(avg(salary),1) > (select round(avg(salary),1) from hr.employees e left outer join hr.departments d on e.department_id = d.department_id where d.department_name='IT') 
        and
        round(avg(salary),1) < (select round(avg(salary),1) from hr.employees e left outer join hr.departments d on e.department_id = d.department_id where d.department_name='Sales')
        
-- 65. employees, departments. 각 부서별로 사원이 한명만 있는 부서만 가져오시오.
--단, 사원이 없는 부서에 대해서는 ‘신생부서’라는 문자열을 가져오고,  결과는 부서명이 내림차순으로 정렬되게 하시오.
select
case  when count(e.employee_id) =1 then d.department_name
    when count(e.employee_id)=0 then d.department_name||' 신생부서'
end,
count(e.employee_id)
from employees e
    right outer join departments d
        on d.department_id = e.department_id 
            group by department_name
                having count(e.employee_id)=1 or count(e.employee_id)=0;
                  --  order by d.department_name desc
                
                
                
   
    select count(*) from depar
    select department_id, count(employee_id) from employees group by department_id
    
    
-- 66. employees, departments. 부서별 입사월별 사원수를 가져오시오. 단, 사원수가 5명 이상인 부서만 가져오고,  결과는 부서이름 순으로 하시오.
select 
department_name,
substr(hire_date,4,2),
count(e.employee_id)
from departments d
    left outer join employees e
        on d.department_id = e.department_id
        group by department_name,substr(hire_date,4,2)
           having count(e.employee_id) > 4
            order by d.department_name
           
  
-- 67. employees, departments, locations, countries. 국가(country_name) 별 도시(city)별 사원수를 가져오시오.  
--부서정보가 없는 사원은 국가명과 도시명 대신에 ‘부서없음’을 넣어서 가져오시오.
select
case
    when c.country_name is null then '부서없음'
    else c.country_name
end as "국가명",
case
    when l.city is null then '부서없음'
    else l.city
end as "도시명",
count(e.employee_id)
from employees e
    left outer join departments d
        on e.department_id  = d.department_id 
            left outer join locations l
                on d.location_id = l.location_id 
                   left outer join countries c
                        on l.country_id = c.country_id
                            group by c.country_name, l.city
                            
                         select 
case
    when c.country_name is null then '부서없음'
    else c.country_name
end as "국가명",
case
    when l.city is null then '부서없음'
    else l.city
end as "도시명",
count(e.employee_id)
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id
left outer join HR.locations l
on d.location_id = l.location_id 
left outer join hr.countries c
on l.country_id = c.country_id
group by c.country_name,l.city;   
        
        select*from countries ;
        select*from locations ;
        select*from departments ;
        select*from employees ;


-- 68. employees, departments. 각 부서별 최대 급여자의 아이디(employee_id), 이름(first_name), 급여(salary)를 가져오시오.
select 
e.employee_id,
e.first_name ,
e.salary
from employees e 
    left outer join departments d
        on d.department_id = e.department_id 
            group by e.department_id
                having e.


select *
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id
-- 69. employees. 커미션(commission_pct)별 사원수를 가져오시오. 커미션은 0.2, 0.25는 모두 0.2로, 0.3, 0.35는 0.3 형태로 바꾸시오. 단, 커미션 정보가 없는 사원들도 있는 데 커미션이 없는 사원 그룹은 ‘커미션 없음’으로 바꿔 가져오시오.

select 
case
    
    when '0'||substr(commission_pct,1,2) ='0' then '커미션 없음'
    else '0'||substr(commission_pct,1,2)
end,
count(*) 
from hr.employees
group by substr(commission_pct,1,2);