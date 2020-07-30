package myapi.account;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.AttributeBuilder;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.Uid;

import myapi.abstracts.Update;
import net.tirasa.connid.bundles.ldap.LdapConnection;
import net.tirasa.connid.bundles.ldap.modify.LdapCreate;
import net.tirasa.connid.bundles.ldap.modify.LdapUpdate;

public class AccountUpdate implements Update{

	LdapConnection conn;
	
	
	
	public AccountUpdate(LdapConnection connection ) {
		conn = connection;
	}
	
	  //given the java identifier of an account and a list of attributes, update the entry
		public Uid update(String uid, Set<Attribute> attributes ) {
			Uid tmp;
		
			if(attributes != null) {
			
			tmp = new LdapUpdate(conn,ObjectClass.ACCOUNT,new Uid(uid)).update(attributes); }
			
			else {tmp = null; System.out.println("No attribute passed!"); }
			
			if (tmp != null) {System.out.println("Successfully updated an account!");}
			else {System.out.println("An error occured during account update!");}
			System.out.println();
			return tmp;
			
		}

		//given a list of java identifiers (of accounts) and a list of values of a SINGLE attribute, update all the entries
		public List<String> updateList(List<String> uids, List<Attribute> attributeValues) {
			
			for (int i = 0; i<uids.size(); i++) {
				Set<Attribute> a=new HashSet<Attribute>();
				a.add(attributeValues.get(i));
				uids.set(i, new LdapUpdate(conn,ObjectClass.ACCOUNT,new Uid(uids.get(i))).update(a).getUidValue() );
			}
			
			return uids;
		}
		
		//given a list of java identifiers (of accounts) and an attribute, update all the entries
		public List<String> updateList(List<String> uids, Attribute attr){
			return updateList(uids, duplicateAttribute(attr, uids.size()));
		}
		
		
		public List<String> updateAllInteger(String attribute, int min) {
			
			AccountSearch tmp = new AccountSearch(conn);
			
			List<String> uids = tmp.search(true, "(cn=*)");
			Set<Attribute> set=new HashSet<Attribute>();
			List<String> result= new ArrayList<String>();
			
			for (int i =0; i<uids.size();i++) {
				
				AttributeBuilder builder = new AttributeBuilder();
				
				
				set.add(new AttributeBuilder().build(attribute, Integer.toString(min+i)  ));
				result.add(new LdapUpdate(conn,ObjectClass.ACCOUNT,new Uid(uids.get(i))).update(set).getUidValue());
				set.clear();
			}
			
			return result;
		}
		
		
		// method to create a list of identical attributes, given one and the number of copies
		private List<Attribute> duplicateAttribute (Attribute attr, int quantity){
			List<Attribute> result= new ArrayList<Attribute>();
			for (int i = 0; i < quantity; i ++) {
				result.add(attr);
			}
			return result;
		}

		
		
}
