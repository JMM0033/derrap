package Controlador;

import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class JTextFieldLimit extends PlainDocument {
  /**
	 * 
	 */
	//Clase importada de internet, hablado contigo en persona
	private static final long serialVersionUID = 1L;

	private int limit;

  
	public JTextFieldLimit(int limit) {
		super();
		this.limit = limit;
		}

  public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
    if (str == null) 
    	return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}