package po;
import locator.BasePageLocator;
import org.openqa.selenium.By;

import javax.xml.soap.Text;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CategoryPage  {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        System.out.println("Hello");
        WebDriver obj = new ChromeDriver();

        //obj.get("https://www.ishopping.pk/electronics.html");         1
        //String actualString = obj.findElement(By.cssSelector(".category138")).getText();
        //assertTrue(actualString.contains("ELECTRONICS"));
        //obj.close();

        //obj.get("https://www.ishopping.pk/women-s-store.html");       2
        //String actualString = obj.findElement(By.cssSelector(".category1225")).getText();
        //assertTrue(actualString.contains("WOMEN'S STORE"));
        //obj.close();

        //obj.get("https://www.ishopping.pk/mens-store.html");         3
        //String actualString = obj.findElement(By.cssSelector(".category166")).getText();
        //assertTrue(actualString.contains("MEN'S STORE"));
        //obj.close();

        //obj.get("https://www.ishopping.pk/health-beauty.html");       4
       // String actualString = obj.findElement(By.cssSelector(".category15514")).getText();
       // assertTrue(actualString.contains("HEALTH & BEAUTY"));
        //obj.close();

        obj.get("https://www.ishopping.pk/office-media.html");
        String actualString = obj.findElement(By.cssSelector(".category1227")).getText();
        assertTrue(actualString.contains("OFFICE & MEDIA"));
        obj.close();

        //obj.get("https://www.ishopping.pk/kids-store.html");        6
        // String actualString = obj.findElement(By.cssSelector(".category1226")).getText();
        //assertTrue(actualString.contains("KIDS STORE"));
        //obj.close();

        //obj.get("https://www.ishopping.pk/home-and-living.html");
        // String actualString = obj.findElement(By.cssSelector(".category662")).getText();
        //assertTrue(actualString.contains("HOME & LIVING"));
       // obj.close();

       // obj.get("https://www.ishopping.pk/books.html");
       // String actualString = obj.findElement(By.cssSelector(".category5416")).getText();
       // assertTrue(actualString.contains("BOOKS & STATIONERY"));
        //obj.close();


    }

    private static void assertFalse(boolean contains) {
    }

    private static void assertTrue(boolean electronics) {
    }


}