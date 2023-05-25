package com.store.inventorymanagement;

import com.store.inventorymanagement.infrastructure.adapters.driven.repositories.CategoryRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryManagementApplication implements Runnable{

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementApplication.class, args);
	}


	@Override
	public void run() {

	}
}
