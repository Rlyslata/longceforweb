package com.dt.web;

/*此测试工具系龙测科技（北京）有限公司独立开发软件，龙测科技（北京）有限公司依法独立享有该软件之 所有权利，此软件为商业软件提供付费使用。该软件使用者（含个人、法人或其它组织）：
 *
 1. 非经龙测科技（北京）有限公司授权许可，不得将之用于盈利或非盈利性的任何用途。
 2. 使用该软件必须保留龙测科技的版权声明，将该软件从原有自然语言文 字转换成另一自然语言文字的，仍应注明出处，并不得向任何第三方提供修改后的软件。
 3. 不得有其他侵犯龙测科技软件版权之行为。

   凡有上述及其他侵权行为的个人、法人或其它组织，必须立即停止侵权并对其侵权造成的一切不良后果承担全部责任。对此前，尤其是此后侵犯龙测科技版权的行为，
   龙测科技将依据《著作权法》、《计算机软件保护条例》 等相关法律、法规追究其经济责任和法律责任。
*/


import com.dt.model.LocationElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 简述: 龙测科技提供的Helper类
 */
public class DtTestCase {
    public static Logger logger = Logger.getLogger(DtTestCase.class);
    private final static String TAG = "DragonTesting";
    private WebDriver driver;
    private boolean acceptNextAlert = true;


    /**
     * 简述: 构造函数
     *
     * @param driver 关联的ActivityInstrumentationTestCase2实例
     */
    public DtTestCase(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * 方法的简述: 定位View
     *
     * @param locationElement  定位元素封装类
     * @return null 或者 找到的view
     */
    public WebElement findView(LocationElement locationElement) {
        return this.findView(locationElement.getUi(), locationElement.getText(), locationElement.getUiclass(), locationElement.getClassIndex(),locationElement.getCss());
    }


    /**
     * 方法的简述: 定位View
     *
     * @param id        根据ID定位View
     * @param text      根据Text定位View
     * @param viewclass 根据Class:Index定位View
     * @param index     配合class
     * @param css       配合css定位View
     * @return null 或者 找到的view
     */
    public WebElement findView(String id, String text, String viewclass, String index,String css) {
        WebElement v = null;

        if (!id.isEmpty()) {
            try {
                v = (WebElement)driver.findElement(By.id(id));
                return v;
            } catch (Exception error) {
                System.out.println("找不到 id=  " + text);
            }
        }

        if (!text.isEmpty()) {
            try {
                v = (WebElement)driver.findElement(By.name(text));
                return v;
            } catch (Exception error) {
                System.out.println("找不到 text=  " + text);
            }
        }

        if (!viewclass.isEmpty() && !index.isEmpty()) {
            int num = -1;
            try {
                num = Integer.parseInt(index);
            } catch (Exception e) {
                System.out.println("找不到 index=  " + index);
                return v;
            }

            List<?> viewList = driver.findElements(By.className(viewclass));
            if (viewList == null || (viewList.size() <= num)) {
                System.out.println("index 非法  " + index);
                return v;
            }
            return (WebElement) viewList.get(num);
        }
        if (!css.isEmpty()) {
            try {
                v = (WebElement)driver.findElement(By.cssSelector(css));
                return v;
            } catch (Exception error) {
                System.out.println("找不到 css=  " + css);
            }
        }
        return v;
    }
    public WebElement findView(String id, String text, String viewclass, String index) {
        WebElement v = null;

        if (!id.isEmpty()) {
            try {
                v = (WebElement)driver.findElement(By.id(id));
                return v;
            } catch (Exception error) {
                System.out.println("找不到 id=  " + text);
            }
        }

        if (!text.isEmpty()) {
            try {
                v = (WebElement)driver.findElement(By.name(text));
                return v;
            } catch (Exception error) {
                System.out.println("找不到 text=  " + text);
            }
        }

        if (!viewclass.isEmpty() && !index.isEmpty()) {
            int num = -1;
            try {
                num = Integer.parseInt(index);
            } catch (Exception e) {
                System.out.println("找不到 index=  " + index);
                return v;
            }

            List<?> viewList = driver.findElements(By.className(viewclass));
            if (viewList == null || (viewList.size() <= num)) {
                System.out.println("index 非法  " + index);
                return v;
            }
            return (WebElement) viewList.get(num);
        }
        return v;
    }




    /**
     * 方法的简述: 打开网页
     * @param website 网址
     */
    public void get(String website) {
        this.driver.get(website);
        return;
    }


    /**
     * 方法的简述: 使用xpath直接定位，其他输入报错
     * @param webview 中文文字或
     * @return null:没找到； By: 找到
     */
    public WebElement findWebView(String webview) {
        if (!webview.isEmpty()) {
            return driver.findElement(By.xpath(webview));
        }
        return null;
    }

    /**
     * 方法的简述: 把数字变为元素数组
     *
     * @param n 数字
     * @return 元素数组
     */
    private ArrayList<Integer> getDigitList(long n) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        // Get each digit
        while (n > 0) {
            list.add((int) (n % 10));
            n = n / 10;
        }

        return list;
    }

