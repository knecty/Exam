package salary;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        //money存储要缴纳的税费
        double money;
        System.out.print("请输入工资：");
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        //工资小于缴税起征点不用交税
        if (salary < 3500){
            System.out.println("所需要缴纳的税费为：0");
        }else {
            //temp存储工资和缴税起征点的差值
            double temp = salary - 3500;
            if (temp <= 1500){
                money = temp * 0.03;
                System.out.println("所需要缴纳的税费为：" + money);
            }else if (temp > 1500 && temp <= 4500){
                money = temp * 0.10;
                System.out.println("所需要缴纳的税费为：" + money);
            }else if (temp > 4500 && temp <= 9000){
                money = temp * 0.20;
                System.out.println("所需要缴纳的税费为：" + money);
            }else if ((temp > 9000 && temp <35000)){
                money = temp * 0.25;
                System.out.println("所需要缴纳的税费为：" + money);
            }else if (temp >35000 && temp <= 55000){
                money = temp * 0.30;
                System.out.println("所需要缴纳的税费为：" + money);
            }else if (temp >55000 && temp <= 80000){
                money = temp * 0.35;
                System.out.println("所需要缴纳的税费为：" + money);
            }else {
                money = temp * 0.45;
                System.out.println("所需要缴纳的税费为：" + money);
            }
        }
    }
}
