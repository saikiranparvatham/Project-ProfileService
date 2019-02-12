package com.eshoppingzone.profile.UserProfileService.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eshoppingzone.profile.UserProfileService.pojo.Role;
import com.eshoppingzone.profile.UserProfileService.pojo.UserProfile;
import com.eshoppingzone.profile.UserProfileService.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public UserProfile addNewCustomerProfile(UserProfile profile) {
		profile.setRole(Role.Customer);
		UserProfile user1 = repository.save(profile);
		int id=user1.getProfileId();
		System.out.println(id);
	/*	restTemplate.postForEntity("http://10.246.92.94:8426/wallets/"+id, null, null);*/
		restTemplate.postForEntity("http://10.246.92.75:9091/carts/"+id, null, null);
		return user1;
	}

	@Override
	public void addNewMerchantProfile(UserProfile profile) {
		profile.setRole(Role.Merchant);
		profile.setAddresses(null);
		repository.save(profile);
	}

	@Override
	public void addNewdeliveryProfile(UserProfile profile) {
		profile.setRole(Role.DeliveryAgent);
		profile.setAddresses(null);
		repository.save(profile);	
	}
	
	@Override
	public List<UserProfile> getAllProfiles() {
		
		return repository.findAll();
	}

	@Override
	public UserProfile getByProfileId(int profileId) {
		return repository.findById(profileId).get();
	}

	@Override
	public void updateProfile(UserProfile userProfile) {
		 repository.save(userProfile);
	}

	@Override
	public void deleteProfile(int profileId) {
		 repository.deleteById(profileId);
	}

	public UserProfile getByUserName(String username) {
		return repository.findByUsername(username);
	}


	
}
