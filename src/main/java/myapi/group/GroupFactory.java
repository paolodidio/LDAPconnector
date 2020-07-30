package myapi.group;

import java.util.Set;

import org.identityconnectors.common.security.GuardedString;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.OperationOptions;
import org.identityconnectors.framework.common.objects.Uid;

import myapi.abstracts.LdapFactory;
import net.tirasa.connid.bundles.ldap.LdapConfiguration;
import net.tirasa.connid.bundles.ldap.LdapConnection;

public class GroupFactory implements LdapFactory {

	
	//singleton???????
		private LdapConnection connection;
		
		public GroupFactory() {this.setConnection();}
		
		public GroupSearch createSearch() {
			return new GroupSearch(connection);
		}

		
		public GroupAdd createAdd() {
			return new GroupAdd(connection);
		}
		
		public GroupDelete createDelete() {
			return new GroupDelete(connection);
		}
		
		
		public GroupUpdate createUpdate() {
			return new GroupUpdate(connection);
		}
		
		private void setConnection() {
			LdapConfiguration config = new LdapConfiguration();
	        config.setGroupObjectClasses("organizationalUnit","top");
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
