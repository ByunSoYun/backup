package com.test.question.q25;


	import java.util.Arrays;

	public class MyHashMap1 {
		
		//case A.
		
		private String[] keys; //키를 담을 배열
		private String[] values; //값을 담을 배열
		private int index; //*** 여전히 중요, 역할 동일
		
		public MyHashMap1() {
			this.keys = new String[4];
			this.values = new String[4];
			this.index = 0;
		}
		
		public void put(String key, String value) {
			
			double2();//배열의 방번호를 2배시키는 메소드
			
			//풀이1)
//			boolean same = false; //key값이 이미 있는 값인지 확인해보고 있으면 수정 없으면 추가
//			
//			for(int i=0; i<index; i++) { //수정
//				if(this.keys[i].equals(key)) {
//					this.values[i] = value;
//					same = true;
//				}
//			}
//			 
//			if(same == false) {//추가
//				this.keys[this.index] = key;
//				this.values[this.index] = value;
//				this.index++;
//			} 
			
			//풀이2)
//			for(int i = 0; ; i++) {
//		         if(this.index == 0) { //index가 0일 경우 비교할 배열이 없으므로 값 넣어주기
//		            this.keys[this.index] = key;
//		            this.values[this.index] = value;
//		            this.index++;
//		            break;
//		         }else if(this.keys[i] == key) {  //배열에 동일한 값이 들어있을때
//		            this.values[i] = value;  //덮어쓰기
//		            break;
//		         }else if(i == this.index-1) {  // 포문을 다 돌아 검사하였는데 동일한 값이 없을 경우 값 추가
//		            this.keys[this.index] = key;
//		            this.values[this.index] = value;
//		            this.index++;
//		         }
//		      }
			
			
			
			for(int i = 0; ; i++) {
		          // index가 0일 경우와 포문을 다 돌아 검사하였는데 동일한 값이 없을 경우 값 추가
		         if(this.index == 0 || i == this.index-1) { 
		            this.keys[this.index] = key;
		            this.values[this.index] = value;
		            this.index++;
		            break;
		         }else if(this.keys[i] == key) {  //배열에 동일한 값이 들어있을때
		            this.values[i] = value;  //덮어쓰기
		            break;
		         }
		      }
			
		}

		//double
		private void double2() {
			if(this.index >= this.keys.length) {
				String[] newKeys = new String[keys.length*2];
				String[] newValues = new String[values.length*2];
				
				for(int i=0; i<index; i++) {
					newKeys[i] = keys[i];
					newValues[i] = values[i];
				}
				
				this.keys = newKeys;
				this.values = newValues;
				
			}
		}
		
		


		//get, 읽기
		public String get(String key) {
			for(int i=0; i<index; i++) {
				if(this.keys[i].equals(key))	{
					return this.values[i];
				}
			}
			
			return null;
		}
		
		
		
		//size, 개수
		public int size() {
			return index;
		}
		
		
		//remove, 삭제
		public void remove(String key) {
			for(int i=0; i<this.index; i++) {
				if(this.keys[i].equals(key)) { //key값이 같은걸 찾으면
					
					for(int j=i; j<=index; j++) {
//						keys[j] = keys[j+1];//좌측시프트 //HashMap은 삭제시 방이름으로 접근하기 때문에 인덱스만 수정한다.
//						values[j] = values[j+1]; 
						index--;
					}
					
				}
			}
		}
		
		
		//containKey, 검색
		boolean contaionKey(String key) {
			for(int i=0; i<this.index; i++) {
				if(this.keys[i].equals(key)) {
					return true;
				}
			}
			return false;
		}
		
		
		//containsKValue, 검색
		boolean contaionsValue(String value) {
			for(int i=0; i<this.index; i++) {
				if(this.values[i].equals(value)) {
					return true;
				}
			}
			return false;
		}
			
		
		//clear, 검색
		public void clear() {
//			this.keys = new String[4];
//			this.values = new String[4];
			index = 0;
		}
			
		
		
//		//case B.
//		private Entry[] list;
//		private int index;
	//	
//		public MyHashMap()	{
//			this.list = new Entry[4];
//			this.index = 0;
//			
//		}
	//	
//		//put
//		public void put(String key, String value) {
//			
//			doubling();
//			
//			boolean same = false;
//			
//			for(int i=0; i<index; i++) {
//				if(list[i].key.equals(key)) {
//					list[i].value = value;
//					same = true;
//				}
//			}
//			
//			if(same == false) {
//				Entry e = new Entry();
//				e.key = key;
//				e.value = value;
//				
//				this.list[this.index] = e;
//				this.index++;
//			}
//			
//			
//		}
	//
	//	
	//
//		@Override
//		public String toString() {
	//
//			return "MyHashMap [list=" + Arrays.toString(list) + ", index=" + index + "]";
//		}
	//
//		private void doubling() {
//			if (index>=this.list.length) {
//				Entry[] temp = new Entry[index * 2];
//				
//				for(int i=0; i<index; i++) {
//					temp[i] = this.list[i];
//				}
//				
//				this.list = temp;
//			}
//		}
	//	
//		//get
//		public String get(String key) {
//			for(int i=0; i<index; i++) {
//				if(this.list[i].key.equals(key)) {
//				return this.list[i].value;
//				}
//			}
//			
//			return null;
//		}

		
		

	}//MyHashMap


	class Entry {
		public String key;
		public String value;
		@Override
		public String toString() {
			return "Entry [key=" + key + ", value=" + value + "]";
		}
	}













}


