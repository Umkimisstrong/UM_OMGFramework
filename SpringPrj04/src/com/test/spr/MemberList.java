/*
	MemberList.java
	- DAO 클래스를 참조하는 클래스
	- 의존관계 설정
	- print() 메소드 구현 
*/
package com.test.spr;

public class MemberList
{
	/*
	 private MssqlDAO dao;
	 
	 public MemberList()
	 {
	   // MemberList 입장에서 의존객체
	    OracleDAO dao = new MssqlDAO();
	 }
	*/
	
	// check~!! 
	// 멤버 변수 추가하는 과정에서 데이터타입은 인터페이스 형식
	// DI 를 위한 준비 작업
	private IDAO dao;
	
	// setter 메소드 추가
	public void setDao(IDAO dao)
	{
		this.dao = dao;
	}
	
	/*
	public MemberList(IDAO dao)
	{
		// MemberList 입장에서 의존객체 OracleDAO
		this.dao = dao;
	}
	*/
	
	
	// print() 메소드 구현
	public void print()
	{
		try
		{
			for (MemberDTO dto : dao.list())
			{
				System.out.printf("%10s %4s %15s %15s%n"
								  , dto.getId(), dto.getName()
								  , dto.getTel(), dto.getEmail());
				
			}
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	
	
	
	
	
	
	
	
	
}
