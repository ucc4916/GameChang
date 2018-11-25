package dao;

import static db.jdbc.close;

import java.sql.*;
import java.util.*;

import been.*;
import methodcode.*;
import service.boxservice;

	public class emdao {
		private static emdao emdao;
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		
		public static emdao getInstance() {
			if(emdao==null) {
				emdao=new emdao();
			}
			return emdao;
		}
		public void setConnection(Connection con) {
			this.con=con;
		}
		public int getboxnum(String id) {
			int number=0;
			pstmt=null;
			rs=null;
			String num="select max(em_num) from em_main";
			
			try {
				pstmt=con.prepareStatement(num);

				rs=pstmt.executeQuery();
				if(rs.next()) {
					//최대값 구하기
					number=rs.getInt("max(em_num)")+1;
					
					
						
						
				}else {//등록된글이 없을떄 
					number=1;
				}
				System.out.println("번호얻기dao 성공");
			}catch(Exception e) {
				System.out.println("번호얻기dao오류"+e);
				e.printStackTrace();
			}finally {	
					close(pstmt);
					close(rs);
			}
			return number;
		}
		public int createbox(String id,int em_num) {
			int result=0;
			int namenum=0;
			pstmt=null;
			rs=null;
			String num="select count(em_num) from em_main  where id=?";
			;
			
			
			try {
				pstmt=con.prepareStatement(num);
				pstmt.setString(1,id);
				rs=pstmt.executeQuery();
				if(rs.next()) {
				namenum=rs.getInt("count(em_num)");
				System.out.println(namenum);}
				else {namenum=0;}
				pstmt=null;
				rs=null;
				String sql="insert into em_main(em_num,id,em_price,em_name) values("+em_num+",?,0,'견적함"+namenum+"')";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,id);
				System.out.println(sql);
				result=pstmt.executeUpdate();
				System.out.println(result);
				System.out.println("견적함입력 dao 성공");
				String option1="insert into em_cpu values(?,?,?,?,?)";
				pstmt=null;
				pstmt=con.prepareStatement(option1);
				pstmt.setInt(1,em_num);
				pstmt.setString(2,"aa99");
				pstmt.setInt(3,0);
				pstmt.setInt(4,0);
				pstmt.setString(5,id);
				result+=pstmt.executeUpdate();
			option1="insert into em_pow values(?,?,?,?,?)";
			pstmt=null;
			pstmt=con.prepareStatement(option1);
			pstmt.setInt(1,em_num);
			pstmt.setString(2,"aa99");
			pstmt.setInt(3,0);
			pstmt.setInt(4,0);
			pstmt.setString(5,id);
			result+=pstmt.executeUpdate();
			
			
				option1="insert into em_mb values(?,?,?,?,?)";
				pstmt=null;
				pstmt=con.prepareStatement(option1);
				pstmt.setInt(1,em_num);
				pstmt.setString(2,"aa99");
				pstmt.setInt(3,0);
				pstmt.setInt(4,0);
				pstmt.setString(5,id);
				result+=pstmt.executeUpdate();	
			
			
				option1="insert into em_ram values(?,?,?,?,?,?)";
				pstmt=null;
				pstmt=con.prepareStatement(option1);
				pstmt.setInt(1,em_num);
				pstmt.setString(2,"aa99");
				pstmt.setInt(3,0);
				pstmt.setInt(4,0);
				pstmt.setInt(5, 0);
				pstmt.setString(6,id);
				result+=pstmt.executeUpdate();		
			
				option1="insert into em_ssd values(?,?,?,?,?,?)";
				pstmt=null;
				pstmt=con.prepareStatement(option1);
				pstmt.setInt(1,em_num);
				pstmt.setString(2,"aa99");
				pstmt.setInt(3,0);
				pstmt.setInt(4,0);
				pstmt.setInt(5, 0);
				pstmt.setString(6,id);
				result+=pstmt.executeUpdate();
			
				
				option1="insert into em_hdd values(?,?,?,?,?,?)";
				pstmt=null;
				pstmt=con.prepareStatement(option1);
				pstmt.setInt(1,em_num);
				pstmt.setString(2,"aa99");
				pstmt.setInt(3,0);
				pstmt.setInt(4,0);
				pstmt.setInt(5, 0);
				pstmt.setString(6,id);
				result+=pstmt.executeUpdate();
			
				option1="insert into em_vga values(?,?,?,?,?,?)";
			pstmt=null;
			pstmt=con.prepareStatement(option1);
			pstmt.setInt(1,em_num);
			pstmt.setString(2,"aa99");
			pstmt.setInt(3,0);
			pstmt.setInt(4,0);
			pstmt.setInt(5, 0);
			pstmt.setString(6,id);
			result+=pstmt.executeUpdate();
			}catch(Exception e) {
				System.out.println("견적함입력 dao오류"+e);
				e.printStackTrace();
			}finally {	
					close(pstmt);
					
			}
			return result;
		}
		//견적 이름 변경 
		public int changename(String id,int em_num,String name) {
			int result=0;
			pstmt=null;
			rs=null;
			String sql="update em_main set em_name=? where id=? em_num=?";
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setString(1,id);
				pstmt.setInt(1,em_num);
				
				result=pstmt.executeUpdate();
				System.out.println("견적함 이름바꾸기 dao 성공");
			}catch(Exception e) {
				System.out.println("견적함 이름바꾸기 dao오류"+e);
				e.printStackTrace();
			}finally {	
					close(pstmt);
					close(rs);
			}
			return result;
		}
		//견적함 삭제를 위한 
				public int deletebox(int em_num) {
					int result=0;
					pstmt=null;
					String sql="delete from em_main where em_num=?";
					try {
						System.out.println(sql);
						pstmt=con.prepareStatement(sql);
						pstmt.setInt(1,em_num);
						
						result=pstmt.executeUpdate();
						System.out.println("견적함 전체변경1단계 dao 성공");
					}catch(Exception e) {
						System.out.println("견적함 전체변경1단계 dao오류"+e);
						e.printStackTrace();
					}finally {	
							close(pstmt);
							
					}
					return result;
				}
				//견적함 파트 삭제을 위한 테이블 
				public int deletepartbox(String part,int em_num,String part_num) {
					int result=0;
					pstmt=null;
					String sql="delete from em_"+part+" where em_num=? and part_num=?";
					try {
						System.out.println(sql);
						pstmt=con.prepareStatement(sql);
					
						pstmt.setInt(1,em_num);
						pstmt.setString(2,part_num);
						
						
						result=pstmt.executeUpdate();
						System.out.println("견적함 파츠삭제1단계 dao 성공");
					}catch(Exception e) {
						System.out.println("견적함 파츠삭제1단계 dao오류"+e);
						e.printStackTrace();
					}finally {	
							close(pstmt);
							
					}
					return result;
				}
		public em_box_userinfo updatebox(em_box_userinfo emuser) {
			int result=0;
			pstmt=null;
			rs=null;
			String option=" ";
			if(emuser.getBox().isCpu()) {option+=",em_cpu='true'";};
			if(emuser.getBox().isPow()) {option+=",em_pow='true'";}
			if(emuser.getBox().isMb()) {option+=",em_mb='true'";}
			if(emuser.getBox().isRam()) {option+=",em_ram='true'";}
			if(emuser.getBox().isSsd()) {option+=",em_ssd='true'";}
			if(emuser.getBox().isHdd()) {option+=",em_hdd='true'";}
			if(emuser.getBox().isVga()) {option+=",em_vga='true'";}
			
			String sql="update em_main set em_price=?"+option+" where id=? and em_num=?";
			String insertsql="";
			
			try {
				System.out.println(sql);
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,emuser.getBox().getPrice());
				pstmt.setString(2,emuser.getBox().getId());
				pstmt.setInt(3,emuser.getBox().getNum());
				result=pstmt.executeUpdate();
				System.out.println("견적함 전체변경1단계 dao 성공");
			}catch(Exception e) {
				System.out.println("견적함 전체변경1단계 dao오류"+e);
				e.printStackTrace();
			}finally {	
					close(pstmt);
					
			}
			return emuser;
		}
		//견적별 파트추가
