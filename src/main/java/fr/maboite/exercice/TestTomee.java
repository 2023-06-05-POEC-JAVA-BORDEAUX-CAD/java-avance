package fr.maboite.exercice;


import javax.inject.Singleton;


@Singleton
public class TestTomee {
 
   private String test ="Test"; 

  public TestTomee(String test){
    this.test =test;
  }

  public String getTest() {
    return test;
  }

 public void setTest(String test) {
   this.test = test;
 }

  

  
  
  
}
