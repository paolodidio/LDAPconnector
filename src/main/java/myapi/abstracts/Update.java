package myapi.abstracts;

import java.util.List;
import java.util.Set;

import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.Uid;

public interface Update {
	
	//given the java identifier of an element and a list of attributes, update the entry
	public Uid update(String uid, Set<Attribute> attributes);
	
	//given a list of java identifiers and a list of attributes, update all the entries
	public List<String> updateList(List<String> uids, List<Attribute> attributeValues);
	
	//given a list of java identifiers and an attribute, update all the entries
	public List<String> updateList(List<String> uids, Attribute attr);
	
	public List<String> updateAllInteger(String attribute, int min);
	
}
