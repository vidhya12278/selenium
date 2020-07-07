package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Maintaing {

@DataProvider(name="search")
public static  Object[][] data()
{
return new Object[][] {
{"sling bag for girls"},
{"laptop bags for women"}
};
}
}
