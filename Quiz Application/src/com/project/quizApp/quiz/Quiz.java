package com.project.quizApp.quiz;

import com.project.quizApp.question.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Quiz {
	public void logic() {
		
		int correctAnswerCount=0;
		int wrongAnswerCount=0;
		Scanner input=new Scanner(System.in);
		
		/*
		 * questions in this format
		 * 
		 * Question class constructor
		 * 
		 * 	public Question(String question,   
		 * String option1, 
		 *  String option2,
		 *  String option3,
		 *  String option4)

		 */
		
		Question q1=new Question("1) Which of the following option leads to the portability and security of Java?",
									"A. Bytecode is executed by JVM",
									"B. The applet makes the Java code secure and portable",
									"C. Use of exception handling",
									"D. Dynamic binding between objects ");
		
		Question q2=new Question("2)Which of the following is not a Java features?",	
									"A. Dynamic",
									"B. Architecture Neutral",
									"C. Use of pointers",
				 					"D. Object-oriented");	
		
		Question q3=new Question("3)_____ is used to find and fix bugs in the Java programs.",
				
									"A. JVM",
									"B. JRE",
									"C. JDK",
									"D. JDB");
				
		Question q4=new Question("4)What is the return type of the hashCode() method in the Object class?",
				
									"A .Object",
									"B. int",
									"C. long",
				 					"D. void");
		
		
		
		
		/*
		 * create hash map ->to store the question and options 
		 * 
		 * inside the hashmap store 
		 * KEY -> question
		 * VALUE -> options ->  as a characte i,e A,B,C,D
		 */
		
		Map<Question,Character> hmap=new HashMap<>();
		
		hmap.put(q1, 'A');
		hmap.put(q2, 'C');
		hmap.put(q3, 'D');
		hmap.put(q4, 'B');
		
		/*
		 * map ooda entry ah array la vangi read panarom
		 */
		for(Map.Entry<Question,Character> map:hmap.entrySet()) {
			//get question
			System.out.println(map.getKey().getQuestion());
			//get options
			System.out.println(map.getKey().getoption1());
			System.out.println(map.getKey().getoption2());
			System.out.println(map.getKey().getoption3());
			System.out.println(map.getKey().getoption4());
			
			System.out.println("Enter your Answer: ");
			/*
			 * input.next().charAt(0) -> string oda zero'th index la irukara character mattum read panu
			 */
			Character answer=input.next().charAt(0);
			
			
			/*
			 * intha answer object ah um(user input), 
			 * map ooda answer pre defined ->ithu map la value ah store aagiruku
			 * 
			 * so intha 2 object h um compare panarom ->equal ah iruntha crt ilana false
			 */
			
			int checkAns=Character.compare(answer, map.getValue());
			//mela compare pana 2 object um same na 0,ilana 1
			if(checkAns==0) {
				System.out.println("Correct");
				correctAnswerCount++;
			}else {
				System.out.println("Wrong");
				wrongAnswerCount++;
			}
		}
		
		
		
		/*
		 * result
		 */
		
		System.out.println();
		System.out.println("--------RESULT-----------");
		System.out.println("Total Questions: "+hmap.size());
		System.out.println("Correct Answered Questions: "+correctAnswerCount);
		System.out.println("Wrong Answer Questions: "+wrongAnswerCount);
		//percentage -> 100 * correctAnswer divided by no of questions
		double percentage=(100*correctAnswerCount)/hmap.size();
		System.out.println("Percentage: "+percentage);
		
		//grade
		System.out.println("Your Grade ");
		if(percentage==100) {
			System.out.println("O");
		}
		else if(percentage>90) {
			System.out.println("A+");
		}
		else if(percentage>80) {
			System.out.println("A");
		}
		else if(percentage>70) {
			System.out.println("B");
		}
		else if(percentage>60) {
			System.out.println("B+");
		}
		else if(percentage>50) {
			System.out.println("C");
		}
		else if(percentage<50) {
			System.out.println("U");
		}
		
		
	
		}
}
