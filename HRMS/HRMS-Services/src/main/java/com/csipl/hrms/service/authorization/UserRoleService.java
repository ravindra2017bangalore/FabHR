package com.csipl.hrms.service.authorization;

 
import java.util.List;

import com.csipl.hrms.model.authoriztion.UserRole;
public interface UserRoleService {
  public void save(UserRole userRole);
  public List<UserRole> findAllUserRoles();
  public void saveAll(List<UserRole> userRoleList);
  public List<UserRole> findUserRoles(Long employeeId);
  public void delete(Long userRolesSrNo);

}
