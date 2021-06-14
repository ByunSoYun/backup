-- 029.sql

--12 기획부 직원들 가져오시오

select * from tblInsa;

select name , buseo from tblInsa where buseo = '기획부';

--13.
select name, jikwi, tel from tblInsa where jikwi = '부장' and city = '서울'; 

--14 
 select name from tblInsa where basicpay + sudang > 1500000 and city = '서울';
 
 --15
 
 select name, sudang, jikwi from tblInsa where sudang <150000 and jikwi in('사원','대리');
 
 --16
 select name, basicpay * 12 , jikwi from tblInsa where basicpay *12 >20000000  and jikwi in('과장','부장') and city = '서울';
 
 --17
 select * from tblCountry;
 
 select name from tblCountry where name like '_국';
 select name from tblCountry where name like '%국'; -- 추가조건
 
 
 --18
 
 select * from employees;
 
 select first_name||last_name,phone_number from employees where phone_number like '515%';
 
 --19
  select first_name||last_name,Job_id from employees where Job_id like 'SA%';
  
  --20
    select first_name||last_name, first_name 
    from employees 
    where Job_id like  '%de%' or  Job_id like  '%DE%' or  Job_id like  '%De%' or  Job_id like  '%dE%' ;

--21.
select * from tblInsa;

select name,ssn from tblInsa where ssn like '_______1%';

--22
select name,ssn from tblInsa where ssn like '_______2%';

--23
select name,ssn from tblInsa where ssn like '__07%' or ssn like '__08%' or ssn like '__09%';


--24
select name , city from tblInsa where city in ('서울','인천') and name like '김%';

--25
select name, jikwi, tel, buseo from tblInsa where buseo in ('영업부','총무부','개발부') and jikwi in ('사원','대리') and tel like '010%';

--26
select name , city, ibsadate from tblInsa where city in ('인천','경기','서울') and ibsadate between '2008-01-01' and '2010-12-31';

--27
select * from employees;
select first_name|| last_name , department_ID  from employees where department_ID is null;

--28 
select distinct job_id from employees;

--29
select distinct department_ID from employees where  hire_date between '2002-01-01' and '2004-12-31';


--30 
select  manager_ID from employees where salary >5000;

--31
select *from tblInsa;

select distinct  jikwi  from tblInsa where ssn like '_______1%' and ssn like '8%';

--32 
select distinct city from tblInsa where sudang >200000;

--33 
select distinct buseo from tblInsa where tel is null;