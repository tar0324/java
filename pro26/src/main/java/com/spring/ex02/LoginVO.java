package com.spring.ex02;

public class LoginVO {
   public String userID;
   public String userName;
   public LoginVO(String userID, String userName) {
      
      this.userID = userID;
      this.userName = userName;
   }
   public LoginVO() {
      
   }

   public String getUserID() {
	   return userID;
   }
   public void setUserID(String userID) {
	   this.userID = userID;
   }
   public String getUserName() {
      return userName;
   }
   public void setUserName(String userName) {
      this.userName = userName;
   }
   
   
   
}