/


package com.test.question.q25;

public class MyHashMap {
   
   //Case A. 
   private String[] keys; //키를 담을 배열
   private String[] values; // 값을 담을 배열
   private int index; // **여전히 중요, 역할 동일
   
   public MyHashMap() {
      this.keys = new String[4];
      this.values = new String[4];
      this.index = 0;
   }
   
   public void put(String key, String value) {
      
      doubling();  // 값을 넣어줄 방이 남아있는지 확인
      
      for(int i = 0; ; i++) {
          // index가 0일 경우와 포문을 다 돌아 검사하였는데 동일한 값이 없을 경우 값 추가
         if(this.index == 0 || i == this.index-1) { 
            this.keys[this.index] = key;
            this.values[this.index] = value;
            this.index++;
            break;
         }else if(this.keys[i] == key) {  //배열에 동일한 값이 들어있을때
            this.values[i] = value;  //덮어쓰기
            break;
         }
      }
         
      
   }//put
   
   private void doubling() {
      
      if(this.index >= this.keys.length) {
         
         String[] tempK = new String[this.keys.length * 2];
         String[] tempV = new String[this.values.length * 2];
         
         //깊은 복사(짧은 배열 길이만큼 반복) //주소복사X, 방끼리 복사O
         for(int i=0; i<this.keys.length; i++) {
            tempK[i] = this.keys[i]; //원래 배열의 방 -> 2배 배열의 방 -> 1:1 복사
            tempV[i] = this.values[i];
         }
         this.keys = tempK; //배열 교체
         this.values = tempV;
      }
   }
   

   public String get(String key) {
      
      for(int i=0; i<this.index; i++) {
         if(this.keys[i].equals(key)) {
            return this.values[i];
         }
      }
      throw new IndexOutOfBoundsException();
      
   }//get
   
   
   public int size() {
      return this.index;
   }//size
   

   public void remove(String key) {
      
      for(int i=0; i<this.index; i++) {
         if(this.keys[i] == key) {
            this.values[i] = null;
            this.index--;
         }
      }
      
   }//remove
   
   
   public boolean containKey(String key) {
      
      for(int i=0; i<this.index; i++) {
         if(this.keys[i] == key) {
            return true;
         }
      }
      return false;
   }
   
   
   public boolean containValue(String value) {

      for(int i=0; i<this.index; i++) {
         if(this.values[i] == value) {
            return true;
         }
      }
      return false;
   }
   
   
   public void clear() {
      this.index = 0;
   }
   
   
   @Override
   public String toString() {
      
      
      return String.format("key_length: %d\nvalue_length: %d\nindex: %d\n" 
                           ,this.keys.length //실제 내부 배열의 길이
                           ,this.values.length 
                           ,this.index);

   }
   
}//MyHashMap
