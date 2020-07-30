package myapi.abstracts;

import java.util.List;

public interface Search {

	//interface that will be implemented by the search classes
	// of all object class (AccountSearch, GroupSearch, OrganizationSearch etc..)
	
	//default search method where you need to write the whole filter, overloaded with custom pageSize
	public List<String> search(boolean equals,String filter);
	public List<String> search(boolean equals,String filter, int pageSize);

	//SearchALLOccurences**** search method where you need to write the attribute you want to search for any value, overloaded with custom pageSize
	//this will print the whole rows, overloaded with pageSize
	public List<String> searchAllOccurrences(boolean equals,String attribute);
	public List<String> searchAllOccurrences(boolean equals,String attribute, int pageSize);
	
	//this will print  shorter rows, overloaded with pageSize
	public List<String> searchAllOccurrencesShort(boolean equals,String attribute);	
	public List<String> searchAllOccurrencesShort(boolean equals,String attribute, int pageSize);
	
	//this will print the whole rows sorted by the attribute searched, overloaded with pageSize
	public List<String> searchAllOccurrencesSorted(boolean equals,String attribute, boolean ascending);	
	public List<String> searchAllOccurrencesSorted(boolean equals,String attribute, boolean ascending, int pageSize);
	//this will print the whole rows  sorted by the attribute sortBy, overloaded with pageSize
	public List<String> searchAllOccurrencesSorted(boolean equals,String attribute, boolean ascending, String sortBy);
	public List<String> searchAllOccurrencesSorted(boolean equals,String attribute, boolean ascending, int pageSize, String sortBy);
	
	//this will print  shorter rows sorted by the attribute searched, overloaded with pageSize
	public List<String> searchAllOccurrencesSortedShort(boolean equals,String attribute, boolean ascending);	
	public List<String> searchAllOccurrencesSortedShort(boolean equals,String attribute, boolean ascending, int pageSize);
	//this will print shorter rows sorted by the attribute sortBy, overloaded with pageSize
	public List<String> searchAllOccurrencesSortedShort(boolean equals,String attribute, boolean ascending, String sortBy);
	public List<String> searchAllOccurrencesSortedShort(boolean equals,String attribute, boolean ascending, int pageSize, String sortBy);
	
	
	//SearchDeterminedOccurences**** search method where you need to write the attribute and the value you want to search, overloaded with custom pageSize
	//this will print the whole rows, overloaded with pageSize
	public List<String> searchDeterminedOccurrence(boolean equals,String attribute, String value);
	public List<String> searchDeterminedOccurrence(boolean equals,String attribute, String value, int pageSize);
	
	//this will print shorter rows, overloaded with pageSize
	public List<String> searchDeterminedOccurrenceShort(boolean equals,String attribute, String value);
	public List<String> searchDeterminedOccurrenceShort(boolean equals,String attribute, String value, int pageSize);
	
	//this will print the whole rows sorted by the attribute searched, overloaded with pageSize
	public List<String> searchDeterminedOccurrenceSorted(boolean equals,String attribute, String value, boolean ascending);
	public List<String> searchDeterminedOccurrenceSorted(boolean equals,String attribute, String value, boolean ascending, int pageSize);
	//this will print the whole rows sorted by the attribute sortBy, overloaded with pageSize
	public List<String> searchDeterminedOccurrenceSorted(boolean equals,String attribute, String value, boolean ascending, String sortBy);
	public List<String> searchDeterminedOccurrenceSorted(boolean equals,String attribute, String value, boolean ascending, int pageSize, String sortBy);
	
	//this will print shorter rows sorted by the attribute searched, overloaded with pageSize
	public List<String> searchDeterminedOccurrenceSortedShort(boolean equals,String attribute, String value, boolean ascending);
	public List<String> searchDeterminedOccurrenceSortedShort(boolean equals,String attribute, String value, boolean ascending, int pageSize);
	//this will print shorter rows sorted by the attribute sortBy, overloaded with pageSize
	public List<String> searchDeterminedOccurrenceSortedShort(boolean equals,String attribute, String value, boolean ascending, String sortBy);
	public List<String> searchDeterminedOccurrenceSortedShort(boolean equals,String attribute, String value, boolean ascending, int pageSize, String sortBy);
	
	
	//SearchSubstring**** search method where you need to write the attribute and the substring you want to search, overloaded with custom pageSize
	//this will print the whole rows, overloaded with pageSize
	public List<String> searchSubstring(boolean equals,String attribute, String value);
	public List<String> searchSubstring(boolean equals,String attribute, String value, int pageSize);
	
	//this will print shorter rows, overloaded with pageSize
	public List<String> searchSubstringShort(boolean equals,String attribute, String value);
	public List<String> searchSubstringShort(boolean equals,String attribute, String value, int pageSize);
	
	//this will print the whole rows sorted by the searched attribute, overloaded with pageSize
	public List<String> searchSubstringSorted(boolean equals,String attribute, String value, boolean ascending);
	public List<String> searchSubstringSorted(boolean equals,String attribute, String value, boolean ascending, int pageSize);
	//this will print the whole rows sorted by the attribute sortBy, overloaded with pageSize
	public List<String> searchSubstringSorted(boolean equals,String attribute, String value, boolean ascending, String sortBy);
	public List<String> searchSubstringSorted(boolean equals,String attribute, String value, boolean ascending, int pageSize, String sortBy);
	
	//this will print shorter rows sorted by the searched attribute, overloaded with pageSize
	public List<String> searchSubstringSortedShort(boolean equals,String attribute, String value, boolean ascending);
	public List<String> searchSubstringSortedShort(boolean equals,String attribute, String value, boolean ascending, int pageSize);
	//this will print shorter rows sorted by the attribute sortBy, overloaded with pageSize
	public List<String> searchSubstringSortedShort(boolean equals,String attribute, String value, boolean ascending, String sortBy);
	public List<String> searchSubstringSortedShort(boolean equals,String attribute, String value, boolean ascending, int pageSize, String sortBy);
	
	
}
