package service;

import java.util.ArrayList;
import dao.emdao;
import java.sql.Connection;
import static db.jdbc.*;
import been.*;

public class boxservice {
	public ArrayList<em_box_main> selectbox(String id) {
		System.out.println("모든 견적함 조회 서비스 접속");
		ArrayList<em_box_main> em_box=new ArrayList<em_box_main>();
		
		emdao dao =emdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		em_box=dao.selectbox(id);
		close(con);
		return em_box;
	
	}
	//전체적인 정보변경
	public boolean updateboxpart(em_box_userinfo emuser) {
		System.out.println("견적함 정보변경 서비스 접속");
		boolean result=false;
		
		emdao dao =emdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		emuser=dao.updatebox(emuser);
		int i=dao.updateboxpart(emuser);
		
		if(i>0) {
			commit(con);
			result=true;
		}else {rollback(con);}
		close(con);
		return result;
	
	}
	public boolean deletebox(int em_num) {
		System.out.println("견적함 삭제 서비스 접속");
		boolean result=false;
		
		emdao dao =emdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		int i=dao.deletebox(em_num);
		
		
		if(i>0) {
			commit(con);
			result=true;
		}else {rollback(con);}
		close(con);
		return result;
	
	}
	
	//견적함 삭제
	public boolean deleteboxpart(String part,int em_num,String part_num) {
		System.out.println("견적함 파츠삭제 서비스 접속");
		boolean result=false;
		
		emdao dao =emdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		int i=dao.deletepartbox(part,em_num,part_num);
		
		
		if(i>0) {
			commit(con);
			result=true;
		}else {rollback(con);}
		close(con);
		return result;
	
	}
	
	public boolean changename(String id,int em_num,String name) {
		System.out.println("견적함 이름변경 서비스 접속");
		boolean result=false;
		
		emdao dao =emdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		int i=dao.changename(id,em_num,name);
		if(i>0) {
			commit(con);
			result=true;
		}else {rollback(con);}
		close(con);
		return result;
	
	}
	public boolean createbox(String id) {
		System.out.println("견적함 만들기 서비스 접속");
		boolean result=false;
		
		emdao dao =emdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		int num=dao.getboxnum(id);
		int i=dao.createbox(id,num);
		System.out.println(i);
		if(i>0) {
			commit(con);
			System.out.println("커밋완료");
			result=true;
		}
		else {
			rollback(con);
		}
		close(con);
		return result;
	
	}
	// 부품이 boolean으로 정해진 데이터로 파츠검색
	public em_box_userinfo selectboxpartall(em_box_userinfo emuserout) {
		System.out.println("견적함모든부품 검색서비스");
		emdao dao =emdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		emuserout=dao.selectboxepart(emuserout);
		
		
		close(con);
		return emuserout;
	}
	


}

