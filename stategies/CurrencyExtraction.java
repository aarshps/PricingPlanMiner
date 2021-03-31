import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CurrencyExtraction implements IMethodExtraction {
	@Override
	public String name() {
		return "Currency Extraction"; 
	}
	
	@Override
	public boolean validate(Document document) {
		try {
			extract(document);
		}
		catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	@Override
	public void extract(Document document) {
		System.out.println("---------------------------------------------------");
		
		/*Elements dollarElements = document.getElementsContainingOwnText("$");
		
		for (Element element : dollarElements) {
			//if (!(element.childNodeSize() > 0)) {
			print(element.toString());
			//}
		}
		
		for (Element element : elements) {
			Node childNode = element.childNodes().get(2);
			print(childNode.toString());
		}*/
		
		Elements dollarElements = document.getElementsContainingOwnText("₹");
				//"\\u20B9");
				//"$");
		
		//print("\\u20B9");
		
		for (Element dollarElement : dollarElements) {
			//print(dollarElement.ownText());
			
			Element amountElement = dollarElement.parent();
			//print(amountElement.ownText());
			
			Element planElement = amountElement.firstElementSibling();
			//print(planElement.ownText());
			
			//System.out.println(dollarElement.ownText());
			System.out.println(planElement.ownText() + " : " + dollarElement.ownText() + amountElement.ownText());
		}

		System.out.println("---------------------------------------------------");
	}
}
