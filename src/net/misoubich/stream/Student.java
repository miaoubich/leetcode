package net.misoubich.stream;

import java.util.Objects;

public class Student {

	 private int id;
	 private String firstName;
	 private String lastName;
	 private int age;
	 private String gender;
	 private String departmentName;
	 private int joinedYear;
	 private String city;
	 private int rank;

	 public Student(int id, String firstName, String lastName, int age, String gender, String departmentName,
	   int joinedYear, String city, int rank) {
	  this.id = id;
	  this.firstName = firstName;
	  this.lastName = lastName;
	  this.age = age;
	  this.gender = gender;
	  this.departmentName = departmentName;
	  this.joinedYear = joinedYear;
	  this.city = city;
	  this.rank = rank;
	 }

	 public int getId() {
	  return id;
	 }

	 public void setId(int id) {
	  this.id = id;
	 }

	 public String getFirstName() {
	  return firstName;
	 }

	 public void setFirstName(String firstName) {
	  this.firstName = firstName;
	 }

	 public String getLastName() {
	  return lastName;
	 }

	 public void setLastName(String lastName) {
	  this.lastName = lastName;
	 }

	 public int getAge() {
	  return age;
	 }

	 public void setAge(int age) {
	  this.age = age;
	 }

	 public String getGender() {
	  return gender;
	 }

	 public void setGender(String gender) {
	  this.gender = gender;
	 }

	 public String getDepartmentName() {
	  return departmentName;
	 }

	 public void setDepartmantName(String departmantName) {
	  this.departmentName = departmantName;
	 }

	 public int getJoinedYear() {
	  return joinedYear;
	 }

	 public void setJoinedYear(int joinedYear) {
	  this.joinedYear = joinedYear;
	 }

	 public String getCity() {
	  return city;
	 }

	 public void setCity(String city) {
	  this.city = city;
	 }

	 public int getRank() {
	  return rank;
	 }

	 public void setRank(int rank) {
	  this.rank = rank;
	 }
	 
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Student student = (Student) o;
	        return id == student.id &&
	               age == student.age &&
	               joinedYear == student.joinedYear &&
	               rank == student.rank &&
	               Objects.equals(firstName, student.firstName) &&
	               Objects.equals(lastName, student.lastName) &&
	               Objects.equals(gender, student.gender) &&
	               Objects.equals(departmentName, student.departmentName) &&
	               Objects.equals(city, student.city);
	    }

	    @Override
	 public int hashCode() {
		 return Objects.hash(id, firstName, lastName, age, gender, departmentName, joinedYear, city, rank);
	 }

	 @Override
	 public String toString() {
	  return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
	    + ", gender=" + gender + ", departmentName=" + departmentName + ", joinedYear=" + joinedYear + ", city="
	    + city + ", rank=" + rank + "]";
	 }
	
}
