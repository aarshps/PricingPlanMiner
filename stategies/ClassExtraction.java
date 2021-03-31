import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClassExtraction implements IMethodExtraction {
	@Override
	public String name() {
		return "Class Extraction";
	}
	
	@Override
	public boolean validate(Document document) {
		return true;
	}
	
	@Override
	public void extract(Document document) {
		System.out.println("---------------------------------------------------");
		//Elements price = document.select(".zsg-photo-card-price:contains($)"); //Get price
		//Elements address = document.select("span[itemprop]:contains(DenverCO)"); //Get address
		
		//FileOutputStream fout=new FileOutputStream("output_zillow.csv");  
		//PrintStream csv=new PrintStream(fout);  
		//csv.println("name	price	number sold");
		//for (int i=0; i < price.size()-2; i++) {
		//	csv.println(address.get(i).text() + "	" + price.get(i).text());
		//}
		//fout.close();
		
		Elements pricingElements = document.getElementsByClass("price");
		for (Element pricingElement : pricingElements) {
			System.out.println(pricingElement.toString());
			//System.out.println(pricingElement.parent().toString());
			
			Elements pricingElementSiblings = pricingElement.siblingElements();
			for (Element pricingElementSibling : pricingElementSiblings) {
				//System.out.println(pricingElementSibling.ownText());
				
				System.out.println(pricingElementSibling.toString());
			}
		}
		
		//Elements elements = document.getElementsByClass("price");
		System.out.println("---------------------------------------------------");
	}
}
