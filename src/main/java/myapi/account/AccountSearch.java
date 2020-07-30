package myapi.account;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.List;

import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptions;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.SortKey;

import myapi.abstracts.CustomHandler;
import myapi.abstracts.Options;
import myapi.abstracts.Search;
import net.tirasa.connid.bundles.ldap.LdapConnection;
import net.tirasa.connid.bundles.ldap.search.LdapFilter;
import net.tirasa.connid.bundles.ldap.search.LdapSearch;

public class AccountSearch implements Search {
	
	

	LdapConnection conn;
   
	
	public AccountSearch(LdapConnection connection) {
		conn = connection;
	}
	
	
	//default search method where you need to write the whole filter, overloaded with custom pageSize, equals == false -> !(filter)
	public List<String> search(boolean equals,String filter) {
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter(filter);}
		else {filt = LdapFilter.forNativeFilter("!"+filter);}		
		
		 CustomHandler handler = new CustomHandler();
		    new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, new OperationOptionsBuilder().setPageSize(500).build()).execute();
		  
		    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		
		    return handler.getUids();
	}
	
	public List<String> search(boolean equals,String filter, int pageSize) {

		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter(filter);}
		else {filt = LdapFilter.forNativeFilter("!"+filter);}		
		
		
		 CustomHandler handler = new CustomHandler();
		    new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, new OperationOptionsBuilder().setPageSize(500).build()).execute();
		  
		    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
		
	}
	
	
	//SearchALLOccurences**** search method where you need to write the attribute you want to search for any value, overloaded with custom pageSize
	//Options will print the whole rows, overloaded with pageSize, equals == false -> !(filter)
	public List<String> searchAllOccurrences(boolean equals,String attribute) {
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"=*)");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*)");}		
		
		
		 CustomHandler handler = new CustomHandler();
		    new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler,  new OperationOptionsBuilder().build()).execute();
		  
		    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		
		    return handler.getUids();
	}

	public List<String> searchAllOccurrences(boolean equals,String attribute, int pageSize) {
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"=*)");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*)");}		
		
		 CustomHandler handler = new CustomHandler();
		    new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler,  new OperationOptionsBuilder().setPageSize(500).build()).execute();
		  
		    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		
		    return handler.getUids();
	}
	
	
	//Options will print  shorter rows, overloaded with pageSize, equals == false -> !(filter)
	public List<String> searchAllOccurrencesShort(boolean equals,String attribute) {
				
		        OperationOptions ops = Options.optionsShort(attribute);
				
		        LdapFilter filt;
				if (equals) {
				filt = LdapFilter.forNativeFilter("("+attribute+"=*)");}
				else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*)");}
					
				 CustomHandler handler = new CustomHandler();
				
				   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
				  
				    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
				    handler.printObjects();
				    System.out.println();
				    
				    return handler.getUids();
			}
	
	public List<String> searchAllOccurrencesShort(boolean equals,String attribute, int pageSize) {
		
        OperationOptions ops = Options.optionsShort(attribute, pageSize);
		
        LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"=*)");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*)");}
			
		 CustomHandler handler = new CustomHandler();
		
		   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
		  
		    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
	}

	
	//Options will print the whole rows sorted by the attribute searched, overloaded with pageSize, equals == false -> !(filter)
	public List<String> searchAllOccurrencesSorted(boolean equals,String attribute, boolean ascending) {
		 OperationOptions ops = Options.optionsSort(attribute, ascending);
			
		 LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*)");}
				
			 CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
		
			    return handler.getUids();
	}

	public List<String> searchAllOccurrencesSorted(boolean equals,String attribute, boolean ascending, int pageSize) {
		 OperationOptions ops = Options.optionsSort(attribute, ascending, pageSize);
			
		 LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*)");}
				
			 CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			    
			    return handler.getUids();
		
	}

	
	//Options will print the whole rows  sorted by the attribute sortBy, overloaded with pageSize, equals == false -> !(filter)
	public List<String> searchAllOccurrencesSorted(boolean equals,String attribute, boolean ascending, String sortBy) {
		 OperationOptions ops = Options.optionsSort(attribute, ascending, sortBy);
		 
		 LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*)");}
				
			 CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
		
			    return handler.getUids();
	}
	
	public List<String> searchAllOccurrencesSorted(boolean equals,String attribute, boolean ascending, int pageSize, String sortBy) {
		 OperationOptions ops = Options.optionsSort(attribute, ascending, pageSize, sortBy);
			
		 LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*)");}
				
			 CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
		
			    return handler.getUids();
	}

	
	//Options will print  shorter rows sorted by the attribute searched, overloaded with pageSize, equals == false -> !(filter)
	public List<String> searchAllOccurrencesSortedShort(boolean equals,String attribute, boolean ascending) {
		OperationOptions ops = Options.optionsSortShort(attribute, ascending);
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"=*)");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*)");}
			
		 CustomHandler handler = new CustomHandler();
		
		   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
		  
		    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
	}
	
	public List<String> searchAllOccurrencesSortedShort(boolean equals,String attribute, boolean ascending, int pageSize) {
		OperationOptions ops = Options.optionsSortShort(attribute, ascending, pageSize);
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"=*)");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*)");}
			
		
		 CustomHandler handler = new CustomHandler();
		
		   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
		  
		    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
	}

	
	//Options will print shorter rows sorted by the attribute sortBy, overloaded with pageSize, equals == false -> !(filter)
	public List<String> searchAllOccurrencesSortedShort(boolean equals,String attribute, boolean ascending, String sortBy) {
		OperationOptions ops = Options.optionsSortShort(attribute, ascending, sortBy);
		
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"=*)");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*)");}
			
		
		 CustomHandler handler = new CustomHandler();
		
		   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
		  
		    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
	}

	public List<String> searchAllOccurrencesSortedShort(boolean equals,String attribute, boolean ascending, int pageSize, String sortBy) {
		OperationOptions ops = Options.optionsSortShort(attribute, ascending, pageSize, sortBy);
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"=*)");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*)");}
			
		 CustomHandler handler = new CustomHandler();
		
		   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
		  
		    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
	}
	
	
	
	//SearchDeterminedOccurences**** search method where you need to write the attribute and the value you want to search, overloaded with custom pageSize
		//Options will print the whole rows, overloaded with pageSize, equals == false -> !(filter)
	public List<String> searchDeterminedOccurrence(boolean equals,String attribute, String value) {
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"="+value+")");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"="+value+")");}
		
		CustomHandler handler = new CustomHandler();
		
		 new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, new OperationOptionsBuilder().build()).execute();
		    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
	}

	public List<String> searchDeterminedOccurrence(boolean equals,String attribute, String value, int pageSize) {
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"="+value+")");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"="+value+")");}
		
		CustomHandler handler = new CustomHandler();
		
		 new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, new OperationOptionsBuilder().setPageSize(pageSize).build()).execute();
		    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
	}

	
	//Options will print shorter rows, overloaded with pageSize, equals == false -> !(filter)
	public List<String> searchDeterminedOccurrenceShort(boolean equals,String attribute, String value) {
		   
		OperationOptions ops = Options.optionsShort(attribute);
		   
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"="+value+")");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"="+value+")");}
		
		CustomHandler handler = new CustomHandler();
		 if (ops != null) {
		    new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();}
		 else {new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, new OperationOptionsBuilder().build()).execute();}
		    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
	}

	public List<String> searchDeterminedOccurrenceShort(boolean equals,String attribute, String value, int pageSize) {
		   
		OperationOptions ops = Options.optionsShort(attribute, pageSize);
		   
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"="+value+")");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"="+value+")");}
		
		CustomHandler handler = new CustomHandler();
		 if (ops != null) {
		    new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();}
		 else {new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, new OperationOptionsBuilder().build()).execute();}
		    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
	}

	
	//Options will print the whole rows sorted by the attribute searched, overloaded with pageSize, equals == false -> !(filter)
	public List<String> searchDeterminedOccurrenceSorted(boolean equals,String attribute, String value, boolean ascending) {
		
		OperationOptions ops = Options.optionsSort(attribute, ascending);
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"="+value+")");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"="+value+")");}
		
		CustomHandler handler = new CustomHandler();
		
		   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
		  
		    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
		
	}

	public List<String> searchDeterminedOccurrenceSorted(boolean equals,String attribute, String value, boolean ascending, int pageSize) {
		
		OperationOptions ops = Options.optionsSort(attribute, ascending, pageSize);
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"="+value+")");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"="+value+")");}
		
		CustomHandler handler = new CustomHandler();
		
		   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
		  
		    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
		
	}

	
	//Options will print the whole rows sorted by the attribute sortBy, overloaded with pageSize, equals == false -> !(filter)
	public List<String> searchDeterminedOccurrenceSorted(boolean equals,String attribute, String value, boolean ascending, String sortBy) {
		
		OperationOptions ops = Options.optionsSort(attribute, ascending, sortBy);
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"="+value+")");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"="+value+")");}
		
		CustomHandler handler = new CustomHandler();
		
		   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
		  
		    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		
		    return handler.getUids();
	}
	
	public List<String> searchDeterminedOccurrenceSorted(boolean equals,String attribute, String value, boolean ascending, int pageSize, String sortBy) {
		
		OperationOptions ops = Options.optionsSort(attribute, ascending, pageSize, sortBy);
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"="+value+")");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"="+value+")");}
		
		CustomHandler handler = new CustomHandler();
		
		   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
		  
		    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		
		    return handler.getUids();
	}

	
	//Options will print shorter rows sorted by the attribute searched, overloaded with pageSize, equals == false -> !(filter)
	public List<String> searchDeterminedOccurrenceSortedShort(boolean equals,String attribute, String value, boolean ascending) {
		
		OperationOptions ops = Options.optionsSortShort(attribute, ascending);
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"="+value+")");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"="+value+")");}
		
		CustomHandler handler = new CustomHandler();
		
		   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
		  
		    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		
		    return handler.getUids();
	}
	
	public List<String> searchDeterminedOccurrenceSortedShort(boolean equals,String attribute, String value, boolean ascending, int pageSize) {
		
		OperationOptions ops = Options.optionsSortShort(attribute, ascending, pageSize);
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"="+value+")");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"="+value+")");}
		
		CustomHandler handler = new CustomHandler();
		
		   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
		  
		    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		
		    return handler.getUids();
	}
	
	
	//Options will print shorter rows sorted by the attribute sortBy, overloaded with pageSize, equals == false -> !(filter)
	public List<String> searchDeterminedOccurrenceSortedShort(boolean equals,String attribute, String value, boolean ascending, String sortBy) {
			
			OperationOptions ops = Options.optionsSortShort(attribute, ascending, sortBy);
			
			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"="+value+")");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"="+value+")");}
			
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			    
			    return handler.getUids();
			
		}
		
	public List<String> searchDeterminedOccurrenceSortedShort(boolean equals,String attribute, String value, boolean ascending, int pageSize, String sortBy) {
			
			OperationOptions ops = Options.optionsSortShort(attribute, ascending, pageSize, sortBy);
			
			
			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"="+value+")");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"="+value+")");}
			
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			    System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			
			    return handler.getUids();
		}
		
	
	
	//SearchSubstring**** search method where you need to write the attribute and the substring you want to search, overloaded with custom pageSize
		//Options will print the whole rows, overloaded with pageSize, equals == false -> !(filter)
		public List<String> searchSubstring(boolean equals,String attribute, String value) {
			
			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*"+value+"*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*"+value+"*)");}
			
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, new OperationOptionsBuilder().setPageSize(500).build()).execute();
			  
			    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			    
			    return handler.getUids();
		}
		
		public List<String> searchSubstring(boolean equals,String attribute, String value, int pageSize) {
			
			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*"+value+"*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*"+value+"*)");}
			
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, new OperationOptionsBuilder().setPageSize(pageSize).build()).execute();
			  
			    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			    
			    return handler.getUids();
		}
		
		
		//Options will print shorter rows, overloaded with pageSize, equals == false -> !(filter)
		public List<String> searchSubstringShort(boolean equals,String attribute, String value) {
		OperationOptions ops = Options.optionsShort(attribute);
		
		LdapFilter filt;
		if (equals) {
		filt = LdapFilter.forNativeFilter("("+attribute+"=*"+value+"*)");}
		else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*"+value+"*)");}
		
		CustomHandler handler = new CustomHandler();
		
		   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
		  
		    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
		    handler.printObjects();
		    System.out.println();
		    
		    return handler.getUids();
		}
		
		public List<String> searchSubstringShort(boolean equals,String attribute, String value, int pageSize) {
			OperationOptions ops = Options.optionsShort(attribute, pageSize);
			
			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*"+value+"*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*"+value+"*)");}
			
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			    System.out.println("Print search with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			
			    return handler.getUids();
		}
		
		
		//Options will print the whole rows sorted by the searched attribute, overloaded with pageSize, equals == false -> !(filter)
		public List<String> searchSubstringSorted(boolean equals,String attribute, String value, boolean ascending) {
			
			OperationOptions ops = Options.optionsSort(attribute, true);
			
			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*"+value+"*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*"+value+"*)");}
			
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			   System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			
			    return handler.getUids();
		}
		
		public List<String> searchSubstringSorted(boolean equals,String attribute, String value, boolean ascending, int pageSize) {
			OperationOptions ops = Options.optionsSort(attribute, true,pageSize);

			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*"+value+"*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*"+value+"*)");}
			
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			   System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			    
			    return handler.getUids();
		}
		

		//Options will print the whole rows sorted by the attribute sortBy, overloaded with pageSize, equals == false -> !(filter)
		public List<String> searchSubstringSorted(boolean equals,String attribute, String value, boolean ascending, String sortBy) {
			OperationOptions ops = Options.optionsSort(attribute, true, sortBy);
			
			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*"+value+"*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*"+value+"*)");}
			
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			   System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			    
			    return handler.getUids();
		}
		
		public List<String> searchSubstringSorted(boolean equals,String attribute, String value, boolean ascending, int pageSize, String sortBy) {
			OperationOptions ops = Options.optionsSort(attribute, true,pageSize, sortBy);
			
			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*"+value+"*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*"+value+"*)");}
			
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			   System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			    
			    return handler.getUids();
		}
		

		//Options will print shorter rows sorted by the searched attribute, overloaded with pageSize, equals == false -> !(filter)
		public List<String> searchSubstringSortedShort(boolean equals,String attribute, String value, boolean ascending) {
			OperationOptions ops = Options.optionsSortShort(attribute, true);
			
			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*"+value+"*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*"+value+"*)");}
			
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			   System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			    
			    return handler.getUids();
		}
		
		public List<String> searchSubstringSortedShort(boolean equals,String attribute, String value, boolean ascending, int pageSize) {
			
			OperationOptions ops = Options.optionsSortShort(attribute, ascending, pageSize);
			
			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*"+value+"*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*"+value+"*)");}
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			   System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			    
			    return handler.getUids();
		}
		
		
		//Options will print shorter rows sorted by the attribute sortBy, overloaded with pageSize, equals == false -> !(filter)
		public List<String> searchSubstringSortedShort(boolean equals,String attribute, String value, boolean ascending, String sortBy) {
			
			OperationOptions ops = Options.optionsSortShort(attribute, ascending, sortBy);
			
			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*"+value+"*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*"+value+"*)");}
			
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			   System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			    
			    return handler.getUids();
		}

		public List<String> searchSubstringSortedShort(boolean equals,String attribute, String value, boolean ascending, int pageSize, String sortBy) {
			
			
			OperationOptions ops = Options.optionsSortShort(attribute, ascending, pageSize, sortBy);
			LdapFilter filt;
			if (equals) {
			filt = LdapFilter.forNativeFilter("("+attribute+"=*"+value+"*)");}
			else {filt = LdapFilter.forNativeFilter("!("+attribute+"=*"+value+"*)");}
			CustomHandler handler = new CustomHandler();
			
			   new LdapSearch(conn, ObjectClass.ACCOUNT, filt, handler, ops).execute();
			  
			   System.out.println("Print search sorted by "+ ops.getSortKeys()[0].getField() +" with filter "+ filt.getNativeFilter()+":");
			    handler.printObjects();
			    System.out.println();
			    return handler.getUids();
		}


}
