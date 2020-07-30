package myapi.group;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.Uid;

import myapi.abstracts.Update;
import net.tirasa.connid.bundles.ldap.LdapConnection;
import net.tirasa.connid.bundles.ldap.modify.LdapUpdate;

public class GroupUpdate implements Update{

LdapConnection conn;
	
	
	
	public GroupUpdate(LdapConnection connection ) {
		conn = connection;
	}
	
		
		public Uid update(String uid, Set<Attribute> attributes ) {
			Uid tmp;
		
			if(attributes != null) {
			
			tmp = new LdapUpdate(conn,ObjectClass.GROUP,new Uid(uid)).update(attributes); }
			
			else {tmp = null; System.out.println("No attribute passed!"); }
			
			if (tmp != null) {System.out.println("Successfully updated an account!");}
			else {System.out.println("An error occured during account update!");}
			System.out.println();
			return tmp;
			
		}


		public List<String> updateAll(List<String> uids, List<Attribute> attributeValues) {
			// TODO Auto-generated method stub
			return null;
		}


		public List<String> updateList(List<String> uids, List<Attribute> attributeValues) {
			// TODO Auto-generated method stub
			return null;
		}


		public List<String> updateList(List<String> uids, Attribute attr) {
			// TODO Auto-generated method stub
			return null;
		}


		public List<String> updateAllInteger(String attribute, int min) {
			// TODO Auto-generated method stub
			return null;
		}
	
}
