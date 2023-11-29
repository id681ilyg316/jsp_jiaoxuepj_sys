
package com.orm;

public class Tpingjia
{
	private String id;
	private int tea_id;
	private int zongfenshu;
	private String shijian;
	
	private int stu_id;
	
	private Ttea tea;
	private Tstu stu;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	public int getStu_id()
	{
		return stu_id;
	}

	public void setStu_id(int stu_id)
	{
		this.stu_id = stu_id;
	}

	public int getTea_id()
	{
		return tea_id;
	}

	public void setTea_id(int tea_id)
	{
		this.tea_id = tea_id;
	}

	public int getZongfenshu()
	{
		return zongfenshu;
	}

	public Tstu getStu()
	{
		return stu;
	}

	public void setStu(Tstu stu)
	{
		this.stu = stu;
	}

	public Ttea getTea()
	{
		return tea;
	}

	public void setTea(Ttea tea)
	{
		this.tea = tea;
	}

	public void setZongfenshu(int zongfenshu)
	{
		this.zongfenshu = zongfenshu;
	}
	
}
