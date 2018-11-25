package service;

import static db.jdbc.close;
import static db.jdbc.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import been.*;
import dao.benchdao;

public class benchservice{
	
	public em_cho_gamespec benchsgame(int g_num,int spec){
		System.out.println("사양가져오는 서비스접속");
		benchdao dao =benchdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		
		em_cho_gamespec ecgs=new em_cho_gamespec();
		ecgs=dao.gamespec(g_num,spec);
		System.out.println("진행완료");
		close(con);
		return ecgs;
	}
	public em_cpu benchgamecpu(em_cho_gamespec ecgs,String maker) {
		//해당 사양에 대한 cpu 담을곳 
		benchdao dao =benchdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		em_cpu cpu=dao.cpuspec(ecgs,maker);
		close(con);
		
		return cpu;
	}
	public em_ram benchgameram(em_cho_gamespec ecgs,int slot) {
		//해당 사양에 대한 램 담을곳 
		benchdao dao =benchdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		em_ram ram=dao.ramspec(ecgs,slot);
		
		close(con);
		return ram;
	}
	public em_mainboard benchgamemb(em_cho_gamespec ecgs,String size,int option) {
		//해당 사양에 대한 메인보드 담을곳 
		benchdao dao =benchdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		em_mainboard mb=dao.mbspec(ecgs,size,option);
		
		System.out.println("메인보드 서비스");
		close(con);
		return mb;
	}
	
	public em_ssd benchgamessd(em_cho_gamespec ecgs) {
		//해당 사양에 대한 그래픽 담을곳 
		benchdao dao =benchdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		em_ssd ssd=dao.ssdspec(ecgs);
		close(con);
		
		return ssd;
	}
	public em_vga benchgamevga(em_cho_gamespec ecgs) {
		//해당 사양에 대한 그래픽 담을곳 
		benchdao dao =benchdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		em_vga vga=dao.vgaspec(ecgs);
		close(con);
		
		return vga;
	}
	public em_power benchgamepower(em_cho_gamespec ecgs,double wat) {
		//해당사양 파워담을곳
		benchdao dao =benchdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		em_power power=dao.power(ecgs,wat);
		close(con);
		return power;
	}
	public em_hdd benchgamehdd(em_cho_gamespec ecgs, int hardoption) {
//		
		benchdao dao =benchdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		em_hdd hdd=dao.hddspec(ecgs,hardoption);
		close(con);
		return hdd;
	}
	
	
	
}
