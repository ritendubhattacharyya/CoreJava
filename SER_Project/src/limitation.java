import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class limitation extends PlainDocument {
	
	private int limit;
	
	public limitation(int limits)
	{
		this.limit = limits;
	}
	public void insertString(int offset, String str , AttributeSet set) throws BadLocationException
	{
		if(str == null)
		{
			return;
		}
		else if((getLength() + str.length()) <= limit)
		{
			str = str.toUpperCase();
			super.insertString(offset, str, set);
		}
	}
}
