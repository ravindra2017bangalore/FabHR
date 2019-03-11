package com.csipl.common.services.dropdown.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.common.model.DrowpdownHd;





public interface DropDownHdRepository extends CrudRepository<DrowpdownHd, Long> {

	@Query(" from DrowpdownHd ")
    public List<DrowpdownHd> findAllDropDown();
	
	@Query(" from DrowpdownHd hd where hd.drowpdownId=?1")
    public DrowpdownHd findDropDownById( long dropDownId );
}
