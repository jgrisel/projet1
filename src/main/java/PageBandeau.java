import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageBandeau {
	
	// onglet principal du Bandeau 
	
	@FindBy (xpath="//button[contains(text(),\"Calendrier\")]")
	WebElement Onglet_Calendrier;
	
	@FindBy (xpath="//button[contains(text(),\"Ressources\")]")
	WebElement Onglet_Ressources;
	
	@FindBy (xpath="//button[contains(text(),\"Co�t\")]")
	WebElement Onglet_Co�t;
	
	@FindBy (xpath="//button[contains(text(),\"Config\")]")
	WebElement Onglet_Configuration;
	
	@FindBy (xpath="//button[contains(text(),\"Communication\")]")
	WebElement Onglet_Communications;
	
	@FindBy (xpath="//button[contains(text(),\"Rapport\")]")
	WebElement Onglet_Rapports;
	
	@FindBy (xpath="//button[contains(text(),\"Zone\")]")
	WebElement Onglet_ZonePersonnelle;

}
