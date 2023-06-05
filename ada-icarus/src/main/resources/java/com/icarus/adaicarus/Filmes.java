package com.icarus.adaicarus;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Filmes {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	    
	    private String name;
	    
	    public Filmes(Long id, String name, String description) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
		}

		private String description;
	    public long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		
	    
	 
	}

