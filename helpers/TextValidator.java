
public class TextValidator {
	public static boolean IsPlanName(String text) {
		if (text.toLowerCase().contains("products")) {
			return false;
		}
		
		return true;
	}
}
