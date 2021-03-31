import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainClass {
	public static void main(String args[]){
		System.out.println("Starting Extraction...");
		Document document;
		try {
			//CE
			//document = Jsoup.connect("https://www.flexmonster.com/scl-pricing/").get();
			
			//AE
			//document = Jsoup.connect("https://www.telerik.com/purchase.aspx?filter=web").get();
			
			//document = Jsoup.connect("https://www.flexmonster.com/saas-pricing/").get();
			
			
			//document = Jsoup.connect("https://www.netflix.com/signup/planform").get();
			//document = Jsoup.connect("https://asana.com/pricing").get();
			
			
			//document = Jsoup.connect("https://www.zoho.com/creator/pricing.html").get();
			//document = Jsoup.connect("https://workspace.google.com/intl/en_in/pricing.html").get();
			
			//document = Jsoup.connect("https://powerbi.microsoft.com/en-us/pricing/").get();
			
			document = Jsoup.connect("https://www.microsoft.com/en-in/microsoft-365/onedrive/compare-onedrive-plans?activetab=tab%3aprimaryr1").get();
			
			printTitle(document);

			//---------------------
			//Extraction Strategies
			//---------------------
			/*System.out.println("Validating " + TagExtraction.name + "...");
			if (TagExtraction.validate()) {
				System.out.println("Starting " + TagExtraction.name + "...");
				TagExtraction.extract(document);
				System.out.println("Ending " + TagExtraction.name + "...");
			}

			System.out.println("Validating " + CurrencyExtraction.name + "...");
			if (CurrencyExtraction.validate()) {
				System.out.println("Starting " + CurrencyExtraction.name + "...");
				CurrencyExtraction.extract(document);
				System.out.println("Ending " + CurrencyExtraction.name + "...");
			}

			System.out.println("Validating " + RegExNumberExtraction.name + "...");
			if (RegExNumberExtraction.validate()) {
				System.out.println("Starting " + RegExNumberExtraction.name + "...");
				RegExNumberExtraction.extract(document);
				System.out.println("Ending " + RegExNumberExtraction.name + "...");
			}*/
			
			//TelerikExtraction
			
			IMethodExtraction methodExtraction = new CurrencyExtraction();
			System.out.println("Validating " + methodExtraction.name() + "...");
			
			if (!methodExtraction.validate(document)) {
				System.out.println(methodExtraction.name() + " won't work for " + document.baseUri());
			} else {
				System.out.println("Starting " + methodExtraction.name() + "...");
				methodExtraction.extract(document);
				System.out.println("Ending " + methodExtraction.name() + "...");	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Ending Extraction...");
	}
	
	public static void printTitle(Document document) {
		//Get title
		String title = document.title();
		//Print title.
		System.out.println("Title : " + title);
		
		//System.out.println(document.title());
	}
}
