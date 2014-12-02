package com.spring.jms.queue;

import java.io.Serializable;

public class Employee implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  
  private int empID;
  private String empName;
  public int getEmpID() {
    return empID;
  }
  public void setEmpID(int empID) {
    this.empID = empID;
  }
  public String getEmpName() {
    return empName;
  }
  public void setEmpName(String empName) {
    this.empName = empName;
  }
  
  

}
