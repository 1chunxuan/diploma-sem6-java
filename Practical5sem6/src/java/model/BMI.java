/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tang Chun Xuan
 */
public class BMI {
    private double weight;
    private double height;
    private double BMI;
    private String category;

    public BMI(double weight, double height) {
        this.weight = weight;//kg
        this.height = height;//cm/100
        this.BMI=weight/((height/100)*(height/100));
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public String getCategory() {
        if(BMI<16){
            category="Seriously underweight";
           
        }
        else if(BMI<18){
            category="Underweight";
        }
        else if(BMI<24){
            category="Normal";
        }
        else if(BMI<29){
            category="Overweight";
        }
        else if(BMI<35){
            category="Obese Class I";
        }
        else{
            category="Obese Class II,III";
        }
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
