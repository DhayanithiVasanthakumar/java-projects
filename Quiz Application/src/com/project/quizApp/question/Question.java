package com.project.quizApp.question;

public class Question {

	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	
	/*
	 * default constructor
	 */
	public Question() {
		
	}
	
	/*
	 * constructor with feilds
	 */
	public Question(String question,String option1,String option2,String option3,String option4) {
		this.question=question;
		this.option1=option1;
		this.option2=option2;
		this.option3=option3;
		this.option4=option4;
	}
	
	
	/*
	 * getter setter
	 */
	public String getQuestion(){
		return question;
	}
	public void setQuestion(String question) {
		this.question=question;
	}
	
	
	public String getoption1(){
		return option1;
	}
	public void setoption1(String option1) {
		this.option1=option1;
	}
	
	
	public String getoption2(){
		return option2;
	}
	public void setoption2(String option2) {
		this.option2=option2;
	}
	
	
	public String getoption3(){
		return option3;
	}
	public void setoption3(String option3) {
		this.option3=option3;
	}
	
	public String getoption4(){
		return option4;
	}
	public void setoption4(String option4) {
		this.option4=option4;
	}
	
	
	
	
	/*
	 * override the toString()
	 */
	public String toString() {
		return"Questions{"+
				"Question= "+question+
				"\noption1= "+option1+
				"\noption2= "+option2+
				"\noption3= "+option3+
				"\noption4= "+option4+
				"}";
	}
}
