package com.csipl.hrms.util;



import java.util.HashSet;
import java.util.Set;
import com.csipl.hrms.dto.organisation.UserDTO;
import com.csipl.hrms.model.common.User;

public class UserAccessHelper {

	public UserDTO setRolePermissionForUIUser( UserDTO userdto, User user ) {
		
		 Set<String>	roles = new HashSet<String>();
		 Set<String>	permissions	= new HashSet<String>();
		
		//List<UserRole> userRoles	= user.getUserRoles();
		if ( user.getUserRoles() != null ) {
			user.getUserRoles().forEach( userRole -> {
				userRole.getRoleMaster().getObjectsInSystemInRoles().forEach(  userPermission -> {
					permissions.add( userPermission.getObjectsInSystem().getObjectDescription() );
					
				});
				roles.add(  userRole.getRoleMaster().getRoleDescription() );
			});
		}
		
		userdto.setRoles(roles);
		userdto.setPermissions(permissions);
		userdto.setNameOfUser(user.getNameOfUser());
		return userdto;
	}
}
