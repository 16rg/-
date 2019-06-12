package manage.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_kecheng")
public class Kecheng implements Serializable{

	private static final long serialVersionUID = 2429695896963809335L;

	private int id;
	
	private Date createtime;
	
	private String kechengname1;//选课名称
	
	private String kechengname2;//选课名称
	
	private String kechengname3;//选课名称
	
	private String kechengname4;//选课名称
	
	private String kechengname5;//选课名称
	
	private String kechengname6;//选课名称
	
	private String kechengname7;//选课名称
	
	private int kechenglock;//课程位置
	
    private String banji;//班级
	
	private String banjinum;//班级编号

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getBanji() {
		return banji;
	}

	public void setBanji(String banji) {
		this.banji = banji;
	}

	public String getBanjinum() {
		return banjinum;
	}

	public void setBanjinum(String banjinum) {
		this.banjinum = banjinum;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getKechengname1() {
		return kechengname1;
	}

	public void setKechengname1(String kechengname1) {
		this.kechengname1 = kechengname1;
	}

	public String getKechengname2() {
		return kechengname2;
	}

	public void setKechengname2(String kechengname2) {
		this.kechengname2 = kechengname2;
	}

	public String getKechengname3() {
		return kechengname3;
	}

	public void setKechengname3(String kechengname3) {
		this.kechengname3 = kechengname3;
	}

	public String getKechengname4() {
		return kechengname4;
	}

	public void setKechengname4(String kechengname4) {
		this.kechengname4 = kechengname4;
	}

	public String getKechengname5() {
		return kechengname5;
	}

	public void setKechengname5(String kechengname5) {
		this.kechengname5 = kechengname5;
	}

	public String getKechengname6() {
		return kechengname6;
	}

	public void setKechengname6(String kechengname6) {
		this.kechengname6 = kechengname6;
	}

	public String getKechengname7() {
		return kechengname7;
	}

	public void setKechengname7(String kechengname7) {
		this.kechengname7 = kechengname7;
	}

	public int getKechenglock() {
		return kechenglock;
	}

	public void setKechenglock(int kechenglock) {
		this.kechenglock = kechenglock;
	}

	
	
	
	
}
