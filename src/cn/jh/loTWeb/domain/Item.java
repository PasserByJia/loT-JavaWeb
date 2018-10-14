package cn.jh.loTWeb.domain;

import java.io.Serializable;
import java.util.Date;

public class Item  implements Comparable<Item>,Serializable{
	private Integer id;
	private Double temperature;
	private Double humidity;
	private Double weight;
	private Integer infaredSensor;
	
	public Item(){}

	public Item(Integer id, Double temperature, Double humidity, Double weight, Integer infaredSensor) {
		this.id = id;
		this.temperature = temperature;
		this.humidity = humidity;
		this.weight = weight;
		this.infaredSensor = infaredSensor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getInfaredSensor() {
		return infaredSensor;
	}

	public void setInfaredSensor(Integer infaredSensor) {
		this.infaredSensor = infaredSensor;
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return this.id-o.id;
	}

}
