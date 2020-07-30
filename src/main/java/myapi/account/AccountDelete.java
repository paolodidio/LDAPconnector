package myapi.account;

import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptions;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.Uid;

import myapi.abstracts.Delete;
import net.tirasa.connid.bundles.ldap.LdapConnection;
import net.tirasa.connid.bundles.ldap.modify.LdapDelete;
import net.tirasa.connid.bundles.ldap.search.LdapFilter;
import net.tirasa.connid.bundles.ldap.search.LdapSearch;

public class AccountDelete implements Delete {

	LdapConnection conn;
	   
	
	public AccountDelete(LdapConnection connection) {
		conn = connection;
	}
	
	
	public void delete(String uid) {new LdapDelete(conn,ObjectClass.ACCOUNT,new Uid(uid)).execute();}
}
