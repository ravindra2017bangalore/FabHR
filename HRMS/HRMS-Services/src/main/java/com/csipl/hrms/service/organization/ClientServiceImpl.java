package com.csipl.hrms.service.organization;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.organisation.Client;
import com.csipl.hrms.service.organization.repository.ClientRepository;

@Service("clientService")
public class ClientServiceImpl implements ClientService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private ClientRepository clientRepository;


	/**
	 * Save OR update branch object into Database
	 */
	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	/**
	 * To get Client object from Database based on clientId (Primary key)
	 */
	@Override
	public Client getClient(Long id) {
		return clientRepository.findOne(id);
	}
	/**
	 * To get List of Clients from Database based on companyId
	 */
	@Override
	public List<Client> getAllClients(Long companyId) {
		return clientRepository.findAllClient(companyId);
	}

}
