package com.codewithmosh.store;

import com.codewithmosh.store.entities.Address;
import com.codewithmosh.store.entities.Profile;
import com.codewithmosh.store.entities.Tag;
import com.codewithmosh.store.entities.User;
import org.aspectj.bridge.ILifecycleAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {

		var user = User.builder()
					.name("John")
					.password("password")
					.email("john@codewithmosh.com").build();
		var address = Address.builder()
				.id(1L)
				.street("street")
				.city("city")
				.state("state")
				.build();
		user.addAddress(address);
		user.addTag("tag");

		var profile = Profile.builder().bio("bio").build();
		user.setProfile(profile);
		profile.setUser(user);
		System.out.println(user);
	}

}
