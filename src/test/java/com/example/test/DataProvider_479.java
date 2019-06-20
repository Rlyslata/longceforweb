/* 
 *
 * 此文件由龙测科技(1.0)自动产生。
 *
 */

package com.example.test;
import org.testng.annotations.*;
import java.lang.reflect.Method;

public class DataProvider_479 {
    public static void dpcall(String m) throws Exception {
        Class<?> c = Class.forName("com.example.test.DataProvider_479");
        Object obj = c.newInstance();
        Method method = c.getMethod(m);
        method.invoke(obj);
    }

    // 输入组0. { id=891 groupName=登陆成功输入组 associatedAssertionId=N/A}
    // 输入元素1.登陆页面+账号={Rlyslata }
    // 输入元素2.登陆页面+密码={a387712a }

    @DataProvider(name = "dp_1")
    public Object[][] dp_1() {
        return new Object[][]{{"Rlyslata", "a387712a"}};
    }
}
