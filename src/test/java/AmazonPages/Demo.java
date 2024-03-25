package AmazonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize(); // Maximize the window after creating the driver
        driver.get("https://www.amazon.in/Apple-iPhone-13-128GB-Blue/dp/B09G9BL5CP/ref=sr_1_2?dib=eyJ2IjoiMSJ9.eFa-TvbcC_zjCq_5PD2KO7esruSMHK5ZeG6Ar_e-Gy5piRsfqUDXAr6MP3uGF_CaSp8NgwhVfCHN1-uQjjrrnFGTxX1dCeCx7HvzuG5k_-YmccaXuR4BWBbOBaSeaKeKIaRqd3HYYtEjKVD_vvX-QiVEjYlvUPlPsOkr1kKvPqx0HKtSvDpOeWUQSBkRxw14Mg97k2Z84Ju9PQsSJZuFZbquX5vq1tQ0ExZt_gaKoyw.ltKu8Cw2Vl_etQinkwxs3XZT6TP0clJFAeYD_roo71I&dib_tag=se&keywords=Apple+iPhone+13+%28128GB%29+-+Blue&qid=1708672744&sr=8-2");
        driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")).click();

	}

}
