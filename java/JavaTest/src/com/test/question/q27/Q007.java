package com.test.question.q27;

import java.io.File;
import java.util.ArrayList;

public class Q007 {
	public static void main(String[] args) {
	      
	    String pathA = "C:\\Users\\변소윤\\Documents\\카카오톡 받은 파일\\027_파일_디렉토리\\파일_디렉토리_문제\\동일 파일\\MusicA"; 
		
		
		String pathB = "C:\\Users\\변소윤\\Documents\\카카오톡 받은 파일\\027_파일_디렉토리\\파일_디렉토리_문제\\동일 파일\\MusicB"; 
		
		
		      File dirA = new File(pathA);
		      File dirB = new File(pathB);
		      
		      File[] listA = dirA.listFiles();
		      File[] listB = dirB.listFiles();
		      
//		      File[] listC = null ;
//		      System.arraycopy(listA, 0, listC, 0, listA.length);
//		      System.arraycopy(listB, 0, listC, listA.length, listB.length);
//		      
		      //File[] listD = listC - listA;
		      
		      
		      //File[] sum =  
		            //listA[] + listB[];
		      
		      ArrayList<String> sum1 = new ArrayList<String>();
		      
		      
		      
		      for (File nameA : listA) {
		         
		         for (File nameB : listB) {
		            
		            if(nameA.getName().equals(nameB.getName())) {
		               
		               //System.out.println(nameB.getName());
		               sum1.add(nameB.getName());
		               
		               
		            } 
		            
		         }
		         
		      }
		      
		      for (File nameA : listA) {
		         
		         for(int i=0; i<sum1.size(); i++) {
		            if(nameA.getName().equals(sum1.get(i))) {
		               //System.out.println(nameA.getName());
		               
		            } else {
		               System.out.println(nameA.getName());
		            }
		            
		         }
		      }
		      
		      
		      
		   }

		}