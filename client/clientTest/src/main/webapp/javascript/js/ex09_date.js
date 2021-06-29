var now = new Date();
console.log(now) //2021-06-23T01:18:17.594Z (대한민국 표준시)

//요소 추출 
//c.get(Calendar.YEAR);
console.log(now.getYear()); //121,1999년 이전 2자리 표기 함수
console.log(now.getFullYear()); // 2021, 2000년 이후
console.log(now.getMonth()); // 0~11,월 
console.log(now.getDate());// 23,일 
console.log(now.getDay()); // 3, 요일(0~6)
console.log(now.getHours()); // 시
console.log(now.getMinutes());// 분
console.log(now.getSeconds());// 초
console.log(now.getMilliseconds());// 밀리초
console.log(now.getTime()); // 틱

// 덤프 (+출력)
// - %tF(2021-06-23), %tT(10:22:30), %tA(요일)

console.log(now);
console.log(now.toString());
console.log(now.toLocaleSstring()); //현지 설정 

console.log(now.toDateString());
console.log(now.toTimeString());

console.log(now.toLocaleDateString());
console.log(now.toLocaleTimeString());







