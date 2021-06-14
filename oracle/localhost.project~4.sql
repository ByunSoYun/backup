
-- 강의실에서 현재 진행되고있는 상태를 가져오는 프로시저

create or replace procedure procClassroomSub(
    pnum tblclassroom.classroomSeq%type
)
is
    cursor vcursor is 
    select 
    c.name,
    tc.name ,
    oc.beginDate ,
    oc.endDate,
    oc.registerCount,
    ts.name,
    t.name 
    from tblClassroom c
        inner join tblOpenCourse oc
            on c.classroomSeq = oc.classroomSeq
                inner join tblTotalCourse tc
                    on tc.totalCourseSeq = oc.totalCourseSeq 
                        inner join tblOpenSubject os
                            on os.openCourseSeq = oc.openCourseSeq
                                inner join tblTotalSubject ts
                                    on ts.totalSubjectSeq = os.totalSubjectSeq
                                        inner join tblTeacher t
                                            on t.teacherSeq = oc.teacherSeq
                                                 where c.classroomseq = pnum
                                                 and 
                                                 sysdate between oc.begindate and oc.enddate 
                                                 and 
                                                 sysdate between os.begindate and os.enddate;
   
   vclassname tblClassroom.name%type;
   vcoursename tblTotalCourse.name%type;
   vcoursebegin tblOpenCourse.beginDate%type;
   vcourseend tblOpenCourse.endDate%type;
   vregisterC tblOpenCourse.registerCount%type;
   vsubjectname tblTotalSubject.name%type;
   vteachername tblTeacher.name%type;
    
begin
        
        open vcursor;
            
            loop
            
                fetch vcursor into vclassname, vcoursename, vcoursebegin, vcourseend, vregisterC, vsubjectname,vteachername;
                exit when vcursor%notfound;
                
                dbms_output.put_line('강의실이름: ' || vclassname ||'    과정이름: '|| vcoursename || '         과정등록교육생수: ' || vregisterC||'명         과목명: ' ||vsubjectname||'       교사명:'||vteachername);
            
            end loop;
            
        close vcursor;
        
end procClassroomSub;



begin
    procClassroomSub(3);
end;






-- 해당교재의 정보를 가져오는 프로시저 

create or replace procedure procBookinform(
        pname tblAllbook.name%type
)
is 
    cursor vcursor is 
    select
    ab.name,
    ab.price,
    ab.publisher,
    ab.writer,
    ts.name,
    tc.name
    from tblAllBook ab
        inner join tblUsedBook ub
            on ab.allBookSeq = ub.allBookSeq
                inner join tblTotalSubject ts
                    on ts.totalSubjectSeq = ub.totalSubjectSeq
                        inner join tblOpenSubject os
                            on os.totalSubjectSeq = ts.totalSubjectSeq
                                inner join tblOpenCourse oc
                                    on oc.openCourseSeq = os.openCourseSeq
                                        inner join tblTotalCourse tc
                                            on tc.totalCourseSeq = oc.totalCourseSeq
                                                where ab.name = pname;
    
    vbookname tblAllBook.name%type;
    vbookprice tblAllBook.price%type;
    vbookpublisher tblAllBook.publisher%type;
    vbookwriter tblAllBook.writer%type;
    vsubname tblTotalSubject.name%type;
    vcoursename tblTotalCourse.name%type;



begin 
open vcursor;
            
            loop
            
                fetch vcursor into vbookname, vbookprice, vbookpublisher, vbookwriter, vsubname, vcoursename;
                exit when vcursor%notfound;
                
                dbms_output.put_line('교재 이름: ' || vbookname ||'    교재 가격: '|| vbookprice || '         교재 출판사: ' || vbookpublisher||'         교재저자: ' ||vbookwriter||'       해당교재과정명'||vcoursename||'                 해당교재과목명:'||vsubname);
            
            end loop;
            
        close vcursor;
        
end procBookinform;

begin
    procBookinform('Do it! 자바 프로그래밍 입문');
end;



-- 해당 지역의 취업현황 보기 

create or replace procedure procEmployee(
        parea tblEmployment.area%type        
)
is
    cursor vcursor is 
select
    substr(st.name, 1,1) || 'OO' as "교육생 이름",            --교육생 이름
    em.companyname as "회사 이름",       --회사 이름
    em.annualincome as "연봉",          --연봉
    em.area as "근무지역"                --근무지역
from tblOpenCourse oc
    inner join tblTotalCourse tc
        on oc.totalCourseSeq = tc.totalCourseSeq
            inner join tblEnrollment en
                on en.opencourseseq = oc.opencourseseq
                inner join tblStudent st
                    on en.studentSeq = st.studentSeq
                        inner join tblCompleteStudent cs
                            on en.enrollmentSeq = cs.enrollmentSeq
                                inner join tblEmployment em
                                    on em.completeStudentSeq = cs.completeStudentSeq
                                        where em.area = parea;
    vname tblstudent.name%type;
    vcompanpany tblEmployment.companyname%type;
    vanualIncome tblemployment.annualincome%TYPE;
    varea tblemployment.area%type;
 
 
begin 
open vcursor;
            
            loop
            
                fetch vcursor into vname, vcompanpany, vanualIncome, varea;
                exit when vcursor%notfound;
                
                dbms_output.put_line('취업생명: ' || substr(vname, 1,1) || 'OO'  ||'    회사 이름: '|| vcompanpany || '         연봉: ' || vanualIncome||'         근무지역: ' ||varea);
            
            end loop;
            
        close vcursor;
        
end procEmployee;  



begin
    procEmployee('서울');
end;

commit;
 
 
 -- [과목별 배점 정보를 출력하는 프로시저]
create or replace procedure procDistribution (
    pnum tblstudent.studentseq%type
)
is
    cursor vcursor is select * from vwDistribution where 수강번호 = pnum;
                            
    vrow vwDistribution%rowtype;

begin

    open vcursor;
        
        loop
        
            fetch vcursor into vrow;
            exit when vcursor%notfound;
            
            dbms_output.put_line('배점 정보: ' || vrow.수강생이름 || ' || ' || vrow.과목이름 || ' || ' || vrow.필기배점 || ' || ' || vrow.실기배점 || ' || ' || vrow.출결배점);
            
        end loop;
    
    close vcursor;

end procDistribution;
/

begin
    procDistribution(5);
end;


commit;

-- [과목별 배점 정보를 출력하는 뷰]
create or replace view vwDistribution
as
select
    os.opensubjectseq as 수강번호,
    st.name as 수강생이름,
    ts.name as 과목이름,
    tt.handwritingdistribution as 필기배점,
    tt.practicedistribution as 실기배점,
    tt.attendanceDistribution as 출결배점       
from tblopencourse oc
    inner join tblenrollment en
        on oc.opencourseseq = en.opencourseseq
    inner join tblstudent st
        on en.studentseq = st.studentseq
    inner join tblopensubject os
        on oc.opencourseseq = os.opencourseseq
    inner join tbltotalsubject ts
        on os.totalsubjectseq = ts.totalsubjectseq
    inner join tbltest tt
        on os.opensubjectseq = tt.opensubjectseq;   
        
        
        
        
        

CREATE TABLE AttendanceCheck (
    attendancecheckSeq number NOT NULL,             -- 교사고유번호(PK)
    name varchar2(15) NOT NULL,             -- 교사명
    ssn varchar2(15) NOT NULL,              -- 주민번호(뒷자리)
    phoneNumber varchar2(15) NOT NULL,      -- 전화번호
    condition varchar2(15) NOT NULL         -- 현직/대기여부
);