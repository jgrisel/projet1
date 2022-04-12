
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageListeCalendrier extends PageBandeau {
	
	public PageListeCalendrier(WebDriver driver) {
		super(driver);
		
	}
	
	// Web element
	
		@FindBy (xpath="/html/body/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div[1]/div[3]/span/table/tbody/tr[2]/td[2]")
		WebElement Cr�er_button;
		
		
		@FindBy(xpath = "//div[contains(text(),\"Liste de calendriers\")]")
	    public WebElement Titre_Liste_Calendrier;
		
		@FindBy(xpath = "//div[contains(text(),\"Nom\")]")
	    public WebElement Colonne_Nom;
		
		@FindBy(xpath = "//div[contains(text(),\"H�rit� de la date\")]")
	    public WebElement Colonne_H�rit�_Date;
		
		@FindBy(xpath = "//div[contains(text(),\"H�ritages � jour\")]")
	    public WebElement Colonne_H�ritages_A_Jour;
		
		@FindBy(xpath = "//div[contains(text(),\"Op�rations\")]")
	    public WebElement Colonne_Op�rations;
		
		@FindBy(xpath = "//span[@class=\"z-dottree-ico z-dottree-firstspacer\"]/following-sibling::span[contains(text(),\"Calendrier - Test 1\")]")
	    public WebElement Calendrier_Test_1;
		
		@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div[1]/div[3]/div/div[3]/table/tbody[2]/tr[1]/td[4]/div/span[1]/table/tbody/tr[2]/td[2]/img")
	    public WebElement Cr�er_d�rive_button;
		
		@FindBy(xpath = "//span[@class=\"z-dottree-line z-dottree-last\"]/following-sibling::span[contains(text(),\"Calendrier - Test Calendrier D�riv�\")]")
	    public WebElement Calendrier_d�rive_test_1;
		
		@FindBy(xpath = "//span[@class=\"z-dottree-ico z-dottree-root-open\"]")
	    public WebElement Minus_button;
		
		@FindBy(xpath = "//span[@class=\"z-dottree-ico z-dottree-root-close\"]")
	    public WebElement Minus_button_close;
		
		@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div[1]/div[3]/div/div[3]/table/tbody[2]/tr[1]/td[4]/div/span[2]/table/tbody/tr[2]/td[2]/img")
	    public WebElement Copy_button;
		
		@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/table/tbody/tr/td/table/tbody/tr[5]/td/div/span")
	    public WebElement Message_test_enregistr�;
		
		@FindBy(xpath = "//span[@class=\"z-dottree-ico z-dottree-firstspacer\"]/following-sibling::span[contains(text(),\"Calendrier - Test 2\")]")
	    public WebElement Calendrier_test_2;
		
		@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div[1]/div[3]/div/div[3]/table/tbody[2]/tr[1]/td[4]/div/span[4]/table/tbody/tr[2]/td[2]/img")
	    public WebElement Supprimer_button_calendrier_1;
		
		@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div[1]/div[3]/div/div[3]/table/tbody[2]/tr[2]/td[4]/div/span[4]/table/tbody/tr[2]/td[2]/img")
	    public WebElement Supprimer_button_d�rive_calendrier_1;
		
		@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div[1]/div[3]/div/div[3]/table/tbody[2]/tr[3]/td[4]/div/span[4]/table/tbody/tr[2]/td[2]/img")
	    public WebElement Supprimer_button_calendrier_2;
		
		@FindBy(xpath = "//td[contains(text(),\"OK\")]")
	    public WebElement OK_button_supression;
		
		@FindBy(xpath = "//span[contains(text(),'Suppression du calendrier \"Calendrier - Test 2\"')]")
	    public WebElement Message_supression_test_2;
		
		@FindBy(xpath = "//span[contains(text(),'Suppression du calendrier \"Calendrier - Test 1\"')]")
	    public WebElement Message_supression_test_1;
		
		@FindBy(xpath = "//span[contains(text(),'Suppression du calendrier \"Calendrier - Test Calendrier D�riv�\"')]")
	    public WebElement Message_supression_test_d�riv�;
		
		
		
		//fonction pour acc�der � la page de cr�ation des calendriers
		public PageCreationCalendrier clicCreerCalendrier(WebDriver driver) {
		Cr�er_button.click();
		return PageFactory.initElements(driver, PageCreationCalendrier.class);
		}
		
		//fonction pour cr�er une d�rive
		public void CreerD�rive(WebDriver driver) {
		Cr�er_d�rive_button.click();		
		}
		
		//fonction pour cliquer sur le bouton "moins"
		public void Minusbuttonclick(WebDriver driver) {
			Minus_button.click();		
			}
		
	//fonction pour creer une copie d'un calendrier
		public void Copybuttonclick(WebDriver driver) {
			Copy_button.click();		
			}
		
	//fonction pour supprimer calendrier 1 et 2
		public void Supprimerbuttonclick(WebDriver driver) {
			Supprimer_button_calendrier_2.click();
			OK_button_supression.click();
			Supprimer_button_d�rive_calendrier_1.click();
			OK_button_supression.click();
			Supprimer_button_calendrier_1.click();
			OK_button_supression.click();
			}

}
