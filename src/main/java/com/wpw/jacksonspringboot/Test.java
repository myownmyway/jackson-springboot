package com.wpw.jacksonspringboot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wpw.jacksonspringboot.entity.User;
import com.wpw.jacksonspringboot.util.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wpw
 */
public class Test {
    public static void main(String[] args) {
        User user = User.builder().id(1).userName("zhangSan").passWord("123456").build();
        String object2String = JsonUtil.object2String(user);
        System.out.println("object2String = " + object2String);
        Map<String, List<Integer>> map = new HashMap<>(16, 0.75f);
        map.put("a", Stream.of(1, 3, 5, 7, 9).collect(Collectors.toList()));
        map.put("b", Stream.of(2, 4, 6, 8, 10).collect(Collectors.toList()));
        String string = JsonUtil.object2String(map);
        System.out.println("string = " + string);
        String stringPretty = JsonUtil.obj2StringPretty(user);
        System.out.println("stringPretty = " + stringPretty);
        String obj2StringPretty = JsonUtil.obj2StringPretty(map);
        System.out.println("obj2StringPretty = " + obj2StringPretty);
        String json = "{\"id\":1,\"userName\":\"zhangSan\",\"passWord\":\"123456\"}";
        User u = JsonUtil.string2Obj(json, User.class);
        System.out.println("u = " + u);
        String jsonMap = "{\"a\":[1,3,5,7,9],\"b\":[2,4,6,8,10]}";
        Map obj = JsonUtil.string2Obj(jsonMap, Map.class);
        System.out.println("obj = " + obj);
        obj.entrySet().forEach(x -> System.out.println(x));
        List<User> userList = new ArrayList<>(10);
        userList.add(User.builder().id(1).userName("test").passWord("123456").build());
        userList.add(User.builder().id(2).userName("test2").passWord("123456").build());
        System.out.println(JsonUtil.object2String(userList));
        List list = JsonUtil.string2Obj("[{\"id\":1,\"userName\":\"test\",\"passWord\":\"123456\"},{\"id\":2,\"userName\":\"test2\",\"passWord\":\"123456\"}]", List.class);
        System.out.println("list = " + list);
        String s = JsonUtil.object2String(userList);
        System.out.println(JsonUtil.string2Obj(s, new TypeReference<List<User>>() {
        }));
        Object o = JsonUtil.string2Obj(s, List.class, User.class);
        System.out.println("o = " + o);
    }
}
