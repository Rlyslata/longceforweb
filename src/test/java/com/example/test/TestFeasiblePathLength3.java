/*
 *
 * 此文件由龙测科技(1.0)自动产生。
 *
 */

package com.example.test;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Listener.TestListener;
import fields.Elements;
import io.qameta.allure.*;
import core.BaseTest;

@Listeners({TestListener.class})
public class TestFeasiblePathLength3 extends BaseTest {

    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        driver.get("https://github.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void end() throws Exception {
        driver.quit();
    }

    @Story("流程1")
    @Feature("")
    @Description("")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "dp_1", dataProviderClass = DataProvider_479.class)
    public void testCase1(String inputid_891_0, String inputid_891_1)
            throws Exception {

        // 1. 首页面 --- click ---> sign in----->登陆页面
        dt.click(Elements.signIn_by, Elements.signIn);

        if (inputid_891_1 != null) {
            dt.inputText(Elements.passwd_by, Elements.passwd, inputid_891_1);
        }
        if (inputid_891_0 != null) {
            dt.inputText(Elements.account_by, Elements.account, inputid_891_0);
        }

        // 2. 登陆页面 --- click ---> login----->登陆成功页面
        dt.click(Elements.login_by, Elements.login);
        dt.click(Elements.headImage_by, Elements.headImage);

        // 3. 登陆成功页面 --- click ---> signout----->退出到登陆页面
        dt.click(Elements.signOut_by, Elements.signOut);
    }
}
