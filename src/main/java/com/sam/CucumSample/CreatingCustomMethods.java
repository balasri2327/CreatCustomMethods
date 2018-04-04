package com.sam.CucumSample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingCustomMethods {
	static WebDriver driver;
	public static void main(String[] args) {
		goTOMethod("9");
	}
	public static void goTOMethod(String pageNumber) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\automation testing tools\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=AXvEWpm3J5SErAGOhrOAAg");
		WebElement findElement = driver.findElement(By.id("lst-ib"));
		findElement.sendKeys("apple iphone x",Keys.ENTER);
		List<WebElement> parent = driver.findElements(By.xpath("//tr[@valign='top']"));
		for(int i=0;i<parent.size();i++) {
		List<WebElement> child = parent.get(i).findElements(By.tagName("td"));
		for(int j=0;j<child.size();j++) {
			List<WebElement> findElements = child.get(j).findElements(By.tagName("a"));
			for(int k=0;k<findElements.size();k++) {
				String actualPage = findElements.get(i).getText();
				if(actualPage.equals(pageNumber)) {
					findElements.get(k).click();
				}
				

			}
		}
		
		
	}
	
}
}