package manage.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 考勤实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="t_kaoqinlog")
public class KaoQinLog implements Serializable{

	private static final long serialVersionUID = 2429695896963809345L;

	private int id;
	
	private java.sql.Time createtime;//创建当前的时间
	
	private String kechengname;//课程
	
	private String banjinum;//班级编号
	
	private String teacher;//任课老师
	
	private String codenum; //学号
	
	private int iskuangke; //1:旷课,0:迟到
	
	private int kuangkenum;//旷课数量
	
	private String  riqi;//时间，日期
	
	private String kqtype; // 迟到、早退、正常

	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Time getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Time createtime) {
		this.createtime = createtime;
	}

	public String getKechengname() {
		return kechengname;
	}

	public void setKechengname(String kechengname) {
		this.kechengname = kechengname;
	}


	public String getBanjinum() {
		return banjinum;
	}

	public void setBanjinum(String banjinum) {
		this.banjinum = banjinum;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}


	public String getCodenum() {
		return codenum;
	}

	public void setCodenum(String codenum) {
		this.codenum = codenum;
	}

	public int getIskuangke() {
		return iskuangke;
	}

	public void setIskuangke(int iskuangke) {
		this.iskuangke = iskuangke;
	}


	public int getKuangkenum() {
		return kuangkenum;
	}

	public void setKuangkenum(int kuangkenum) {
		this.kuangkenum = kuangkenum;
	}

	public String getRiqi() {
		return riqi;
	}

	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}

	public void setKqtype(String kqtype) {
		this.kqtype = kqtype;
	}

	public String getKqtype() {
		return kqtype;
	}
	
}
