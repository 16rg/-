package manage.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_qingjiadan")
public class QingJiaDan {

	private int id;
	
	private Date createtime;
	
	private String  qjtime1;//请假开始时间
	
	private String  qjtime2;//请假结束时间
	
	private String codenum;//学生编号
	
	private String username;//姓名
	
	private String banjinum;//班级编号
	
	private String shenhe;//审核状态
	
	private String shenhecontent;//审核意见
	
	private String qjcontent;//请假理由

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

	public String getQjtime1() {
		return qjtime1;
	}

	public void setQjtime1(String qjtime1) {
		this.qjtime1 = qjtime1;
	}

	public String getQjtime2() {
		return qjtime2;
	}

	public void setQjtime2(String qjtime2) {
		this.qjtime2 = qjtime2;
	}

	public String getCodenum() {
		return codenum;
	}

	public void setCodenum(String codenum) {
		this.codenum = codenum;
	}

	public String getShenhe() {
		return shenhe;
	}

	public void setShenhe(String shenhe) {
		this.shenhe = shenhe;
	}

	public String getShenhecontent() {
		return shenhecontent;
	}

	public void setShenhecontent(String shenhecontent) {
		this.shenhecontent = shenhecontent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBanjinum() {
		return banjinum;
	}

	public void setBanjinum(String banjinum) {
		this.banjinum = banjinum;
	}

	public String getQjcontent() {
		return qjcontent;
	}

	public void setQjcontent(String qjcontent) {
		this.qjcontent = qjcontent;
	}
	
	

}
