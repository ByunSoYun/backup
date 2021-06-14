--[관리자]
select * from tblManager;
--[교사]
select * from tblTeacher;
--[교육생]
select * from tblStudent;
--[전체과정]
select * from tblTotalCourse;
--[강의실]
select * from tblClassroom;
--[전체과목]
select * from tblTotalSubject;
--[전체교재]
select * from tblAllBook;
--[출결]
select * from tblAttendance;
--[교사평가]
select * from tblteachersurvey;
--[개설과정]
select * from tblOpenCourse;
--[강의가능과목]
select * from tblPossibleSubject;
--[사용교재]
select * from tblUsedBook;
--[상담일지]
select * from tblCounselingDiary;
--[개설과목]
select * from tblOpenSubject;
--[강의스케줄]
select * from tblLectureSchedule;
--[강의평가]
select * from tblCourseSurvey;
--[시험지등록]
select * from tblRegistrationStatus;
--[시험]
select * from tblTest;
--[성적]
select * from tblScore;
--[시험문제]
select * from tblTestQuestion;
--[수강신청]
select * from tblEnrollment;
--[교육종료교육생]
select * from tblCompleteStudent;
--[취업현황]
select * from tblEmployment;
--[구인공고]
select * from tblJobPost;
--[자격증]
select * from tblLicense;


select 
    s.name as 교육생이름,
    s.enrolldate as 등록일,
    oc.opencourseseq as 과정번호,
    oc.begindate as 과정시작일,
    tc.name as 과정명,
    os.begindate as 개설과목시작날짜,
    ts.name as 과목명,
    tt.name as 교사명,
    te.testdate as 시험날짜,
    score.attendancescore,
    te.testseq
from tblStudent s
    inner join tblEnrollment e
        on s.studentseq = e.studentseq
            inner join tblOpenCourse oc
                on oc.opencourseseq = e.opencourseseq
                    inner join tbltotalcourse tc
                        on oc.totalcourseseq = tc.totalcourseseq
                            inner join tblopensubject os
                                on oc.opencourseseq = os.opencourseseq
                                    inner join tbltotalsubject ts
                                        on ts.totalsubjectseq = os.totalsubjectseq
                                            inner join tblteacher tt
                                                on tt.teacherseq = oc.teacherseq
                                                    inner join tblTest te
                                                        on te.opensubjectseq = os.opensubjectseq
                                                            inner join tblScore score
                                                                on score.testseq = te.testseq and e.enrollmentseq = score.enrollmentseq
                                                                    where oc.opencourseseq = 1;
                                                               
                                                            
select 
    tc.score,
    oc.opencourseseq
FROM tblenrollment e
    inner join tblOpenCourse oc
        on oc.opencourseseq = e.opencourseseq
            inner join tblOpenSubject os
                on os.openCourseSeq = oc.opencourseseq
                    inner join tblCourseSurvey tc
                        on tc.openSubjectSeq = os.opensubjectseq
                            where oc.opencourseseq = 3;

select 
    st.name,
    cs.surveyComment,
    cs.coursesurveyseq
from tblstudent st
    inner join tblenrollment en
    on st.studentseq = en.studentseq
    inner join tblcoursesurvey cs
    on en.enrollmentseq = cs.enrollmentseq;
    

select 
    t.name,
    ts.name
from tblOpenCourse oc
    inner join tblTeacher t
        on oc.teacherSeq = t.teacherseq
            inner join tblPossibleSubject ps
                on ps.teacherSeq = t.teacherseq
                    inner join tblTotalSubject ts
                        on ts.totalSubjectSeq = ps.totalsubjectseq;


select 
    t.name,
    ts.name
from tblTeacher t 
            inner join tblPossibleSubject ps
                on ps.teacherSeq = t.teacherseq
                    inner join tblTotalSubject ts
                        on ts.totalSubjectSeq = ps.totalsubjectseq;
    


select
    cs.completeStudentSeq as "고유번호",
    cs.completeDate as "수료(중도탈락)날짜",
    cs.condition as "수료/중도탈락",
    e.companyName as 회사명,
    e.annualIncome as 연봉,
    e.area as 근무지,
    s.name as 교육생이름
