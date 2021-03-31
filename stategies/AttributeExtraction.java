import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AttributeExtraction implements IMethodExtraction {
	@Override
	public String name() {
		return "Attribute Extraction";
	}

	@Override
	public boolean validate(Document document) {
		return true;
	}

	@Override
	public void extract(Document document) {
		System.out.println("---------------------------------------------------");
		
		Elements tableElements = document.select("table");
		for (Element tableElement : tableElements) {
			//System.out.println("\n\n\n\n\n\n" + tableElement.toString() + "\n\n\n\n\n\n");
			Elements rowElements = tableElement.select("tr");
			for (int i = 0; i < rowElements.size(); i++) { //first row is the col names so skip it.
			    Element row = rowElements.get(i);
			    boolean hasAttr = false;
			    
			    for (Attribute rowAttr : row.attributes()) {
			    	//System.out.println(rowAttr.toString());
			    	/*if (rowAttr.toString() == "class=\"Pricings-name\"") {
			    		hasAttr = true;
			    	}*/
			    	if (rowAttr.toString().contains("Pricings") && 
			    			(rowAttr.toString().contains("name") ||
			    			rowAttr.toString().contains("value"))) {
			    		hasAttr = true;
			    	}
			    }
			    
			    /*if (!row.hasAttr("class=\"Pricings-name\"")) {
			    	continue;
			    }*/
			    
			    if (!hasAttr) {
			    	//System.out.println("No attribute");
			    	continue;
			    }
			    
			    //System.out.println(row.toString());
			    //Elements cols = row.select("td");
			    Elements cols = row.select("td,th");
			    //System.out.println("No of columns : " + cols.size());
			    for (Element col : cols) {
			    	/*if (col.siblingIndex() == 0) {
			    		
			    	}*/
			    	if (!TextValidator.IsPlanName(col.text())) {
			    		continue;
			    	}
					System.out.print("" 
							//+ col.elementSiblingIndex() 
							+ col.text() + "\t");
			    	//System.out.println(col.text());
				}
			    System.out.println();
			    /*if (cols.get(7).text().equals("down")) {
			        downServers.add(cols.get(5).text());
			    }*/
			}
		}
		
		System.out.println("---------------------------------------------------");
	}
}
