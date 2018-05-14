package map;

import java.util.*;

public class MapExam {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        //把50个随机数存储到集合list中
        for (int i = 0; i < 50; i++) {
            list.add(random.nextInt(100));
        }
        //往map中存放数据，每循环一次，将一个长度为3的集合存储到map中
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            for (int j = 0; j < 3; j++) {
                list1.add(random.nextInt(100));
            }
            //对集合排序
            Collections.sort(list1);
            map.put(list.get(i)/10,list1);
        }
        System.out.println(map);
    }
}