from tblCompleteStudent cs
    inner join tblEmployment e
        on cs.completeStudentSeq = e.completeStudentSeq
            inner join tblEnrollment em
                on cs.enrollmentSeq = em.enrollmentSeq
                    inner join tblStudent s
                        on s.studentSeq = em.studentSeq;
                        
                        
                        
                        
-- 상담일지와 수강신청, 교육생을 연결한 테이블              
select
    cd.counselingDiarySeq as "상담일지 고유번호",
    cd.counselingDate as 상담날짜,
    cd.content as 상담내용,
    em.openCourseSeq as "개설과정 고유번호",
    em.beginDate as 과정시작기간,
    em.endDate as 과정종료기간,
    -- as "교육생 등록인원",
    s.name as "교육생 이름"
from tblCounselingDiary cd
    inner join tblEnrollment em
        on em.enrollmentSeq = cd.enrollmentSeq
            inner join tblStudent s
                on em.studentSeq = s.studentSeq;                        


-- 교육생 -> 취업현황

select st.name,
        em.companyname
from tblstudent st
    inner join tblenrollment en
    on st.studentseq = en.studentseq
    inner join tblcompletestudent cs
    on en.enrollmentseq = cs.enrollmentseq
    inner join tblemployment em
    on cs.completestudentseq = em.completestudentseq;
                        
select st.name,
        ls.condition
from tblstudent st
    inner join tblenrollment en
    on st.studentseq = en.studentseq
    inner join tblcoursesurvey cs
    on en.enrollmentseq = cs.enrollmentseq
    inner join tblopensubject os
    on cs.opensubjectseq = os.opensubjectseq
    inner join tbllectureschedule ls
    on os.opensubjectseq = ls.opensubjectseq;                        

select ts.name,
       ab.name
from tblopencourse oc
    inner join tblopensubject os
    on oc.opencourseseq = os.opencourseseq
    inner join tbltotalsubject ts
    on os.totalsubjectseq = ts.totalsubjectseq
    inner join tblusedbook ub
    on ts.totalsubjectseq = ub.totalsubjectseq
    inner join tblallbook ab
    on ub.allbookseq = ab.allbookseq;



                        
select st.name,
        ab.name
from tblstudent st
    inner join tblenrollment en
    on st.studentseq = en.studentseq
    inner join tblcoursesurvey cs
    on en.enrollmentseq = cs.enrollmentseq
    inner join tblopensubject os
    on cs.opensubjectseq = os.opensubjectseq
    inner join tbltotalsubject ts
    on os.totalsubjectseq = ts.totalsubjectseq
    inner join tblusedbook ub
    on ts.totalsubjectseq = ub.totalsubjectseq
    inner join tblallbook ab
    on ub.allbookseq = ab.allbookseq; 
    
    
/*


13. 교육종료 교육생 관리
- 관리자 
14. 교재 관리 
- 교사
1. 강의 스케줄 조회
- 교육생

    
*/

--[메인] > [관리자] > [교육 종료 교육생 관리]


