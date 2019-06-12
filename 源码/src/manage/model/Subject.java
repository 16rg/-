package manage.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_subject")
public class Subject implements Serializable{

	private static final long serialVersionUID = 2429695896963809335L;

	private int id;
	
	private Date createtime;
	
	private String subjectname;//科目名称,课程
	
	private java.sql.Time sksj;//上课时间
	
	private java.sql.Time xksj;//下课时间

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public void setSksj(java.sql.Time sksj) {
		this.sksj = sksj;
	}

	public java.sql.Time getSksj() {
		return sksj;
	}

	public void setXksj(java.sql.Time xksj) {
		this.xksj = xksj;
	}

	public java.sql.Time getXksj() {
		return xksj;
	}

	
	
	
}
