import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageBandeau {
	
public WebDriver driver;
	
	public PageBandeau(WebDriver driver) {
		this.driver=driver;
	}
	
	//onglet principal du Bandeau 
	
	@FindBy (xpath="//button[contains(text(),\"Calendrier\")]")
	WebElement Onglet_Calendrier;
	
	@FindBy (xpath="//button[contains(text(),\"Ressources\")]")
	WebElement Onglet_Ressources;
	
	@FindBy (xpath="//button[contains(text(),\"Coût\")]")
	WebElement Onglet_Coût;
	
	@FindBy (xpath="//button[contains(text(),\"Config\")]")
	WebElement Onglet_Configuration;
	
	@FindBy (xpath="//button[contains(text(),\"Communication\")]")
	WebElement Onglet_Communications;
	
	@FindBy (xpath="//button[contains(text(),\"Rapport\")]")
	WebElement Onglet_Rapports;
	
	@FindBy (xpath="//button[contains(text(),\"Zone\")]")
	WebElement Onglet_ZonePersonnelle;
	
	//item de l'onglet Ressources
	
	@FindBy (xpath="//a[@href=\"/libreplan/calendars/calendars.zul\"]")
	WebElement Item_Calendrier;
	
	
	//fonction pour accéder à la page de liste des calendriers
	public PageListeCalendrier clicItemCalendrier(WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//button[contains(text(),\"Ressources\")]")))
		.moveToElement(driver.findElement(By.xpath("//a[@href=\"/libreplan/calendars/calendars.zul\"]"))).click().build().perform();
		return PageFactory.initElements(driver, PageListeCalendrier.class);
		}
	
	public boolean verifPage(WebElement nomWebEl) {
        boolean verif;
        if (nomWebEl.isDisplayed()) {
            verif = true;
        } else {
            verif = false;
        }
        return verif;
    }
}
