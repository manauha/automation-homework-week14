package resources.testdata;

import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider(name = "loginDetails")
    public Object[][] getLoginData() {
        Object[][] details = new Object[][]{
                {"Admin","admin123"}
        };
        return details;
    }

    @DataProvider(name = "loginDetails1")
    public Object[][] getLoginData1() {
        Object[][] details1 = new Object[][]{
                {"","", "Required"},
                {"test123@gmail.com","", "Required"},
                {"","test123", "Required"},
                {"test123@gmail.com","test123", "Required"},
        };
        return details1;
    }
}
