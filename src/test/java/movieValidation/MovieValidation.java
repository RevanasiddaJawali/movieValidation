package movieValidation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MovieValidation {

@Test
public  void movieValidation() {
	System.setProperty("webdriver.chrome.driver", "D:\\selenium downloads\\chromedriver.exe");
	 ChromeDriver driver= new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
     String countryInWiki = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[5]/div[1]/table[1]/tbody/tr[14]/td")).getText();
     String releaseDateInWiki = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[5]/div[1]/table[1]/tbody/tr[12]/td/div/ul/li")).getText();

      driver.navigate().to("https://www.imdb.com/title/tt9389998/releaseinfo?ref_=tt_ql_sm");
      String countryInImdb = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[1]/div[1]/div[2]/table[1]/tbody/tr[6]/td[1]/a")).getText();
      String releaseDateInImdb = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[1]/div[1]/div[2]/table[1]/tbody/tr[6]/td[2]")).getText();
    
      if (countryInWiki.equals(countryInImdb) && releaseDateInWiki.equals(releaseDateInImdb)) {
		System.out.println("Both country name and release date are same in both source");
	}
      driver.close();
}
}
