package HHAPackage;


import java.util.ArrayList;
import java.util.Collection;


public class StringSearchable implements Searchable<String,String>{

	private ArrayList<String> terms = new ArrayList<String>();

	public StringSearchable(ArrayList<String> terms){
		this.terms.addAll(terms);
	}

	public Collection<String> search(String value) {
		ArrayList<String> founds = new ArrayList<String>();

		for ( String s : terms ){
			if ( s.indexOf(value) == 0 ){
				founds.add(s);

			}
		}
		return founds;
	}
}
