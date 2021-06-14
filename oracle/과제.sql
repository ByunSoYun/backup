--1. traffic_accident. 각 교통 수단 별(지하철, 철도, 항공기, 선박, 자동차) 발생한 총 교통 사고 발생 수, 총 사망자 수, 사건 당 평균 사망자 수를 가져오시오.
select
    trans_type as 교통수단,
    sum(total_acct_num) as "총 교통 사고 발생 수",
    sum(death_person_num) as "총 사망자 수",
    round(avg(death_person_num)) as "평균 사망자 수"
from traffic_accident
    group by trans_type;


select
*
from traffic_accident;

--2. tblZoo. 종류(family)별 평균 다리의 갯수를 가져오시오.
select 
    family as 종류,
    round(avg(leg)) as 평균다리갯수
from tblZoo
    group by family;



select
 *
from tblZoo;

--3. tblZoo. 체온이 변온인 종류 중 아가미 호흡과 폐 호흡을 하는 종들의 갯수를 가져오시오.

select
    breath,
    count(*)
from tblZoo
      where  thermo = 'variable'
    group by breath;
 

--4. tblZoo. 사이즈와 종류별로 그룹을 나누고 각 그룹의 갯수를 가져오시오.

select
    sizeof,
    count(*)
from tblZoo
    group by sizeof;

--6. tblTodo. 완료한 일의 갯수와 완료하지 않은 일의 갯수를 가져오시오.

select
    case 
        when completedate is null then '미완료'   
        when completedate is not null then '완료' 
    end as 완료여부,
    count(*)
 from tblTodo
    group by completedate;

select
 *
from tblTodo;

--7. tblAddressBook. 서울에 사는 10대, 20대, 30대, 40대 인원수를 가져오시오.


SELECT 
    substr(age,1,1) || '0대' AS 연령대,
    COUNT(*) AS 인원수
FROM tbladdressbook
     WHERE substr(address, 1, instr(address, ' ') -1) = '서울특별시'
        GROUP BY substr(age,1,1)
            ORDER BY substr(age,1,1);

--8. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.
select * from tblAddressBook;

select 
*
from tblAddressBook
where substr(address,1,2) = hometown;

--9. tblAddressBook. 역삼로에 사는 사람 중 gmail을 사용하는 사람들을 가져오시오.
select
*
from tblAddressBook
where instr(address,'역삼로') > 1 and  instr(email,'gmail')>1;

--11. tblAddressBook. 전화번호에 '123'이 들어간 사람 중 여학생만을 가져오시오.
select 
*
from tblAddressBook
where instr(tel,'123') > 1 and gender = 'f';

--12. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.

select 
email
from tblAddressBook
group by email
having count(*)>1;

--15. tblAddressBook. 성씨별 인원수가 100명 이상 되는 성씨들을 가져오시오.
select 
substr(name,1,1)
from tblAddressBook
group by substr(name,1,1)
having count(substr(name,1,1)) >= 100;


select 
*
from tblAddressBook
--17. tblAddressBook. 이메일이 스네이크 명명법으로 만들어진 사람들 중에서 여자이며, 20대이며, 키가 150~160cm 사이며, 고향이 서울 또는 인천인 사람들만 가져오시오.


--18. tblAddressBook. gmail.com을 사용하는 사람들의 성별 > 세대별(10,20,30,40대) 인원수를 가져오시오.


--53. employees. 총 사원 수 및 2003, 2004, 2005, 2006 년도 별 고용된 사원들의 총 수를 가져오시오.


--55. employees. 직업이 'AD_PRESS' 인 사람은 A 등급을, 'ST_MAN' 인 사람은 B 등급을, 'IT_PROG' 인 사람은 C 등급을, 'SA_REP' 인 사람은 D 등급을, 'ST_CLERK' 인 사람은 E 등급을 기타는 0 을 부여하여 가져오시오.





