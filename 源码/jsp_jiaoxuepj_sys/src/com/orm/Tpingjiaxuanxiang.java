
package com.orm;

public class Tpingjiaxuanxiang
{
	private int id;
	private int zhibiao_id;
	private int fenshu;
	private String shijian;
	
	private Tzhibiao zhibiao;
	
	public int getFenshu()
	{
		return fenshu;
	}
	public void setFenshu(int fenshu)
	{
		this.fenshu = fenshu;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getShijian()
	{
		return shijian;
	}
	
	public Tzhibiao getZhibiao()
	{
		return zhibiao;
	}
	public void setZhibiao(Tzhibiao zhibiao)
	{
		this.zhibiao = zhibiao;
	}
	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}
	public int getZhibiao_id()
	{
		return zhibiao_id;
	}
	public void setZhibiao_id(int zhibiao_id)
	{
		this.zhibiao_id = zhibiao_id;
	}
	
	
}
