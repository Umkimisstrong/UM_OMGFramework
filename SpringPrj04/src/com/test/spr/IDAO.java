/*
	IDAO.java
	- 인터페이스
*/
package com.test.spr;

import java.sql.SQLException;
import java.util.List;

public interface IDAO
{
	// DAO 공통인자 List<>를 찾고 메소드 선언
	public List<MemberDTO> list() throws ClassNotFoundException, SQLException;
	
	
}
