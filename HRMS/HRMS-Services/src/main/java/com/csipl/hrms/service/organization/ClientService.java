package com.csipl.hrms.service.organization;

import java.util.List;

import com.csipl.hrms.model.organisation.Client;

public interface ClientService {
	
	public List<Client> getAllClients(Long companyId);
	public Client getClient(Long id);
	public Client save(Client client);
}