    /**
     * 获取手机屏幕的宽度
     * @return
     */
    public int getScreenWidth()
    {
        return driver.manage().window().getSize().width;
    }

    /**
     * 获取手机屏幕的高度
     * @return
     */
    public int getScreenHeight()
    {
        return driver.manage().window().getSize().height;
    }

    /**
     * 查找控件
     *
     * @param locateWay
     * @param locateValue
     * @return
     */
    public WebElement findView(String locateWay, String locateValue) {

        WebElement element = null;
        try {
            Thread.sleep(1000);

            if (locateWay.equalsIgnoreCase("ID")) {
                return driver.findElement(By.id(locateValue));

            } else if (locateWay.equalsIgnoreCase("CLASS_NAME")) {
                String[] value1 =locateValue.split(":");
                List<?> viewList = driver.findElements(By.className(value1[0]));
                int num=Integer.valueOf(value1[1]);
                element = (WebElement) viewList.get(num);
                return element;

            } else if (locateWay.equalsIgnoreCase("CSS_SELECTOR")) {
                return driver.findElement(By.cssSelector(locateValue));

            } else if (locateWay.equalsIgnoreCase("LINK_TEXT")) {
//                element = driver.findElement(By.linkText(locateValue));
                return driver.findElement(By.linkText(locateValue));

            } else if (locateWay.equalsIgnoreCase("NAME")) {
//                element = driver.findElement(By.name(locateValue));
                return driver.findElement(By.name(locateValue));

            } else if (locateWay.equalsIgnoreCase("PARTIAL_LINK_TEXT")) {
//                element = driver.findElement(By.partialLinkText(locateValue));
                return driver.findElement(By.partialLinkText(locateValue));

            } else if (locateWay.equalsIgnoreCase("TAGNAME")) {
//                element = driver.findElement(By.tagName(locateValue));
                return driver.findElement(By.tagName(locateValue));

            } else if (locateWay.equals("XPATH")) {
//                element = driver.findElement(By.xpath(locateValue));
                return driver.findElement(By.xpath(locateValue));

            }  else {
                logger.error("定位方式：" + locateWay + "不被支持");
                Assert.fail("定位方式：" + locateWay + "不被支持");
                element = null;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw e;
        }
        System.out.println("element" + element);
        return element;

    }

    public void click(String locateWay, String locateValue) {
        try {
            findView(locateWay, locateValue).click();
            logger.info("通过" + locateWay + "方式定位到元素：" + locateValue+ "点击：");
        } catch (Exception e) {
            logger.error("未通过" + locateWay + "方式定位到元素：" + locateValue);
        }
    }

    public void inputText(String locateWay, String locateValue,String text){
        try {
            findView(locateWay, locateValue).sendKeys(text);
            logger.info("通过" + locateWay + "方式定位到元素：" + locateValue + "输入值："+text);
        } catch (Exception e) {
            logger.error("未通过" + locateWay + "方式定位到元素：" + locateValue);
        }

    }


    public void assertDtEquals(String locateWay,String locateValue,String expect) throws Exception {
        String actual = findView(locateWay,locateValue).getText();
//        assert actual.equals(expect);
        try {
            assert actual.equals(expect);
        }
        catch (AssertionError e){
            logger.error("实际值："+actual+" ; 期望值："+expect);
            Assert.fail("实际值："+actual+" ; 期望值："+expect);
            throw e;
        }

    }



    public void assertDtContain(String locateWay,String locateValue,String expect) throws Exception{
        String actual = findView(locateWay,locateValue).getText();
        try {
            assert (actual.contains(expect));
        }
        catch (AssertionError e){
            logger.error("实际值："+actual+" ; 期望值："+expect);
            Assert.fail("实际值："+actual+" ; 期望值："+expect);
            throw e;
        }

    }

    public void dbClick(String locateWay,String locateValue) throws Exception{
        Actions actiondb = new Actions(driver);
        WebElement test1item = findView(locateWay,locateValue);
        actiondb.doubleClick(test1item).perform();
    }

    /**
     * 键盘回车
     *
     */
    public void carriageReturn(){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
    }

    /**
     * 鼠标右击
     *
     * @param locateWay 定位方式
     * @param locateValue 定位值
     */
    public void rightClick(String locateWay,String locateValue) throws Exception{
        Actions actiondb = new Actions(driver);
        WebElement test1item = findView(locateWay,locateValue);
        actiondb.contextClick(test1item).perform();
    }
    public void clickRight(String locateWay,String locateValue) throws Exception{
        Actions actiondb = new Actions(driver);
        WebElement test1item = findView(locateWay,locateValue);
        actiondb.contextClick(test1item).perform();
    }

    public void longPress(String locateWay,String locateValue) throws Exception{
        Actions actiondb = new Actions(driver);
        WebElement test1item = findView(locateWay,locateValue);
        actiondb.clickAndHold(test1item).perform();

    }

    //fixme 需要左滑动和右滑动的js代码
    public void swipe(String way){
        try {
            if (way == "UP"){
                String js="window.scrollTo(0,document.body.scrollHeight)";
                ((JavascriptExecutor) driver).executeScript(js);
            }
            else if (way == "DWON"){
                String js = "window.scrollTo(0,0)";
                ((JavascriptExecutor) driver).executeScript(js);
            }

        }
        catch (Exception e){

        }

    }

    public void drag_and_drop(String locateWay,String locateValue,String locateWay1,String locateValue1){
        WebElement web_element_source = findView(locateWay, locateValue);
        WebElement web_element_target = findView(locateWay1, locateValue1);
        Actions actiondb = new Actions(driver);
        actiondb.dragAndDrop(web_element_source,web_element_target).perform();

    }

    public void sleep(int second) throws InterruptedException {
        Thread.sleep(second);
    }
    /**
     * 切换至frame,
     *@param name frame id name
     */
    public void frame(String name) {
        driver.switchTo().frame(name);
    }

    /**
     * 切换至frame,
     *@param index frame的 index
     */
    public void frame(int index) {
        driver.switchTo().frame(index);
    }

    /**
     * 切换至frame,再切换回主文档
     *
     */
    public void frame2Default() {
        driver.switchTo().defaultContent();
    }

    public void window() throws InterruptedException {
        sleep(3000);
        Set<String> handles = driver.getWindowHandles();
//        for (String str : handles) {
//            System.out.println("===="+str);
//            driver.switchTo().window(str);
//        }
        System.out.println(handles);
        Iterator<String> i = handles.iterator();
        while (i.hasNext()) {
            driver.switchTo().window(i.next());
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


}