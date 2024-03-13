/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Tang Chun Xuan
 */
public class Loan {
    private double loanAmount;
    private double interestRate;
    private int numberOfYear;
      private java.util.Date loanDate;

    public Loan() {
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getNumberOfYear() {
        return numberOfYear;
    }

    public void setNumberOfYear(int numberOfYear) {
        this.numberOfYear = numberOfYear;
    }

    public Loan(double loanAmount, double interestRate, int numberOfYear) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.numberOfYear = numberOfYear;
    }
    
     /** Find monthly payment */
  public double getMonthlyPayment() {
    double monthlyInterestRate = interestRate / 1200;
    return loanAmount * monthlyInterestRate / (1 - (Math.pow(1 / (1 + monthlyInterestRate), numberOfYear * 12)));
  }

  /** Find total payment */
  public double getTotalPayment() {
    return getMonthlyPayment() * numberOfYear * 12;
  }

  /** Return loan date */
  public java.util.Date getLoanDate() {
    return loanDate;
  }
}
