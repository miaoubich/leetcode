package net.miaoubich.sql2java8;

public class Staff {

	private String branchNo;
    private String staffNo;
    private double salary;

    public Staff(String branchNo, String staffNo, double salary) {
        this.branchNo = branchNo;
        this.staffNo = staffNo;
        this.salary = salary;
    }

	public String getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Staff [branchNo=" + branchNo + ", staffNo=" + staffNo + ", salary=" + salary + "]";
	}
}
