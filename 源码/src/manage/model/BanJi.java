package manage.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_banji")
public class BanJi implements Serializable{

	private static final long serialVersionUID = 2429695896963809345L;

	private int id;
	
	private Date createtime;//班级新建时间
	
	private String banjiname;//班级名称
	
	private String yuanxi;//院系名称
	
	private String zhuanye;//专业名称
	
	private String banjinum;//班级编号

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

	public String getBanjiname() {
		return banjiname;
	}

	public void setBanjiname(String banjiname) {
		this.banjiname = banjiname;
	}

	public String getYuanxi() {
		return yuanxi;
	}

	public void setYuanxi(String yuanxi) {
		this.yuanxi = yuanxi;
	}

	public String getZhuanye() {
		return zhuanye;
	}

	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}

	public String getBanjinum() {
		return banjinum;
	}

	public void setBanjinum(String banjinum) {
		this.banjinum = banjinum;
	}

	
	
}
