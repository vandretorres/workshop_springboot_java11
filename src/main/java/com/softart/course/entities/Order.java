package com.softart.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.softart.course.entities.enums.OrderStatus;

@Entity
@Table(name = "tb_order")
public class Order  implements Serializable{



	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mmss'Z'", timezone ="GMT")
	private Instant moment;

	@ManyToOne // mapeia relacionamento entre a classe Order e a Classe Client. Isso fará com que o  JPA crie o relacionamento na base de dados
	@JoinColumn(name = "client_id") // defini qual a coluna na tabela Order será utilizada como FK da tabela User
	private User client;


	private Integer orderStatus;
	
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	
	@OneToOne(mappedBy = "order" , cascade = CascadeType.ALL)
	private Payment payment;


	public Order() {

	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {

		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}



	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if ( orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}

	
	public Set<OrderItem> getItems(){
		return items;
	}
	
		

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((moment == null) ? 0 : moment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (moment == null) {
			if (other.moment != null)
				return false;
		} else if (!moment.equals(other.moment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", client=" + client + "]";
	}






}
