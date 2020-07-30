package myapi.group;

import java.util.HashSet;
import java.util.Set;

import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.Uid;

import myapi.abstracts.Add;
import net.tirasa.connid.bundles.ldap.LdapConnection;
import net.tirasa.connid.bundles.ldap.modify.LdapCreate;

public class GroupAdd implements Add{



	LdapConnection conn;
	Set<Attribute> attrs;
	
	
	public GroupAdd(LdapConnection connection) {
		conn = connection;
	}
	
	public GroupAdd(LdapConnection connection, Set<Attribute> attributes  ) {
		conn = connection;
		attrs = attributes;
	}
	
		
		public Uid add() {
			Uid tmp;
		
			if(attrs != null) {
			
			tmp = new LdapCreate(conn, ObjectClass.ACCOUNT,attrs,new OperationOptionsBuilder().build()).execute(); }
			
			else {attrs = new HashSet<Attribute>();
			tmp = new LdapCreate(conn, ObjectClass.ACCOUNT,attrs,new OperationOptionsBuilder().build()).execute(); }
			
			if (tmp != null) {System.out.println("Successfully created an account!");}
			else {System.out.println("An error occured during account creation!");}
			 System.out.println();
			return tmp;
			
		}
	
	
}
