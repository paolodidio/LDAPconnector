package myapi.abstracts;


import net.tirasa.connid.bundles.ldap.LdapConnection;

public interface LdapFactory {

	//public interface to implement to have a builder for ACCOUNT, GROUP, OU classes
	
	//create a Search object
	public Search createSearch();
	
	//create an Add object
	public Add createAdd();
	
	//create a Delete object
	public Delete createDelete();
	
	//create an Update object
	public Update createUpdate();
	
	public LdapConnection getConnection();

}
