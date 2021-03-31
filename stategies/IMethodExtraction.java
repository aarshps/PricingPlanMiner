import org.jsoup.nodes.Document;

public interface IMethodExtraction {
	public String name();
	
	public boolean validate(Document document);
	
	public void extract(Document document);
}
