package HHAPackage;

import java.util.Collection;

public interface Searchable<X, Y>{

	public Collection<X> search(Y value);


}