public int updateboxpart(em_box_userinfo emuser) {
			
			pstmt=null;
			int price=0;
			int result=0;
			String option;
			
			try {
				
				if(emuser.getBox().isCpu()) {
					option="update em_cpu set em_num=?,cpu_num=?,count=?,price=?  where id=?";
					pstmt=null;
					pstmt=con.prepareStatement(option);
					pstmt.setInt(1,emuser.getBox().getNum());
					pstmt.setString(2,emuser.getCpu().getCpu_num());
					pstmt.setInt(3,emuser.getCpu().getCount());
					pstmt.setInt(4,emuser.getCpu().getPrice());
					pstmt.setString(5,emuser.getBox().getId());
					
					result+=pstmt.executeUpdate();}
				price+=emuser.getCpu().getPrice();
				if(emuser.getBox().isPow()) {
				option="update em_pow set em_num=?,pow_num=?,count=?,price=?  where id=?";
				pstmt=null;
				pstmt=con.prepareStatement(option);
				pstmt.setInt(1,emuser.getBox().getNum());
				pstmt.setString(2,emuser.getPow().getPower_num());
				pstmt.setInt(3,emuser.getPow().getCount());
				pstmt.setInt(4,emuser.getPow().getPrice());
				pstmt.setString(5,emuser.getBox().getId());
				result+=pstmt.executeUpdate();
				price+=emuser.getPow().getPrice();}
				
				if(emuser.getBox().isMb()) {
					option="update em_mb set em_num=?,mb_num=?,count=?,price=?  where id=?";
					pstmt=null;
					pstmt=con.prepareStatement(option);
					pstmt.setInt(1,emuser.getBox().getNum());
					pstmt.setString(2,emuser.getMb().getMb_num());
					pstmt.setInt(3,emuser.getMb().getCount());
					pstmt.setInt(4,emuser.getMb().getPrice());
					pstmt.setString(5,emuser.getBox().getId());
					result+=pstmt.executeUpdate();
					price+=emuser.getMb().getPrice();	
				
				}
				if(emuser.getBox().isRam()) {
					option="update em_ram set em_num=?,ram_num=?,count=?,price=?,mm=?  where id=?";
					pstmt=null;
					pstmt=con.prepareStatement(option);
					pstmt.setInt(1,emuser.getBox().getNum());
					pstmt.setString(2,emuser.getRam().getRam_num());
					pstmt.setInt(3,emuser.getRam().getCount());
					pstmt.setInt(4,emuser.getRam().getPrice());
					pstmt.setInt(5,emuser.getRam().getRam_mm());
					pstmt.setString(6,emuser.getBox().getId());
					result+=pstmt.executeUpdate();
					price+=emuser.getRam().getPrice();}			
				if(emuser.getBox().isSsd()) {
					option="update em_ssd set em_num=?,ssd_num=?,count=?,price=?,mm=?  where id=?";
					pstmt=null;
					pstmt=con.prepareStatement(option);
					pstmt.setInt(1,emuser.getBox().getNum());
					pstmt.setString(2,emuser.getSsd().getSsd_num());
					pstmt.setInt(3,emuser.getSsd().getCount());
					pstmt.setInt(4,emuser.getSsd().getPrice());
					pstmt.setInt(5,emuser.getSsd().getSsd_mm());
					pstmt.setString(6,emuser.getBox().getId());
					result+=pstmt.executeUpdate();
					price+=emuser.getSsd().getPrice();	
				}		
				if(emuser.getBox().isHdd()) {
					
					option="update em_hdd set em_num=?,hdd_num=?,count=?,price=?,mm=?  where id=?";
					pstmt=null;
					pstmt=con.prepareStatement(option);
					pstmt.setInt(1,emuser.getBox().getNum());
					pstmt.setString(2,emuser.getHdd().getHdd_num());
					pstmt.setInt(3,emuser.getHdd().getCount());
					pstmt.setInt(4,emuser.getHdd().getPrice());
					pstmt.setInt(5,emuser.getHdd().getHdd_mm());
					pstmt.setString(6,emuser.getBox().getId());
					result+=pstmt.executeUpdate();
					price+=emuser.getHdd().getPrice();
				}		
				if(emuser.getBox().isVga()) {
				option="update em_vga set em_num=?,vga_num=?,count=?,price=?,mm=?  where id=?";
				pstmt=null;
				pstmt=con.prepareStatement(option);
				pstmt.setInt(1,emuser.getBox().getNum());
				pstmt.setString(2,emuser.getVga().getVga_num());
				pstmt.setInt(3,emuser.getVga().getCount());
				pstmt.setInt(4,emuser.getVga().getPrice());
				pstmt.setInt(5,emuser.getVga().getRam_mm());
				pstmt.setString(6,emuser.getBox().getId());
				result+=pstmt.executeUpdate();
				price+=emuser.getVga().getPrice();}
				
				
				pstmt=null;
				String sql="update em_main set em_price=? where id=? and em_num=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,emuser.getBox().getPrice());
				pstmt.setString(2,emuser.getBox().getId());
				pstmt.setInt(3,emuser.getBox().getNum());
				result+=pstmt.executeUpdate();
				
				System.out.println("각견적 입력 or 수정dao 성공");
			}catch(Exception e) {
				System.out.println("각견적별 입력 or수정 dao오류"+e);
				e.printStackTrace();
			}finally {	
					close(pstmt);
					
			}
			return result;
		}
		//견적함 가져오기
		public ArrayList<em_box_main> selectbox(String id) {
			ArrayList<em_box_main> ar_box=new ArrayList<em_box_main>();
			em_box_main embox;
			
			pstmt=null;
			rs=null;
			String sql="select * from em_main where id=?";
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					embox=new em_box_main();
					embox.setNum(rs.getInt("em_num"));
					embox.setId(id);
					embox.setPrice(rs.getInt("em_price"));
					embox.setName(rs.getString("em_name"));
					if(rs.getString("em_cpu").equals("false")) {
						embox.setCpu(false);
					}else {embox.setCpu(true);}
					if(rs.getString("em_mb").equals("false")) {
						embox.setMb(false);
					}else {embox.setMb(true);}
					if(rs.getString("em_ssd").equals("false")) {
						embox.setSsd(false);
					}else {embox.setSsd(true);}
					if(rs.getString("em_hdd").equals("false")) {
						embox.setHdd(false);
					}else {embox.setHdd(true);}
					if(rs.getString("em_vga").equals("false")) {
						embox.setVga(false);
					}else {embox.setVga(true);}
					if(rs.getString("em_mb").equals("false")) {
						embox.setRam(false);
					}else {embox.setRam(true);}
					if(rs.getString("em_pow").equals("false")) {
						embox.setPow(false);
					}else {embox.setPow(true);}
					
					
					ar_box.add(embox);
					
				}
				
				
		
			}catch(Exception e) {
				System.out.println("견적함 가져오기 dao오류"+e);
				e.printStackTrace();
			}finally {	
					close(pstmt);
					close(rs);
			}
			return ar_box;
		}
	//해당 견적함의 파츠 검색
			public em_box_userinfo selectboxepart(em_box_userinfo emuser) {
				em_box_userinfo emuserout=new em_box_userinfo();
				emuserout.setBox(emuser.getBox());
				
				String option;
				
				try {
					
					if(emuser.getBox().isCpu()) {
						option="select * from em_cpu where em_num=? and id=?";
						pstmt=null;
						pstmt=con.prepareStatement(option);
						pstmt.setInt(1,emuser.getBox().getNum());
						pstmt.setString(2,emuser.getBox().getId());
						rs=pstmt.executeQuery();
						if(rs.next()) {
							emuserout.getCpu().setCpu_num(rs.getString("cpu_num"));
							emuserout.getCpu().setNum(rs.getInt("em_num"));
							emuserout.getCpu().setCount(rs.getInt("count"));
							emuserout.getCpu().setPrice(rs.getInt("price"));
							
						}
						
						
					}
				
					if(emuser.getBox().isPow()) {
						option="select * from em_pow where em_num=? and id=?";
						pstmt=null;
						pstmt=con.prepareStatement(option);
						pstmt.setInt(1,emuser.getBox().getNum());
						pstmt.setString(2,emuser.getBox().getId());
						rs=pstmt.executeQuery();
						if(rs.next()) {
							emuserout.getPow().setPower_num(rs.getString("pow_num"));
							emuserout.getPow().setNum(rs.getInt("em_num"));
							emuserout.getPow().setCount(rs.getInt("count"));
							emuserout.getPow().setPrice(rs.getInt("price"));}}
					
					if(emuser.getBox().isMb()) {
						option="select * from em_mb where em_num=? and id=?";
						pstmt=null;
						pstmt=con.prepareStatement(option);
						pstmt.setInt(1,emuser.getBox().getNum());
						pstmt.setString(2,emuser.getBox().getId());
						rs=pstmt.executeQuery();
						if(rs.next()) {
							emuserout.getMb().setMb_num(rs.getString("mb_num"));
							emuserout.getMb().setNum(rs.getInt("em_num"));
							emuserout.getMb().setCount(rs.getInt("count"));
							emuserout.getMb().setPrice(rs.getInt("price"));}}
					
							
						
				
					if(emuser.getBox().isRam()) {
						option="select * from em_ram where em_num=? and id=?";
						pstmt=null;
						pstmt=con.prepareStatement(option);
						pstmt.setInt(1,emuser.getBox().getNum());
						pstmt.setString(2,emuser.getBox().getId());
						rs=pstmt.executeQuery();
						if(rs.next()) {
							emuserout.getRam().setRam_num(rs.getString("ram_num"));
							emuserout.getRam().setNum(rs.getInt("em_num"));
							emuserout.getRam().setCount(rs.getInt("count"));
							emuserout.getRam().setPrice(rs.getInt("price"));
							emuserout.getRam().setRam_mm(rs.getInt("mm"));}}
					if(emuser.getBox().isSsd()) {
						option="select * from em_ssd where em_num=? and id=?";
						pstmt=null;
						pstmt=con.prepareStatement(option);
						pstmt.setInt(1,emuser.getBox().getNum());
						pstmt.setString(2,emuser.getBox().getId());
						rs=pstmt.executeQuery();
						if(rs.next()) {
							emuserout.getSsd().setSsd_num(rs.getString("ssd_num"));
							emuserout.getSsd().setNum(rs.getInt("em_num"));
							emuserout.getSsd().setCount(rs.getInt("count"));
							emuserout.getSsd().setPrice(rs.getInt("price"));
							emuserout.getSsd().setSsd_mm(rs.getInt("mm"));}}
					if(emuser.getBox().isHdd()) {
						
						option="select * from em_hdd where em_num=? and id=?";
						pstmt=null;
						pstmt=con.prepareStatement(option);
						pstmt.setInt(1,emuser.getBox().getNum());
						pstmt.setString(2,emuser.getBox().getId());
						rs=pstmt.executeQuery();
						if(rs.next()) {
							emuserout.getHdd().setHdd_num(rs.getString("hdd_num"));
							emuserout.getHdd().setNum(rs.getInt("em_num"));
							emuserout.getHdd().setCount(rs.getInt("count"));
							emuserout.getHdd().setPrice(rs.getInt("price"));
							emuserout.getHdd().setHdd_mm(rs.getInt("mm"));}}
					
					if(emuser.getBox().isVga()) {
					option="select * from em_vga where em_num=? and id=?";
					pstmt=null;
					pstmt=con.prepareStatement(option);
					pstmt.setInt(1,emuser.getBox().getNum());
					pstmt.setString(2,emuser.getBox().getId());
					rs=pstmt.executeQuery();
					if(rs.next()) {
						emuserout.getVga().setVga_num(rs.getString("vga_num"));
						emuserout.getVga().setNum(rs.getInt("em_num"));
						emuserout.getVga().setCount(rs.getInt("count"));
						emuserout.getVga().setPrice(rs.getInt("price"));
						emuserout.getVga().setRam_mm(rs.getInt("mm"));}
					
					System.out.println("조회dao 성공");
					}}catch(Exception e) {
					System.out.println("조회dao오류"+e);
					e.printStackTrace();
				}finally {	
					if(pstmt!=null) {
						close(pstmt);}
						close(rs);
				}
				return emuserout;
			
		}
		
		
		
		
		
		//조회 
		public em_cpu selectcpu(String num) {
			System.out.println("cpu 조회");
			em_cpu cb=new em_cpu();
			pstmt=null;
			rs=null;
		
			String sql1="select * from cpu_info_m where cpu_num=?";
			String sql2="select * from cpu_info_e where cpu_num=?";
			try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
			cb.setNum(num);
			cb.setMaker(rs.getString("cpu_maker"));
			cb.setCodename(rs.getString("codename"));
			cb.setBrand(rs.getString("brand"));
			cb.setOver(rs.getString("cpu_over"));
			cb.setName(rs.getString("cpu_name"));
			cb.setSize(rs.getString("cpu_size"));
			cb.setPrice(rs.getInt("price"));
			}
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1,num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
			
			cb.setMaxck(rs.getDouble("cpu_ck_max"));
			cb.setCk(rs.getDouble("cpu_ck"));
			cb.setTd(rs.getInt("cpu_td"));
			cb.setCore(rs.getInt("cpu_core"));
			cb.setL2cashm(rs.getInt("l2cashm"));
			cb.setL3cashm(rs.getInt("l3cashm"));
			boolean gpu=false;
			if(rs.getInt("gpu")==1) {
				gpu=true;
			}
			cb.setGpu(gpu);
			cb.setTdp(rs.getInt("tdp"));
			cb.setTri(rs.getInt("tri"));
			cb.setSysbus(rs.getInt("sysbus"));
			
			}
			
			
			}catch(Exception e) {
				System.out.println("찾기dao오류"+e);
				e.printStackTrace();
				
			}finally {
				close(pstmt);
				close(rs);
			}
			return cb;
		}
		public em_power selectpower(String num) {
			System.out.println("poewr 조회");
			em_power powerbean=new em_power();
			pstmt=null;
			rs=null;
		
			String sql1="select * from pow_info_m where pow_num=?";
		
			try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				powerbean.setNum(num);
				powerbean.setNum(rs.getString("pow_num"));
				powerbean.setMaker(rs.getString("pow_maker"));
				powerbean.setKind(rs.getString("pow_kind"));
				powerbean.setEplus(rs.getString("pow_80plus"));
				powerbean.setPower(rs.getInt("pow_power"));
				powerbean.setFpinide_num(rs.getInt("pow_4pinide_num"));
				powerbean.setSata_num(rs.getInt("pow_sata_num"));
				powerbean.setPcie_num(rs.getInt("pow_pcie_num"));
				powerbean.setPrice(rs.getInt("price"));
			}
			
		
			
			
			}catch(Exception e) {
				System.out.println("찾기dao오류"+e);
				e.printStackTrace();
				
			}finally {
				close(pstmt);
				close(rs);
			}
			return powerbean;
		}
		
		public em_mainboard selectmb(String num) {
			System.out.println("poewr 조회");
			em_mainboard mainboardbean=new em_mainboard();
			pstmt=null;
			rs=null;
		
			String sql1="select m.*,e.usb1gen,e.usb0gen,ps2 from mb_info_m m inner join mb_info_e e on m.mainboard_num=e.mainboard_num   where m.mainboard_num=?";
			
			try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				mainboardbean.setNum(num);
				mainboardbean.setMaker(rs.getString("mainboard_maker"));
				mainboardbean.setName(rs.getString("mainboard_name"));
				mainboardbean.setBrand(rs.getString("mainboard_brand"));
				mainboardbean.setLan(rs.getInt("lan"));
				mainboardbean.setCpu_size(rs.getString("cpu_size"));
				mainboardbean.setChip_group(rs.getString("chip_group"));
				mainboardbean.setChip_group_b(rs.getString("chip_group_b"));
				mainboardbean.setRam_kind(rs.getString("ram_kind"));
				mainboardbean.setPs2(rs.getString("ps2"));
				mainboardbean.setPowertype(rs.getInt("powertype"));
				mainboardbean.setPrice(rs.getInt("price"));
				mainboardbean.setSata3(rs.getInt("sata3"));
				mainboardbean.setSata2(rs.getInt("sata2"));
				mainboardbean.setPcieslot_n(rs.getInt("pcieslot_n"));
				mainboardbean.setPcie3x16_n(rs.getInt("pcie3x16_n"));
				mainboardbean.setPcie3x8_n(rs.getInt("pcie3x8_n"));
				mainboardbean.setPcie3x1_n(rs.getInt("pcie3x1_n"));
				mainboardbean.setPciex6_n(rs.getInt("pciex6_n"));
				mainboardbean.setPciex4_n(rs.getInt("pciex4_n"));
				mainboardbean.setPciex1_n(rs.getInt("pciex1_n"));
				mainboardbean.setRam_ck(rs.getInt("ram_ck"));
				mainboardbean.setRam_mm(rs.getInt("ram_mm"));
				mainboardbean.setRam_mnum(rs.getInt("ram_mnum"));
				mainboardbean.setRam_ch(rs.getInt("ram_ch"));
				
				mainboardbean.setUsb1gen(rs.getInt("usb1gen"));
				mainboardbean.setUsb2gen(rs.getInt("usb0gen"));
			}
			
		
			
			
			}catch(Exception e) {
				System.out.println("찾기dao오류"+e);
				e.printStackTrace();
				
			}finally {
				close(pstmt);
				close(rs);
			}
			return mainboardbean;
			
			
		}
	//조회 옵션이 있는 것들 
	public em_part_info selectvga(String num) {
		System.out.println("vga 조회");
		em_part_info ep=new em_part_info();
		ArrayList<em_vga_spec> arvga=new ArrayList<>();
		em_vga vb=new em_vga();
		em_vga_spec vs=new em_vga_spec();
		pstmt=null;
		rs=null;
		String sql1="select * from vga_info_m where vga_num=?";
		String sql2="select * from vga_info_else where vga_num=?";
		String sql3="select * from vga_info_spec where vga_num=?";
		try {
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,num);
		rs=pstmt.executeQuery();
		if(rs.next()) {
		vb.setNum(num);
		vb.setMaker(rs.getString("vga_maker"));
		vb.setName(rs.getString("vga_name"));
		vb.setItf(rs.getString("vga_interface"));
		vb.setChip(rs.getString("vga_chip"));
		vb.setChipmaker(rs.getString("vga_chipmaker"));
		vb.setChipgroup(rs.getString("vga_chipgroup"));
		vb.setMaxck(rs.getDouble("vga_maxck"));
		vb.setCk(rs.getDouble("vga_ck"));
		vb.setShaders(rs.getInt("shaders"));
		vb.setTmus(rs.getInt("tmus"));
		vb.setRops(rs.getInt("rops"));
		
		}
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1,num);
		rs=pstmt.executeQuery();
		if(rs.next()) {
		
		vb.setShaders(rs.getInt("vga_high"));
		vb.setTmus(rs.getInt("vga_length"));
		vb.setRops(rs.getInt("vga_size"));
		vb.setHdmi(rs.getString("vga_hdmi"));
		
		}
		pstmt = con.prepareStatement(sql3);
		pstmt.setString(1,num);
		rs=pstmt.executeQuery();
		int i=0;
		while(rs.next()) {
		vs=new em_vga_spec();
		vs.setNum(num);
		vs.setRam_ck(rs.getInt("vga_ram_ck"));
		vs.setRam_bus(rs.getInt("vga_ram_bus"));
		vs.setRam_mm(rs.getInt("vga_ram_mm"));
		vs.setKind(rs.getInt("vga_ram_kind"));
		vs.setTdp(rs.getInt("vga_tdp"));
		vs.setStr(rs.getInt("strprocesser"));
		vs.setPrice(rs.getInt("price"));
			
		arvga.add(vs);
		}
		ep.setVb(vb);
		ep.setAr_v(arvga);
		}catch(Exception e) {
			System.out.println("찾기dao오류"+e);
			e.printStackTrace();
			
		}finally {
			close(pstmt);
			close(rs);
		}
		return ep;}
	
	public em_part_info selectram(String num) {
		System.out.println("ram 조회");
		em_part_info ep=new em_part_info();
		ArrayList<em_ram_mm> arram=new ArrayList<>();
		em_ram rb=new em_ram();
		em_ram_mm rm=new em_ram_mm();
		pstmt=null;
		rs=null;
		String sql1="select * from ram_info_m where ram_num=?";
		String sql2="select * from ram_info_e where ram_num=?";
		try {
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,num);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			rb.setNum(num);
			rb.setMaker(rs.getString("ram_maker"));
			rb.setKind(rs.getString("ram_kind"));
			rb.setCk(rs.getInt("ram_ck"));
		
		}
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1,num);
		
		rs=pstmt.executeQuery();
		int i=0;
		while(rs.next()) {
		rm=new em_ram_mm();
		rm.setMemory(rs.getInt("ram_mm"));
		rm.setPrice(rs.getInt("price"));
			
		arram.add(rm);
		i++;
		}
		ep.setRb(rb);
		ep.setAr_r(arram);
		}catch(Exception e) {
			System.out.println("찾기dao오류"+e);
			e.printStackTrace();
			
		}finally {
			close(pstmt);
			close(rs);
		}
		return ep;}
	
	
	public em_part_info selecthdd(String num) {
		System.out.println("hdd 조회");
		em_part_info ep=new em_part_info();
		ArrayList<em_hdd_memory> arhdd=new ArrayList<>();
		em_hdd hb=new em_hdd();
		em_hdd_memory hm=new em_hdd_memory();
		pstmt=null;
		rs=null;
		String sql1="select * from hdd_info_m where hdd_num=?";
		String sql2="select * from hdd_info_e where hdd_num=?";
		try {
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,num);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			hb.setName(rs.getString("name"));
			hb.setMaker(rs.getString("hdd_maker"));
			hb.setKind(rs.getString("hdd_kind"));
			hb.setItf(rs.getString("hdd_interface"));
			hb.setPlatter(rs.getInt("hdd_platter"));
			hb.setDisk_num(rs.getInt("hdd_disk_num"));
			hb.setBuffer_mm(rs.getInt("hdd_buffer_mm"));
			hb.setSize(rs.getDouble("hdd_size"));
		
		}
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1,num);
		
		rs=pstmt.executeQuery();
		int i=0;
		while(rs.next()) {
		hm=new em_hdd_memory();
		hm.setMemory(rs.getInt("hdd_memory"));
		hm.setPrice(rs.getInt("hdd_price"));
			
		arhdd.add(hm);
	
		}
		ep.setHb(hb);
		ep.setAr_h(arhdd);
		}catch(Exception e) {
			System.out.println("찾기dao오류"+e);
			e.printStackTrace();
			
		}finally {
			close(pstmt);
			close(rs);
		}
		return ep;}
	
	public em_part_info selectssd(String num) {
		System.out.println("ssd 조회");
		em_part_info ep=new em_part_info();
		ArrayList<em_ssd_memory> arssd=new ArrayList<>();
		em_ssd sb=new em_ssd();
		em_ssd_memory sm=new em_ssd_memory();
		pstmt=null;
		rs=null;
		String sql1="select * from ssd_info_m where ssd_num=?";
		String sql2="select * from ssd_info_e where ssd_num=?";
		try {
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,num);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			sb.setName(rs.getString("name"));
			sb.setMaker(rs.getString("ssd_maker"));
			sb.setKind(rs.getString("ssd_kind"));
			sb.setRead(rs.getInt("read"));
			sb.setWrite(rs.getInt("write"));
			sb.setRead_iops(rs.getInt("read_iops"));
			sb.setWrite_iops(rs.getInt("write_iops"));
			sb.setDram(rs.getInt("dram"));
		
		}
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1,num);
		
		rs=pstmt.executeQuery();
		int i=0;
		while(rs.next()) {
		sm=new em_ssd_memory();
		sm.setMemory(rs.getInt("ssd_memory"));
		sm.setPrice(rs.getInt("price"));
			
		arssd.add(sm);
		i++;
		}
		ep.setSb(sb);
		ep.setAr_s(arssd);
		}catch(Exception e) {
			System.out.println("찾기dao오류"+e);
			e.printStackTrace();
			
		}finally {
			close(pstmt);
			close(rs);
		}
		return ep;}
	
	
	
	public int inputcpu(em_cpu cb){
		System.out.println("dao cpu입력에 접속");
		me_number mn=new me_number();
		int result=0,result1=0,result2=0;
		String number=null;
		pstmt=null;
		rs=null;
		String num="select max(cpu_num) from cpu_info_m";
		String sql1="insert into cpu_info_m values(?,?,?,?,?,?,?,?)";
		String sql2="insert into cpu_info_e values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(num);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1)!=null) {
					number=mn.number(rs.getString(1));}
					else{System.out.println("rs정보없음");
					number="ca00";}
				}
			pstmt = con.prepareStatement(sql1); 
			
			pstmt.setString(1,number);
			pstmt.setString(2,cb.getMaker());
			pstmt.setString(3,cb.getCodename());
			pstmt.setString(4,cb.getBrand());
			pstmt.setString(5,cb.getSize());
			pstmt.setInt(6,cb.getPrice());
			pstmt.setString(7,cb.getName());
			pstmt.setString(8,cb.getOver());
			result1=pstmt.executeUpdate();
			pstmt = con. prepareStatement(sql2);
			int gpu=0;
			if(cb.isGpu()) {
				gpu=1;
			}
			pstmt.setString(1,number);
			pstmt.setInt(2,cb.getCore());
			pstmt.setInt(3,cb.getTd());
			pstmt.setDouble(4,cb.getCk());
			pstmt.setDouble(5,cb.getMaxck());
			pstmt.setInt(6,cb.getL2cashm());
			pstmt.setInt(7,cb.getL3cashm());
			pstmt.setInt(8,gpu);
			pstmt.setInt(9,cb.getTdp());
			pstmt.setDouble(10,cb.getTri());
			pstmt.setInt(11,cb.getSysbus());
			
			result2=pstmt.executeUpdate();
			result=result1+result2;
			
			}catch(Exception e) {
				System.out.println("emdao오류"+e);
				e.printStackTrace();

			}finally {	
					close(pstmt);
					close(rs);
			}
		return result;
		
	}
	public int inputvga(em_part_info ep){
		System.out.println("dao vga입력에 접속");
		me_number mn=new me_number();
		em_vga vb=ep.getVb();
		int result=0,result1=0,result2=0,result3=0;
		String number=null;
		pstmt=null;
		rs=null;
		String num="select max(vga_num) from vga_info_m";
		String sql1="insert into vga_info_m values(?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2="insert into vga_info_else values(?,?,?,?,?)";
		String sql3="insert into vga_info_spec values(?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(num);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1)!=null) {
					number=mn.number(rs.getString(1));}
					else{System.out.println("rs정보없음");
					number="va00";}
				}
			pstmt = con.prepareStatement(sql1); 
			
			pstmt.setString(1,number);
			pstmt.setString(2,vb.getMaker());
			pstmt.setString(3,vb.getName());
			pstmt.setDouble(4,vb.getCk());
			pstmt.setDouble(5,vb.getMaxck());
			pstmt.setString(6,vb.getItf());
			pstmt.setString(7,vb.getChip());
			pstmt.setString(8,vb.getChipmaker());
			pstmt.setString(9,vb.getChipgroup());
		
			pstmt.setInt(10,vb.getShaders());
			pstmt.setInt(11,vb.getTmus());
			pstmt.setInt(12,vb.getRops());
			
			result1=pstmt.executeUpdate();
			pstmt = con. prepareStatement(sql2);
			
			
			pstmt.setString(1,number);
			pstmt.setInt(2,vb.getHigh());
			pstmt.setInt(3,vb.getLength());
			pstmt.setInt(4,vb.getSize());
			pstmt.setString(5,vb.getHdmi());
			
			result2=pstmt.executeUpdate();
			for(em_vga_spec vs:ep.getAr_v()) {
			pstmt = con. prepareStatement(sql3);
			
			
			pstmt.setString(1,number);
			pstmt.setInt(2,vs.getKind());
			pstmt.setInt(3,vs.getRam_bus());
			pstmt.setInt(4,vs.getRam_ck());
			pstmt.setInt(5,vs.getTdp());
			pstmt.setString(6,vb.getSupport());
			pstmt.setInt(7,vs.getPrice());
			pstmt.setInt(8,vs.getStr());
			pstmt.setInt(9,vs.getRam_mm());
			result3=pstmt.executeUpdate();
			result+=result3;
			}
			result=result1+result2;
			
			}catch(Exception e) {
				System.out.println("vga emdao오류"+e);
				e.printStackTrace();

			}finally {	
					close(pstmt);
					close(rs);
			}
		return result;
		
	}
	public int inputpower(em_power power) {
		System.out.println("dao pow입력에 접속");
		me_number mn=new me_number();
		int result=0;
		rs=null;
		String number=null;
		
		pstmt=null;
		String num="select max(pow_num) from pow_info_m";
		String sql1="insert into pow_info_m values(?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(num);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1)!=null) {
					number=mn.number(rs.getString(1));}
					else{System.out.println("rs정보없음");
					number="pa00";}
				}
		pstmt = con. prepareStatement(sql1);
		
		
		pstmt.setString(1,number);
		pstmt.setString(2,power.getMaker());
		pstmt.setString(3,power.getKind());
		pstmt.setInt(4,power.getPower());
		pstmt.setInt(5,power.getFpinide_num());
		pstmt.setInt(6,power.getSata_num());
		pstmt.setInt(7,power.getPcie_num());
		pstmt.setString(8,power.getEplus());
		pstmt.setInt(9,power.getPrice());
		result=pstmt.executeUpdate();}
		catch(Exception e) {
			System.out.println("pow emdao오류"+e);
			e.printStackTrace();

		}finally {	
				close(pstmt);
				close(rs);
		}
		return result;
	}
	public int inputmainboard(em_mainboard mb) {
		System.out.println("dao pow입력에 접속");
		me_number mn=new me_number();
		int result=0,result1=0;
		String number=null;
		rs=null;
		
		pstmt=null;
		String num="select max(mainboard_num) from mb_info_m";
		String sql1="insert into mb_info_m values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2="insert into mb_info_e values(?,?,?,?)";
		try {
			pstmt=con.prepareStatement(num);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1)!=null) {
					number=mn.number(rs.getString(1));}
					else{System.out.println("rs정보없음");
					number="ma00";}
				}
		pstmt = con. prepareStatement(sql1);
		
		
		pstmt.setString(1,number);
		pstmt.setString(2,mb.getMaker());
		pstmt.setString(3,mb.getName());
		pstmt.setString(4,mb.getBrand());

		pstmt.setInt(5,mb.getPowertype());
		pstmt.setInt(6,mb.getPrice());
		pstmt.setInt(7,mb.getSata3());
		pstmt.setInt(8,mb.getSata2());
		pstmt.setInt(9,mb.getLan());
		
		pstmt.setString(10,mb.getChip_group());
		pstmt.setString(11,mb.getChip_group_b());
		pstmt.setString(12,mb.getCpu_size());
		
		pstmt.setInt(13,mb.getPcieslot_n());
		pstmt.setInt(14,mb.getPcie3x16_n());
		pstmt.setInt(15,mb.getPcie3x8_n());
		pstmt.setInt(16,mb.getPcie3x1_n());
		pstmt.setInt(17,mb.getPciex6_n());
		pstmt.setInt(18,mb.getPciex4_n());
		pstmt.setInt(19,mb.getPciex1_n());
		pstmt.setInt(20,mb.getRam_ck());
		pstmt.setInt(21,mb.getRam_mm());
		pstmt.setInt(22,mb.getRam_mnum());
		pstmt.setInt(23,mb.getRam_ch());
		
		pstmt.setString(24,mb.getRam_kind());
		result1=pstmt.executeUpdate();
		result=+result1;
		pstmt = con. prepareStatement(sql2);
		
		pstmt.setString(1,number);
		pstmt.setInt(2,mb.getUsb1gen());
		pstmt.setInt(3,mb.getUsb2gen());
		pstmt.setString(4,mb.getPs2());
		result1=pstmt.executeUpdate();
		result=+result1;
		}
		catch(Exception e) {
			System.out.println("메인보드 emdao오류"+e);
			e.printStackTrace();

		}finally {	
				close(pstmt);
				close(rs);
		}
		return result;
		
	}
	public int inputram(em_part_info ep) {
		System.out.println("ram입력에 접속");
		em_ram rb=ep.getRb();
	
		me_number mn=new me_number();
		int result=0,result1=0;
		String number=null;
		rs=null;
		pstmt=null;
		String num="select max(ram_num) from ram_info_m";
		String sql1="insert into ram_info_m values(?,?,?,?)";
		String sql2="insert into ram_info_e values(?,?,?)";
		try {
			pstmt=con.prepareStatement(num);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
			
				if(rs.getString(1)!=null) {
				number=mn.number(rs.getString(1));}
				else{System.out.println("rs정보없음");
				number="ra00";}
			}
			
		pstmt = con. prepareStatement(sql1);
		
		
		pstmt.setString(1,number);
		pstmt.setString(2,rb.getMaker());
		pstmt.setString(3,rb.getKind());
		pstmt.setInt(4,rb.getCk());

		
		result1=pstmt.executeUpdate();
		result=+result1;
	
		for(em_ram_mm rs:ep.getAr_r()) {
		pstmt = con. prepareStatement(sql2);
		pstmt.setString(1,number);
		pstmt.setInt(2,rs.getMemory());
		pstmt.setInt(3,rs.getPrice());
		
		result1=pstmt.executeUpdate();
		result=+result1;}
		}
		catch(Exception e) {
			System.out.println("램 emdao오류"+e);
			e.printStackTrace();

		}finally {	
				close(pstmt);
				close(rs);
		}
		return result;
	}
	public int inputhdd(em_part_info ep) {
		System.out.println("hdd입력에 접속");
		me_number mn=new me_number();
		em_hdd hd=ep.getHb();
		int result=0,result1=0;
		String number=null;
		rs=null;
		pstmt=null;
		String num="select max(hdd_num) from hdd_info_m";
		String sql1="insert into hdd_info_m values(?,?,?,?,?,?,?,?,?)";
		String sql2="insert into hdd_info_e values(?,?,?)";
		try {
			pstmt=con.prepareStatement(num);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1)!=null) {
					number=mn.number(rs.getString(1));}
					else{System.out.println("rs정보없음");
					number="ha00";}
				}
		pstmt = con. prepareStatement(sql1);
		
		
		pstmt.setString(1,number);
		pstmt.setString(2,hd.getMaker());
		pstmt.setString(3,hd.getKind());
		pstmt.setString(4,hd.getItf());
		pstmt.setInt(5,hd.getPlatter());
		pstmt.setInt(6,hd.getDisk_num());
		pstmt.setDouble(7,hd.getSize());
		pstmt.setInt(8,hd.getBuffer_mm());
		pstmt.setString(9,hd.getName());
		
		result1=pstmt.executeUpdate();
		result=+result1;
		
		for(em_hdd_memory hm:ep.getAr_h()) {
		pstmt = con. prepareStatement(sql2);
		pstmt.setString(1,number);
		pstmt.setInt(2,hm.getMemory());
		pstmt.setInt(3,hm.getPrice());
		
		result1=pstmt.executeUpdate();
		result=+result1;
		}}
		catch(Exception e) {
			System.out.println("하드emdao오류"+e);
			e.printStackTrace();

		}finally {	
				close(pstmt);
				close(rs);
		}
		return result;
	}
	public int inputssd(em_part_info ep) {
		System.out.println("ssd입력에 접속");
		em_ssd sd=ep.getSb();
		me_number mn=new me_number();
		int result=0,result1=0;
		String number=null;
		rs=null;
		pstmt=null;
		String num="select max(ssd_num) from ssd_info_m";
		String sql1="insert into ssd_info_m values(?,?,?,?,?,?,?,?,?,?)";
		String sql2="insert into ssd_info_e values(?,?,?)";
		try {
			pstmt=con.prepareStatement(num);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1)!=null) {
					number=mn.number(rs.getString(1));}
					else{System.out.println("rs정보없음");
					number="sa00";}
				}
		pstmt = con. prepareStatement(sql1);
		
		
		pstmt.setString(1,number);
		pstmt.setString(2,sd.getMaker());
		pstmt.setString(3,sd.getKind());
		
		pstmt.setInt(4,sd.getRead());
		pstmt.setInt(5,sd.getWrite());
		pstmt.setInt(6,sd.getRead_iops());
		pstmt.setInt(7,sd.getWrite_iops());
		pstmt.setInt(8,sd.getDram());
		pstmt.setInt(9,sd.getLife());
		pstmt.setString(10,sd.getName());
		
		result1=pstmt.executeUpdate();
		result=+result1;
		
		for(em_ssd_memory sm:ep.getAr_s()) {
		pstmt = con. prepareStatement(sql2);
		pstmt.setString(1,number);
		pstmt.setInt(2,sm.getMemory());
		pstmt.setInt(3,sm.getPrice());
		
		System.out.println("dao"+sm.getMemory());
		result1=pstmt.executeUpdate();
		result=+result1;
		}}
		catch(Exception e) {
			System.out.println("ssd emdao오류"+e);
			e.printStackTrace();

		}finally {	
				close(pstmt);
				close(rs);
		}
		return result;
	}
	
	
}
