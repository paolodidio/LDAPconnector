package myapi.abstracts;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.identityconnectors.common.security.GuardedString;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.AttributeBuilder;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptions;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.SortKey;
import org.identityconnectors.framework.common.objects.Uid;

import myapi.account.AccountFactory;
import myapi.account.AccountUpdate;
import myapi.group.GroupFactory;
import net.tirasa.connid.bundles.ldap.LdapConfiguration;
import net.tirasa.connid.bundles.ldap.LdapConnection;
import net.tirasa.connid.bundles.ldap.search.LdapFilter;
import net.tirasa.connid.bundles.ldap.search.LdapSearch;


public class App {
	
	    public static void main( String[] args )
	    {        
	        LdapFactory factory = new AccountFactory();
	        Search search = factory.createSearch();
	        //search.search("(mail=*matear.eu)");
	       /* 
	       
	        
	        */
	  
	        //works
	        //factory.createDelete(factory.getConnection()).delete("1567075f-097e-4a87-a8ab-dbc0d01035f1");
	        
	        //works
	        /*
	        Set<Attribute> toUpdate = new HashSet<Attribute>();
	        toUpdate.add(AttributeBuilder.build("shadowWarning", "1234"));
	        //43f79794-8ad1-4cd8-b864-223fe3040d09 Baldo
	        factory.createUpdate(factory.getConnection()).update("43f79794-8ad1-4cd8-b864-223fe3040d09", toUpdate);
	    	*/
	        
	   
	        /*works
	        search.searchAllOccurrences(true,"uid");
	        search.searchAllOccurrences(false,"uid",5);
	        search.searchAllOccurrencesShort(true,"mail");
	        search.searchAllOccurrencesShort(false,"uid",5);
	        search.searchAllOccurrencesSorted(true,"sn", true);
	        search.searchAllOccurrencesSorted(false,"sn", true, 5);
	        search.searchAllOccurrencesSorted(true,"shadowWarning",true,"sn");
	        search.searchAllOccurrencesSorted(false,"shadowWarning",true,50,"sn");
	        search.searchAllOccurrencesSortedShort(true,"sn", true);
	        search.searchAllOccurrencesSortedShort(false,"sn", true, 5);
	        search.searchAllOccurrencesSortedShort(true,"shadowWarning",true,"sn");
	        search.searchAllOccurrencesSortedShort(false,"shadowWarning",true,50,"sn");
	        */
	        
	        /*
	        search.searchDeterminedOccurrence(true,"uid", "hr");
	        search.searchDeterminedOccurrence(false,"uid", "hr",5);
	        search.searchDeterminedOccurrenceShort(true,"uid", "dev");
	        search.searchDeterminedOccurrenceShort(false,"uid", "dev",5);
	        search.searchDeterminedOccurrenceSorted(true,"sn", "B*",true);
	        search.searchDeterminedOccurrenceSorted(false,"sn", "B*",true, 5);
	         search.searchDeterminedOccurrenceSorted(true,"shadowWarning", "72",true,"sn");
	        search.searchDeterminedOccurrenceSorted(false,"shadowWarning", "72",true,50,"sn");
	        search.searchDeterminedOccurrenceSortedShort(true,"sn","B*",true, 5);
	        search.searchDeterminedOccurrenceSortedShort(false,"sn","B*", true)
	         search.searchDeterminedOccurrenceSortedShort(true,"shadowWarning", "72",true,"sn");
	        search.searchDeterminedOccurrenceSortedShort(false,"shadowWarning", "72",true,50,"sn");
	       */
	        
	        /* works
	        search.searchSubstring(true,"sn", "B");
	        search.searchSubstring(false,"sn", "B", 1);
	        search.searchSubstringShort(true,"sn", "B");
	        search.searchSubstringShort(false,"sn", "B",1);
	        search.searchSubstringSorted(true,"sn", "B",true);
	        search.searchSubstringSorted(false,"sn", "B",true,1);
	        search.searchSubstringSorted(true,"mail", "matear",true,"sn");
	        search.searchSubstringSorted(false,"mail", "matear",true,50,"sn");
	        search.searchSubstringSortedShort(true,"sn", "B",true);
	        search.searchSubstringSortedShort(false,"sn", "B",true);*/
	        //search.searchSubstringSortedShort(true,"mail", "matear",true,"sn");
	       /* ArrayList<String> tmp = new ArrayList<String>(search.searchSubstringSortedShort(false, "mail", "matear",true,9,"sn"));
	        for(int i=0; i<tmp.size(); i++) {
	        	System.out.println("aosdjoasjodas   "+tmp.get(i));
	        }
	        */
	    	/* LdapFactory factory = new GroupFactory();
		     Search search = factory.createSearch();
		     search.searchSubstringSortedShort(true, "ou", "n", true);*/
	        
	        Update update = factory.createUpdate();
	        
	        update.updateAllInteger("roomNumber", 4444);
	        
	    }
	
}
