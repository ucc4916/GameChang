package service;

import static db.jdbc.*;

import java.sql.Connection;

import been.*;
import dao.emdao;

public class selectpartdataservice {
	public em_cpu selectcpudata(String num) {
		System.out.println("cpu 조회 서비스 접속");
		em_cpu cpu=new em_cpu();
		
		emdao dao =emdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		cpu=dao.selectcpu(num);
		close(con);
		return cpu;
	}
	public em_mainboard selectmbdata(String num) {
		System.out.println("메인보드 조회 서비스 접속");
		em_mainboard mainboard=new em_mainboard();
		
		emdao dao =emdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		mainboard=dao.selectmb(num);
		close(con);
		return mainboard;
	}
	public em_power selectpowerdata(String num) {
		System.out.println("파워 조회 서비스 접속");
		em_power power=new em_power();
		
		emdao dao =emdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		power=dao.selectpower(num);
		close(con);
		return power;
	}
	
	
	
public em_part_info selectramdata(String num) {
		System.out.println("ram 조회 서비스 접속");
		em_part_info part=new em_part_info();
		
		emdao dao =emdao.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		part=dao.selectram(num);
		close(con);
		return part;
	}

public em_part_info selecthdddata(String num) {
	System.out.println("hdd 조회 서비스 접속");
	em_part_info part=new em_part_info();
	emdao dao =emdao.getInstance();
	Connection con=getConnection();
	dao.setConnection(con);
	part=dao.selecthdd(num);
	close(con);
	return part;
}
public em_part_info selectssddata(String num) {
	System.out.println("ssd 조회 서비스 접속");
	em_part_info part=new em_part_info();
	emdao dao =emdao.getInstance();
	Connection con=getConnection();
	dao.setConnection(con);
	part=dao.selectssd(num);
	close(con);
	return part;
}

public em_part_info selectvgadata(String num) {
	System.out.println("vga 조회 서비스 접속");
	em_part_info part=new em_part_info();
	emdao dao =emdao.getInstance();
	Connection con=getConnection();
	dao.setConnection(con);
	part=dao.selectvga(num);
	close(con);
	return part;
}}
