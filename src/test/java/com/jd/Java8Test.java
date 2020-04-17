package com.jd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: java8stream流分组group by查询
 * @CreateDate: 2020-02-11 22:59
 * @Author: wuhao
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Java8Test {



    public static void main(String[] args) {
        LinkedHashMap<String,String> hashMap = new LinkedHashMap(16,1,true);
        hashMap.put("1","111");
        hashMap.put("2","222");
        hashMap.put("3","333");
        hashMap.put("4","444");
        hashMap.put("5","555");

     /*   hashMap.get("1");
        hashMap.get("4");
        hashMap.get("4");
        hashMap.get("1");
        hashMap.get("1");*/

     hashMap.get("3");

        hashMap.forEach((k,v)-> System.out.println("k"+"--->"+v.toString())
        );


    }


    @Test
    public void test() {
        String msg = "大家好***, 我是吴昊, 我的班级是<三年级2班>, 我工作目前是996";
        MsgDto dto = new MsgDto(msg);
        FilterChain chain = new FilterChain();
        chain.add(new filterSymbol()).add(new filterHtml()).add(new filterNum());
        chain.doFilter(dto);
        System.err.println("---->"+dto.getMsg());
    }

}

class MsgDto{
    private String msg;

    public String getMsg(){
        return this.msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public MsgDto(String msg){
        super();
        this.msg = msg;
    }
}

interface Filter{
    boolean doFilter(MsgDto dt);
}

class filterSymbol implements Filter {

    @Override
    public boolean doFilter(MsgDto dto) {
        String str = dto.getMsg();
        str = str.replace("*","");
        dto.setMsg(str);
        return false;
    }
}

class filterHtml implements Filter {

    @Override
    public boolean doFilter(MsgDto dto) {
        String str = dto.getMsg();
        str = str.replace(">","");
        str = str.replace("<","");
        dto.setMsg(str);
        return true;

    }
}

class filterNum implements Filter {

    @Override
    public boolean doFilter(MsgDto dto) {
        String str = dto.getMsg();
        str = str.replace("996","995");
        dto.setMsg(str);
        return true;

    }
}

class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }

    public boolean doFilter(MsgDto dto){
        for (Filter filter :filters){
            if(!filter.doFilter(dto)){
                return false;
            }
        }
        return true;

    }

}