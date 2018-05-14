package date;

import java.util.Scanner;

public class DateExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //正则匹配输入的年月日，包括平年和闰年
        String regex = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";

        while (true) {
            System.out.println("请输入日期,格式为：YYYY-MM-MM");
            String date = sc.next();
            if (date.matches(regex)) {
                //以"-"切割输入日期，存储到a数组中
                String[] a = date.split("-");
                //把String型的a数组转换为int型，存储到b数组
                int[] b = new int[a.length];
                for (int i = 0; i < b.length; i++) {
                    b[i] = Integer.parseInt(a[i]);
                }
                // 先判断输入的天数是否为28日，再判断是不是2月，再判断是不是闰年，
                // 如果是闰年，则下一天为29日，年月不变，否则下一天为1日，月数增加1月
                if (b[2] == 28){
                    if (b[1] == 2){
                        if ((b[0]%4 == 0 && b[0]%100 != 0) || b[0]%400 == 0){
                            b[2]++;
                        }else {
                            b[1]++;
                            b[2] = 1;
                        }
                    }
                //判断输入的天数是否为29日，再判断是否为2月，如果是2月，下一天为1日，月数增加1月，
                    // 否则下一天为30日，年月不变
                } else if (b[2] == 29){
                    if (b[1] == 2){
                        b[1]++;
                        b[2] = 1;
                    }else
                        b[2]++;
                //判断输入的天数是否为30日，再判断月份，如果是1,3,5,7,8,10,12月，下一天为31日，年月不变
                //如果是4,6,9,11月，则下一天为1日，月数增加一月
                } else if (b[2] == 30){
                    if (a[1].matches("0[13578]|1[02]")){
                        b[2]++;
                    }
                    if (a[1].matches("0[469]|11")){
                        b[1]++;
                        b[2] = 1;
                    }
                //判断输入的天数是否为31日，再判断月份是否为12月，如果是12月，则下一天为1日，月份变为1月，年数增加1年
                //如果不是12月，则下一日为1日，月份增加一月，年份不变
                } else if (b[2] == 31){
                    if (b[1] == 12){
                        b[0]++;
                        b[1] = 1;
                        b[2] = 1;
                    }else {
                        b[1]++;
                        b[2] = 1;
                    }
                 //其他情况下一天只需给输入天数增加1天
                }else
                    b[2]++;
                //将所得到的下一天的日期存储到数组a中
                for (int i = 1; i < b.length; i++) {
                    if (b[i] < 10){
                        a[i] = 0 + String.valueOf(b[i]);
                    }else {
                    a[i] = String.valueOf(b[i]);
                    }
                }
                a[0] = String.valueOf(b[0]);
                //输出下一天的日期
                System.out.println("输入日期的下一天为：");
                System.out.println(a[0] + "-" + a[1] + "-" + a[2]);
                break;
            }else {
                System.out.println("输入日期不正确，请重新输入！");
            }
        }
    }
}
