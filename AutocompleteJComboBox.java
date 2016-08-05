//using method found on http://www.algosome.com/articles/java-jcombobox-autocomplete.html
package HHAPackage;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AutocompleteJComboBox extends JComboBox{

	private static final long serialVersionUID = 4321422L;
	
	private final Searchable<String,String> searchable;

	public AutocompleteJComboBox(Searchable<String,String> s){
		super();
		this.searchable = s;
		setEditable(true);
		Component c = getEditor().getEditorComponent();

		if ( c instanceof JTextComponent ){
			final JTextComponent tc = (JTextComponent)c;
			tc.getDocument().addDocumentListener(new DocumentListener(){

				public void changedUpdate(DocumentEvent arg0) {}

				public void insertUpdate(DocumentEvent arg0) {
					update();
				}

				public void removeUpdate(DocumentEvent arg0) {
					update();
				}

				public void update(){
					SwingUtilities.invokeLater(new Runnable(){
						@SuppressWarnings("unchecked")

						public void run() {
							ArrayList<String> founds = new ArrayList<String>(searchable.search(tc.getText()));
							Set<String> foundSet = new HashSet<String>();

							for ( String s : founds ){
								foundSet.add(s.toLowerCase());
							}
							Collections.sort(founds);

							setEditable(false);
							removeAllItems();

							if ( !foundSet.contains( tc.getText().toLowerCase()) ){
								addItem( tc.getText() );
							}

							for (String s : founds) {
								addItem(s);
							}
							setEditable(true);
							setPopupVisible(true);
							tc.requestFocus(); 
						}
					});
				}
			});
			tc.addFocusListener(new FocusListener(){

				public void focusGained(FocusEvent arg0) {
					if ( tc.getText().length() > 0 ){
						setPopupVisible(true);
					}
				}
				public void focusLost(FocusEvent arg0) {}
			});
		}
		else{
			throw new IllegalStateException("Editing component is not a JTextComponent!");
		}
	}
}


