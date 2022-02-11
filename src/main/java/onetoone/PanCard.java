package onetoone;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onetomany.Customers;

@Entity
@Table(name="PanCard")
public class PanCard {
	
	@Id
	@Column(name = "panid")
	private int panCardId;
	
	@Column(name="panno")
	private String panCardNo;
	
	@OneToOne(fetch = FetchType.EAGER,targetEntity = Customers.class,cascade = CascadeType.ALL)
	@JoinColumn(name="pid", nullable=false)
	private Person obj;

	public Person getObj() {
		return obj;
	}

	public void setObj(Person obj) {
		this.obj = obj;
	}

	public int getPanCardId() {
		return panCardId;
	}

	public void setPanCardId(int panCardId) {
		this.panCardId = panCardId;
	}

	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

}
