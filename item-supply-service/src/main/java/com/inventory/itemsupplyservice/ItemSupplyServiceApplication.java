package com.inventory.itemsupplyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class ItemSupplyServiceApplication {

	private final ItemRepository repository;

	public ItemSupplyServiceApplication(ItemRepository repository) {
		this.repository = repository;
	}


	public static void main(String[] args) {
		SpringApplication.run(ItemSupplyServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Item item1 = new Item("Dünyanın Gözü", 2000, "Robert Jordan", "İthaki Yayınevi", "123456");
		Item item2 = new Item("Yüzüklerin Efendisi", 1960, "J.R.R Tolkien", "Metis Yayıncılık", "456789");
		Item item3 = new Item("Harry Potter ve Felsefe Taşı", 1997, "J. K. Rowling", "YKB Yayınları", "987654");

		List<Item> itemList = repository.saveAll(Arrays.asList(item1, item2, item3));

		System.out.println(itemList);
	}

}