--1.[기간 선택]
-- - 과정명 ( 과정
-- - 과정종료날짜

--조회

select
    tc.totalcourseseq as 과정고유번호, 
    tc.name as 과정명,
    oc.endDate as 종료날짜
from tblOpenCourse oc
    inner join tblTotalCourse tc
        on tc.totalCourseSeq = oc.totalCourseSeq
    where oc.endDate < to_char(sysdate, 'yy-mm-dd');




select 
    tc.name as "해당과정",
    oc.endDate as "과정종료날짜",
    st.studentseq as "고유번호",
    st.name as "이름",
    st.birth as "생년월일",
    st.phoneNumber as "전화번호",
    cs.completeDate as "수료날짜",
    cs.condition as "수료여부"
from tblstudent st
    inner join tblenrollment en
        on st.studentseq = en.studentseq
            inner join tblcompletestudent cs
                on cs.enrollmentseq = en.enrollmentseq
                    inner join tblOpenCourse oc
                    on en.openCourseSeq = oc.openCourseSeq
                        inner join tblTotalCourse tc
                        on tc.totalCourseSeq = oc.totalCourseSeq
                    where st.condition in ('수료완료','중도탈락') and tc.totalCourseSeq =1 ;                    
                    
                
                
-- 추가
--            values (studentSeq.nextVal, 변소윤, '2159972', '010-8703-1213', '2020-09-01', '수료완료','null');
--INSERT INTO tblStudent (studentSeq, name, ssn, phoneNumber, condition) 

--고유번호, 수료날짜, 수료상태, 수강신청고유번호


 
update tblstudent set 
    condition = '수료완료'
        where studentSeq = 추가할 학생의 고유번호;
       
        --프로시저로 도전

INSERT INTO tblCompleteStudent(completeStudentSeq, completeDate, condition, enrollmentSeq)
            VALUES(completeStudentSeq.nextval, '2020-08-26', '수료완료', 30);                   
            
           

-- 수정
update tblCompleteStudent set
    completeDate = '원하는데이터', 
    condition = '원하는데이터'
        where completeStudentSeq = 종료된학생고유번호;



--삭제 - 취업현황 교육종료교육생..

delete from tblCompleteStudent where studentSeq = 삭제할 학생의 고유번호;
delete from tblEmployment where studentSeq = 삭제할 학생의 고유번호;



--2. 과정추가 
--    
--  - 교육 종료 과정입력
--     - 과정명
--     - 과정 종료 날짜

INSERT INTO tblTotalCourse(totalCourseSeq, name, period)
            VALUES(totalCourseSeq.nextval, '과정명', '과정기간');
        

INSERT INTO tblOpenCourse(openCourseSeq, beginDate, endDate, registerCount, teacherSeq,totalCourseSeq,classroomSeq)
            VALUES(openCourseSeq.nextval, '과정시작기간', '과정종료기간','교육생등록인원',teacherSeq,totalCourseSeq,classroomSeq);




 /*
 [메인] > [관리자] > [교재관리]
1. 교재관리
 전체 교재 목록 조회.
- 교재 고유번호
- 교재명
- 출판사
- 저자
- 가격
*/

select 
    allBookSeq as "교재고유번호",
    name as "교재명",
    publisher as "출판사",
    writer as "저자",
    price as "가격"
from tblAllBook;


/*
1.1 [사용교재 선택]
  - 전체 교재 중 사용할 교재 선택.
- 교재 고유번호
- 교재명
- 출판사
- 저자
- 가격
- 과목명
*/


select 
    ab.allBookSeq as "교재고유번호",
    ab.name as "교재명",
    ab.publisher as "출판사",
    ab.writer as "저자",
    ab.price as "가격",
    ts.name as "과목명"
from tblAllBook ab
    inner join tblUsedBook ub
     on ub.allbookseq = ab.allbookseq
        inner join tblTotalSubject ts
        on ts.totalsubjectseq = ub.totalsubjectseq
            where ts.totalSubjectSeq = 1;
        
        
/*
1.2 [교재 추가]
-	추가할 교재 입력
- 교재 고유번호
- 교재명
- 출판사
- 저자
- 가격

*/

INSERT INTO tblAllBook(allBookSeq, name, publisher, writer,price)
            VALUES(allBookSeq.nextval, '책이름', '출판사', '저자','가격');
        

              
INSERT INTO tblUsedBook(usedBookSeq, totalSubjectSeq, allBookSeq)
            VALUES(usedBookSeq.nextval, totalSubjectSeq, allBookSeq);
          -- 전체 교재에 추가하고 이 작업 실행 
          -- 필요한 과목으로 totalSubjectSeq 설정 



/*   1.4 [교재 수정]
-	수정할 교재내용 입력
- 교재 고유번호
- 교재명
- 출판사
- 저자
- 가격
*/


update tblAllBook set
    name = '원하는데이터', 
    publisher = '원하는데이터',
    writer = '원하는데이터',
    price  = '원하는데이터'
        where allBookSeq = 원하는 교재 고유번호;



/*

[메인] > [교사] > [강의 스케줄 조회]
1. [담당 강의 스케줄 조회]
- 해당 교사가 담당하고 있는 강의 스케줄을 출력한다.
- 과목번호
- 과정명
- 과정 시작날짜(년월일)
- 과정 종료날짜(년월일)
- 강의실이름
- 과목명
- 과목 시작날짜(년월일)
- 과목 종료날짜(년월일)
- 교재명
- 교육생 등록 인원
- 강의 진행 상태
*/

--
select 
tc.name as "과정명",
oc.beginDate as "과정시작기간",
oc.endDate as "과정종료기간",
cr.name as "강의실이름",
ts.name as "과목명",
os.beginDate as "과목시작날짜",
os.endDate as "과목종료날짜",
ab.name as "교재명",
oc.registercount as "교육생 등록인원",
ls.condition as "강의진행상태"


from tblTotalSubject ts 
    inner join tblUsedBook ub
        on ts.totalSubjectSeq = ub.totalSubjectSeq
            inner join tblAllBook ab
            on ub.allBookSeq = ab.allBookSeq
                 inner join tblOpenSubject os
                 on os.totalSubjectSeq = ts.totalSubjectSeq
                     inner join tblOpenCourse oc
                     on oc.openCourseSeq = os.openCourseSeq
                         inner join tblTotalCourse tc
                         on  tc.totalCourseSeq = oc.totalCourseSeq
                            inner join tblClassroom cr
                            on oc.classroomSeq = cr.classroomSeq
                                inner join tblLectureSchedule ls
                                    on ls.openSubjectSeq = os.openSubjectSeq
                                        inner join tblTeacher tc
                                        on tc.teacherseq = oc.teacherseq
                                            where tc.teacherseq = 1
                                            order by os.beginDate asc;
                                            
                                            


/*

1.1 [특정 과목 조회]
  - 특정 과목을 선택 시 해당 과정에 등록된 교육생 정보를 출력한다.
    - 교육생 이름
    - 전화번호
    - 등록일
    - 수료/중도탈락 여부
*/
                           
                        
select 
st.name as "이름",
st.phonenumber as "전화번호",
st.enrollDate as "등록일",
st.condition as "수료여부"

from tblStudent st
    inner join tblEnrollment em
    on st.studentSeq = em.studentSeq
        inner join tblOpenCourse oc
        on oc.openCourseSeq = em.openCourseSeq
            inner join tblOpenSubject os
            on os.openCourseSeq = oc.openCourseSeq
                    where os.openSubjectSeq = 3;
                    
                    
                    
-- 1.1 [특정 개설 과정 조회]
-- 1.1.1 [개설 과목 정보]
-- 개설 과목명
-- 개설과목기간(시작 년월일)
-- 개설과목기간(종료 년월일)
-- 개설 과목 교재명
select
    oc.openCourseSeq as 개설과정번호,
    ts.name as "개설 과목명",
    os.beginDate as 과목시작날짜,
    os.endDate as 과목종료날짜,
    ab.name as "교재명",
    t.name as 교사명
from tblTotalCourse tc
    inner join tblOpenCourse oc
        on oc.totalCourseSeq = tc.totalCourseSeq
    inner join tblClassroom cr
        on oc.classroomSeq = cr.classroomSeq
    inner join tblOpenSubject os
        on os.openCourseSeq = oc.openCourseSeq
    inner join tblTotalSubject ts
        on ts.totalSubjectSeq = os.totalSubjectSeq
    inner join tblUsedBook ub
        on ub.totalSubjectSeq = ts.totalSubjectSeq
    inner join tblAllBook ab
        on ab.allBookSeq = ub.allBookSeq
    inner join tblPossibleSubject ps
        on ts.totalSubjectSeq = ps.totalSubjectSeq
    inner join tblTeacher t
        on t.teacherSeq = ps.teacherSeq
    where oc.openCourseSeq = 1;


-- 1.1.2. [교육생 정보]
select
    s.name as "교육생 이름",
    s.ssn as "주민번호 뒷자리",
    s.phoneNumber as 전화번호,
    s.enrollDate as 등록일,
    s.condition as "수료/중도탈락여부"
from tblStudent s
    inner join tblEnrollment e
        on s.studentSeq = e.studentSeq
    inner join tblOpenCourse oc
        on e.openCourseSeq = oc.openCourseSeq
    inner join tblTotalCourse tc
        on tc.totalCourseSeq = oc.totalCourseSeq
    inner join tblOpenSubject os
        on os.openCourseSeq = oc.openCourseSeq
    inner join tblTotalSubject ts
        on ts.totalSubjectSeq = os.totalSubjectSeq
    where oc.openCourseSeq = 1;
                  