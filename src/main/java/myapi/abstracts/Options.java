package myapi.abstracts;

import org.identityconnectors.framework.common.objects.OperationOptions;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.SortKey;

public class Options {
	//those public method are used to create the OperationOptions (E.g. in search methods)
	
		static public OperationOptions optionsShort(String attribute) {
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			//default is 500
			builder.setPageSize(500);
			
	        builder.setAttributesToGet(attribute);
	        return builder.build();
		}
		
		static public OperationOptions optionsShort(String attribute, int pageSize) {
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setPageSize(pageSize);
	        builder.setAttributesToGet(attribute);
	        return builder.build();
		}
		
		
		static public OperationOptions optionsSort(String attribute, boolean ascending) {
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			//default is 500
			builder.setPageSize(500);
			
			SortKey key =new SortKey(attribute, ascending);
	        builder.setSortKeys(key);
	        return builder.build();
		}
		
		static public OperationOptions optionsSort(String attribute, boolean ascending, int pageSize) {
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setPageSize(pageSize);
			SortKey key =new SortKey(attribute, ascending);
	        builder.setSortKeys(key);
	        return builder.build();
		}
		
		static public OperationOptions optionsSort(String attribute, boolean ascending, String sortBy) {
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			//default is 500
			builder.setPageSize(500);
			SortKey key =new SortKey(sortBy, ascending);
	        builder.setSortKeys(key);
	        return builder.build();
		}
		
		static public OperationOptions optionsSort(String attribute, boolean ascending, int pageSize, String sortBy) {
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setPageSize(pageSize);
			SortKey key =new SortKey(sortBy, ascending);
	        builder.setSortKeys(key);
	        return builder.build();
		}
		
		
		static public OperationOptions optionsSortShort(String attribute, boolean ascending) {
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			//default is 500
			builder.setPageSize(500);
			
	        builder.setAttributesToGet(attribute);
	        SortKey key =new SortKey(attribute, ascending);
	        builder.setSortKeys(key);
	        return builder.build();
		}
		
		static public OperationOptions optionsSortShort(String attribute, boolean ascending, int pageSize) {
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setPageSize(pageSize);
	        builder.setAttributesToGet(attribute);
	        SortKey key =new SortKey(attribute, ascending);
	        builder.setSortKeys(key);
	        return builder.build();
		}
		static public OperationOptions optionsSortShort(String attribute, boolean ascending, String sortBy) {
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			//default is 500
			builder.setPageSize(500);
	        builder.setAttributesToGet(attribute, sortBy);
	        SortKey key =new SortKey(sortBy, ascending);
	        builder.setSortKeys(key);
	        return builder.build();
		}
		
		static public OperationOptions optionsSortShort(String attribute, boolean ascending, int pageSize, String sortBy) {
			OperationOptionsBuilder builder = new OperationOptionsBuilder();
			builder.setPageSize(pageSize);
	        builder.setAttributesToGet(attribute, sortBy);
	        SortKey key =new SortKey(sortBy, ascending);
	        builder.setSortKeys(key);
	        return builder.build();
		}

		
}
