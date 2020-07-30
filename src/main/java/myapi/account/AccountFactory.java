package myapi.account;

import java.util.Set;

import org.identityconnectors.common.security.GuardedString;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.OperationOptions;
import org.identityconnectors.framework.common.objects.OperationOptionsBuilder;
import org.identityconnectors.framework.common.objects.SortKey;
import org.identityconnectors.framework.common.objects.Uid;

import myapi.abstracts.LdapFactory;
import net.tirasa.connid.bundles.ldap.LdapConfiguration;
import net.tirasa.connid.bundles.ldap.LdapConnection;

public class AccountFactory implements LdapFactory {

	//singleton???????
	private LdapConnection connection;
	
	public AccountFactory() {this.setConnection();}
	
	//create a Search object for ACCOUNT elements
	public AccountSearch createSearch() {
		return new AccountSearch(connection);
	}

	//create an Add object for ACCOUNT elements
	public AccountAdd createAdd() {
		return new AccountAdd(connection);
	}
	
	//create a Delete object for ACCOUNT elements
	public AccountDelete createDelete() {
		return new AccountDelete(connection);
	}
	
	//create an Update object for ACCOUNT elements
	public AccountUpdate createUpdate() {
		return new AccountUpdate(connection);
	}
	
	private void setConnection() {
		LdapConfiguration config = new LdapConfiguration();
        //generated data
		
		//defined before running or ask to user input
		config.setAccountObjectClasses("top","person","organizationalPerson","inetOrgPerson");
        //paolo's data
		//config.setAccountObjectClasses("top","person","organizationalPerson","posixAccount","shadowAccount","inetOrgPerson");
        config.setHost("localhost");
        config.setPort(389);
        config.setBaseContexts("dc=my-domain,dc=com");
        config.setPrincipal("cn=Manager,dc=my-domain,dc=com");
        config.setCredentials(new GuardedString("sudo".toCharArray()));
        config.setReadSchema(true);
        
        this.connection = new LdapConnection(config);
	}
	
	public LdapConnection getConnection() {
		return this.connection;
	}
	
	
}
