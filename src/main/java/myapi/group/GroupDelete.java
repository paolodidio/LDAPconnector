package myapi.group;

import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.Uid;

import myapi.abstracts.Delete;
import net.tirasa.connid.bundles.ldap.LdapConnection;
import net.tirasa.connid.bundles.ldap.modify.LdapDelete;

public class GroupDelete implements Delete{

	LdapConnection conn;
  
	
	public GroupDelete(LdapConnection connection) {
		conn = connection;
	}
	
	
	public void delete(String uid) {new LdapDelete(conn,ObjectClass.ACCOUNT,new Uid(uid)).execute();}
	
}
