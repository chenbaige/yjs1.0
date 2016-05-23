package com.yjtc.cbg.yjsapp.model;

import com.yjtc.cbg.yjsapp.bean.User;
import com.yjtc.cbg.yjsapp.model.inter.IFriendListModel;
import com.yjtc.cbg.yjsapp.util.StringHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by chenboge on 16/5/9.
 */
public class FriendListModel implements IFriendListModel {

    private HashMap<String, Integer> selector;// 存放含有索引字母的位置
    private List<User> persons = null;
    private List<User> newPersons = new ArrayList<User>();

    @Override
    public String[] getIndexStr() {
        String[] indexStr = {"#", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z"};
        return indexStr;
    }

    @Override
    public List<User> getSortList() {
        getUser();
        String[] allNames = sortIndex(persons);
        for (int i = 0; i < allNames.length; i++) {
            if (allNames[i].length() != 1) {
                for (int j = 0; j < persons.size(); j++) {
                    if (allNames[i].equals(persons.get(j).getPinYinName())) {
                        User p = new User(persons.get(j).getUserName(), persons
                                .get(j).getPinYinName());
                        newPersons.add(p);
                    }
                }
            } else {
                newPersons.add(new User(allNames[i]));
            }
        }
        return newPersons;
    }

    public void getUser() {
        persons = new ArrayList<User>();
        User p1 = new User("耿琦");
        persons.add(p1);
        User p2 = new User("王宝强");
        persons.add(p2);
        User p3 = new User("柳岩");
        persons.add(p3);
        User p4 = new User("文章");
        persons.add(p4);
        User p5 = new User("马伊琍");
        persons.add(p5);
        User p6 = new User("李晨");
        persons.add(p6);
        User p7 = new User("张馨予");
        persons.add(p7);
        User p8 = new User("韩红");
        persons.add(p8);
        User p9 = new User("韩寒");
        persons.add(p9);
        User p10 = new User("丹丹");
        persons.add(p10);
        User p11 = new User("丹凤眼");
        persons.add(p11);
        User p12 = new User("哈哈");
        persons.add(p12);
        User p13 = new User("萌萌");
        persons.add(p13);
        User p14 = new User("蒙混");
        persons.add(p14);
        User p15 = new User("烟花");
        persons.add(p15);
        User p16 = new User("眼黑");
        persons.add(p16);
        User p17 = new User("许三多");
        persons.add(p17);
        User p18 = new User("程咬金");
        persons.add(p18);
        User p19 = new User("程哈哈");
        persons.add(p19);
        User p20 = new User("爱死你");
        persons.add(p20);
        User p21 = new User("阿莱");
        persons.add(p21);
    }

    /**
     * 重新排序获得一个新的List集合
     *
     * @param allNames
     */

    /**
     * 获取排序后的新数据
     *
     * @param persons
     * @return
     */
    public String[] sortIndex(List<User> persons) {
        TreeSet<String> set = new TreeSet<String>();
        // 获取初始化数据源中的首字母，添加到set中
        for (User person : persons) {
            set.add(StringHelper.getPinYinHeadChar(person.getUserName()).substring(
                    0, 1));
        }
        // 新数组的长度为原数据加上set的大小
        String[] names = new String[persons.size() + set.size()];
        int i = 0;
        for (String string : set) {
            names[i] = string;
            i++;
        }
        String[] pinYinNames = new String[persons.size()];
        for (int j = 0; j < persons.size(); j++) {
            persons.get(j).setPinYinName(
                    StringHelper
                            .getPingYin(persons.get(j).getUserName().toString()));
            pinYinNames[j] = StringHelper.getPingYin(persons.get(j).getUserName()
                    .toString());
        }
        // 将原数据拷贝到新数据中
        System.arraycopy(pinYinNames, 0, names, set.size(), pinYinNames.length);
        // 自动按照首字母排序
        Arrays.sort(names, String.CASE_INSENSITIVE_ORDER);
        return names;
    }

}
