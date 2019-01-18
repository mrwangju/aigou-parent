package cn.miswng;

import org.junit.Test;

public class test {
    @Test
    public void test(){
        String ids="\"ids\":\"1,2,3\"";
        String substring = ids.substring(ids.indexOf(":"));
        String substring1 = substring.substring(substring.indexOf("\"")+1, substring.lastIndexOf("\""));
        String[] allid= substring1.split(",");
        Long[] idall =new Long[allid.length];
        for(int i=0;i<allid.length;i++){
           Long s=Long.parseLong(allid[i]);
            idall[i]=s;
        }
        for (Long aLong : idall) {
            System.out.println(aLong);
        }
        //brandService.deleteAll(idall);
    }
}
