import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RegExNumberExtraction implements IMethodExtraction {
	@Override
	public String name() {
		return "RegExNumber Extraction";
	}
	
	@Override
	public boolean validate(Document document) {
		return true;
	}
	
	@Override
	public void extract(Document document) {
		System.out.println("---------------------------------------------------");
		
		Elements priceCandidateElements = document.getElementsMatchingOwnText("\\d+(\\.\\d*)?|\\.\\d+");
		for (Element element : priceCandidateElements) {
			//System.out.println("String : " + element.toString());
			System.out.println(element.ownText());
			System.out.println();
		}
		
		System.out.println("---------------------------------------------------");
	}
}
