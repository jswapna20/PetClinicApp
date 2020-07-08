	package com.petclinic;
	import java.util.Date;
	import java.util.Collection;
	import javax.persistence.*;
	import org.hibernate.annotations.IndexColumn;
	import com.petclinic.Pet;

	@Entity
	@Table(name="Visit")
	public class Visit {
		
		@Id @GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="visitId")
		private int visitId;

		@Column(name="date")
		private String visitDate;

		@Column(name="description")
		private String description;

		//@ManyToOne
		@ManyToOne(cascade={CascadeType.MERGE})
		@JoinColumn(name="vsid")
		private Pet pet;

		public Visit(){
		}

		public Visit(final int visitId, final String visitDate,final String description, final Pet pet){
			this.visitId = visitId;
			this.visitDate = visitDate;
			this.description = description;
			this.pet = pet;
		}

		public Visit(final String visitDate,final String description){
			this.visitDate = visitDate;
			this.description = description;
		}

		public void setVisitId(int visitId){
			this.visitId = visitId;
		}

		public int getVisitId(){
			return visitId;
		}

		public void setVisitDate(String visitDate){
			this.visitDate = visitDate;
		}

		public String getVisitDate(){
			return visitDate;
		}

		public void setDescription(String description){
			this.description = description;
		}

		public String getDescription(){
			return description;
		}

		public void setPet(Pet pet){
			this.pet = pet;
		}

		public Pet getPet(){
			return pet;
		}


		@Override
		public boolean equals(Object o){
			
			if (o instanceof Visit)
			{
				return ((Visit)o).getVisitId()==visitId;
			}
			else 
				return false;
		}

		@Override
		public int hashCode(){
		
			return visitId;
		
		}




	}