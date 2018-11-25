package dao;

import static db.jdbc.close;

import java.sql.*;
import java.util.*;

import been.*;
import methodcode.*;

public class benchdao {
   private static benchdao benchdao;
   Connection con;
   PreparedStatement pstmt;
   ResultSet rs;
   public static benchdao getInstance() {
      if(benchdao==null) {
         benchdao=new benchdao();
      }
      return benchdao;
   }
   public void setConnection(Connection con) {
      this.con=con;}
   

   public em_cho_gamespec gamespec(int g_num,int spec) {
      System.out.println("게임 스펙찾기 dao");
      System.out.println(g_num+","+spec);
      
      em_cho_gamespec ecgs=new em_cho_gamespec();
      String sql="select * from spec where specnum=? and game_num=? ";
      String sql1="select * from game where name=?";
      rs=null;
      pstmt=null;
      
      try {
         pstmt=con.prepareStatement(sql);
         pstmt.setInt(1,spec);
         pstmt.setInt(2,g_num);
         rs=pstmt.executeQuery();
         if(rs.next()) {
         ecgs.setGamename(rs.getString("name"));
         ecgs.setSpec(rs.getInt("specnum"));
         ecgs.setVga_shaders(rs.getInt("vga_shaders"));
         ecgs.setVga_tmus(rs.getInt("vga_tmus"));
         ecgs.setVga_rops(rs.getInt("vga_rops"));
         ecgs.setVga_ram(rs.getInt("vga_ram"));
         ecgs.setCpu_core(rs.getInt("cpu_core"));
         ecgs.setCpu_ck(rs.getInt("cpu_ck"));
         ecgs.setCpu_td(rs.getInt("cpu_td"));
         ecgs.setRam_ck(rs.getInt("ram_ck"));
         ecgs.setRam_mm(rs.getInt("ram_mm"));
         ecgs.setVga_ck(rs.getInt("vga_ck"));
         
      
         }
         pstmt=con.prepareStatement(sql1);
         pstmt.setString(1,ecgs.getGamename());
         rs=pstmt.executeQuery();
         if(rs.next()) {
         ecgs.setGamekind(rs.getString("kind"));
         }
      }catch(Exception e) {
         System.out.println("benchdao오류"+e);
         e.printStackTrace();
         
      }finally {
         
         close(pstmt);
         close(rs);
         
      }
         
      
      
      return ecgs;
   }
   
   public em_vga vgaspec(em_cho_gamespec ecgs) {
      em_vga vga=new em_vga();
      System.out.println("해당 사양과 비슷한 그래픽찾기");
     
      String v_num=null;
      
      String sql="";
   
      
      //밴치마킹돌린거
    
      sql="select vga_num from (select vga_num,(sha/(?*?)+tmu/(?*?)+(rop/(?*?))*2)/4 as bench from vga_spec_new)v2 where bench between 0.5 and 1";
      //밴치마킹 돌린거와 넘버 일치하는거
      
      System.out.println(sql);
      pstmt= null;
      rs=null;
      ArrayList<String> vga_numar=new ArrayList<>();
      System.out.println("테스트1:benchvga"+ecgs.getVga_shaders()+","+ecgs.getVga_tmus()+","+ecgs.getVga_rops()+","+ecgs.getVga_ck());
      try {
         
         System.out.println("vga 사양비교");
         pstmt=con.prepareStatement(sql);
      
         pstmt.setInt(1,ecgs.getVga_shaders());
         pstmt.setInt(2,ecgs.getVga_ck());
         pstmt.setInt(3,ecgs.getVga_tmus());
         pstmt.setInt(4,ecgs.getVga_ck());
         pstmt.setInt(5,ecgs.getVga_rops());
         pstmt.setInt(6,ecgs.getVga_ck());
         rs=pstmt.executeQuery();
         
         while(rs.next()) {
         
         vga_numar.add(rs.getString("vga_num"));
         
         
         }
         if(vga_numar.size()==0) {
            sql="select vga_num from vga_spec_new";
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()) {
               
               vga_numar.add(rs.getString("vga_num"));
         }}
         
         
         v_num="'"+vga_numar.get(0)+"'";
         if(vga_numar.size()>1) {
         for(int i=1;i<vga_numar.size();i++) {
            v_num=v_num+","+"'"+vga_numar.get(i)+"'";
            
            
         }}
         String sel="select * from (select rownum as rnum,v2.*  from  (select vga_info_m.*,vga_info_spec.price as price,vga_info_spec.vga_ram_mm as vga_ram_mm  from vga_info_m inner join vga_info_spec on vga_info_m.vga_num =vga_info_spec.vga_num where vga_info_m.vga_num in("+v_num+")  and vga_info_spec.vga_ram_mm >=? and vga_chipmaker='nvidia'  order by vga_info_spec.price asc)v2)  where rnum=1"; 
         System.out.println("최저가선택전 index입력");
         pstmt=con.prepareStatement(sel);
         
         pstmt.setInt(1,ecgs.getVga_ram());
         System.out.println(sel);
         System.out.println(ecgs.getVga_ram());
         rs=pstmt.executeQuery();
         if(rs.next()) {
            System.out.println("vga 최저가선택");
            vga.setNum(rs.getString("vga_num"));
            vga.setRam_mm(rs.getInt("vga_ram_mm"));
            vga.setMaker(rs.getString("vga_maker"));
            vga.setChip(rs.getString("vga_chip"));
            vga.setChipmaker(rs.getString("vga_chipmaker"));
            vga.setChipgroup(rs.getString("vga_chipgroup"));
            vga.setName(rs.getString("vga_name"));
            vga.setPrice(rs.getInt("price"));
            System.out.println(vga.getName());
         }
      }catch(Exception e) {
         System.out.println("benchdao vgaspec오류"+e);
            
         e.printStackTrace();
         
      }finally {
         
         close(pstmt);
         close(rs);
         
      }
      
      
      return vga;
   }
   public em_cpu cpuspec(em_cho_gamespec ecgs,String maker) {
      System.out.println("cpu 스펙dao");
      em_cpu cpu=new em_cpu();
      pstmt=null;
      rs=null;
      
      String sql1="select * from (select rownum as rown,v1.* from (select * from cpu_spec_new where  cpu_core>=? and cpu_ck>=? and cpu_td >=? and maker=? order by price asc)v1) where rown=1";
      try {
         System.out.println("cpu spec 인덱스 입력");
         System.out.println("테스트:cpuspec-"+ecgs.getCpu_ck()+","+ecgs.getCpu_core()+","+ecgs.getCpu_td()+","+maker);
         pstmt=con.prepareStatement(sql1);
         pstmt.setInt(1,ecgs.getCpu_core());
         pstmt.setDouble(2,ecgs.getCpu_ck());
         pstmt.setInt(3,ecgs.getCpu_td());
         pstmt.setString(4,maker);
         
         
         
         rs=pstmt.executeQuery();
         if(rs.next()) {
            System.out.println("cpu 최저가 받아오기 ");
            cpu.setNum(rs.getString("cpu_num"));
            cpu.setCore(rs.getInt("cpu_core"));
            cpu.setName(rs.getString("name"));
            cpu.setCk(rs.getDouble("cpu_ck"));
            cpu.setTd(rs.getInt("cpu_td"));
            cpu.setMaker(rs.getString("maker"));
            cpu.setCodename(rs.getString("code"));
            cpu.setBrand(rs.getString("brand"));
            cpu.setName(rs.getString("name"));
            cpu.setSize(rs.getString("cpu_size"));
            cpu.setPrice(rs.getInt("price"));
            
         }
      }catch(Exception e) {
         System.out.println("benchdao cpuspec오류"+e);
         e.printStackTrace();
         
      }finally {
         close(pstmt);
         close(rs);
         
      }
      return cpu;
   }
   
   public em_ram ramspec(em_cho_gamespec ecgs,int slot) {
      System.out.println("ram 스펙찾기 dao");
      em_ram ram=new em_ram();
      pstmt=null;
      int ram_count=0;
      rs=null;
      String ram_sel=null;
      
         //최저가 램  선택
      
      if(ecgs.getRam_mm()>=16 && slot<=2) {
      ram_count+=Math.ceil(ecgs.getRam_mm()/16);   
      ram_sel="select * from (select rownum rnum,rs.* from ram_spec_new rs where ram_kind='ddr4' and mm=16 order by price ) where rnum=1";
      }
      else {
         ram_count+=Math.ceil(ecgs.getRam_mm()/8);
         if(ecgs.getRam_mm()<8) {
            ram_count=1;
         }
         ram_sel="select * from (select rownum rnum,rs.* from ram_spec_new rs where ram_kind='ddr4' and mm=8 order by price ) where rnum=1";
      }
      
      try {
         pstmt=con.prepareStatement(ram_sel);
         rs=pstmt.executeQuery();
         if(rs.next()) {
            ram.setNum(rs.getString("ram_num"));
            ram.setCount(ram_count);
            ram.setCk(rs.getInt("ram_ck"));
            ram.setMm(rs.getInt("mm"));
            ram.setKind(rs.getString("ram_kind"));
            ram.setMaker(rs.getString("ram_maker"));
            ram.setPrice(rs.getInt("price"));
            }
         
      }catch(Exception e) {
         System.out.println("benchdao ramspec오류"+e);
         e.printStackTrace();
         
      }finally {
         close(pstmt);
         close(rs);
         
      }
      return ram;
      }

   public em_mainboard mbspec(em_cho_gamespec ecgs,String size,int option) {
      System.out.println("메인보드 스펙찾기 dao");
      String maker=null;
      String op=" ";
      if(option==1) {
         maker="'ASROCK'";
      }
      else if(option==2) {
         maker="'msi','gigabyte'";
      }
      else {
         if(size.equals("FM2+")) {maker="'gigabyte'";}
         else {
         maker="'asus'";
         op="and mainboard_name like '%rog%'";}
      }
      em_mainboard mainboardbean=new em_mainboard();
      
      pstmt=null;
      
      rs=null;
      String sql1="select * from (select rownum rnum,m.*,e.usb1gen,e.usb0gen,ps2 from mb_info_m m inner join mb_info_e e on m.mainboard_num=e.mainboard_num   where cpu_size=? and mainboard_maker in("+maker+") "+op+" order by price asc) where rnum=1";
      System.out.println(sql1);
      try {
         System.out.println("메인보드 spec test:"+size+","+maker);
      pstmt = con.prepareStatement(sql1);
      pstmt.setString(1,size);
      
      rs=pstmt.executeQuery();
      if(rs.next()) {
         System.out.println("메인보드가존재");
         mainboardbean.setNum(rs.getString("mainboard_num"));
         mainboardbean.setMaker(rs.getString("mainboard_maker"));
         mainboardbean.setName(rs.getString("mainboard_name"));
         mainboardbean.setBrand(rs.getString("mainboard_brand"));
         mainboardbean.setLan(rs.getInt("lan"));
         mainboardbean.setCpu_size(size);
         mainboardbean.setChip_group(rs.getString("chip_group"));
         mainboardbean.setChip_group_b(rs.getString("chip_group_b"));
         mainboardbean.setRam_kind(rs.getString("ram_kind"));
      
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
         System.out.println(mainboardbean.getBrand());
      }
      }catch(Exception e) {
         System.out.println("benchdao MAINBOARDspec오류"+e);
         e.printStackTrace();
         
      }finally {
         close(pstmt);
         close(rs);
         
      }
      System.out.println("메인보드완료");
      return mainboardbean;
   }
   public em_hdd hddspec(em_cho_gamespec ecgs,int option) {
      System.out.println("하드 스펙찾기 dao");
      em_hdd hdd=new em_hdd();
      int mm=0;
      if(option==1) {
         mm=1;
         
      }
      else if(option==2) {
         mm=2;
      }
      else if(option==3) {
         mm=4;
      }
      String sql1="select * from (select rownum as rnum,a.* from hdd_all a where hdd_maker='wd' and hdd_memory="+mm+" order by price asc) where rnum=1 ";
      try {
      pstmt = con.prepareStatement(sql1);
      rs=pstmt.executeQuery();
      if(rs.next()) {
         hdd.setNum(rs.getString("hdd_num"));
         hdd.setName(rs.getString("name"));
         hdd.setMaker(rs.getString("hdd_maker"));
         hdd.setKind(rs.getString("hdd_kind"));
         hdd.setItf(rs.getString("hdd_interface"));
         hdd.setPlatter(rs.getInt("hdd_platter"));
         hdd.setDisk_num(rs.getInt("hdd_disk_num"));
         hdd.setBuffer_mm(rs.getInt("hdd_buffer_mm"));
         hdd.setSize(rs.getDouble("hdd_size"));
         hdd.setMemory(rs.getInt("hdd_memory"));
         hdd.setPrice(rs.getInt("price"));
            
      }}catch(Exception e) {
         System.out.println("benchdao cpuspec오류"+e);
         e.printStackTrace();
         
      }finally {
         close(pstmt);
         close(rs);
         
      }
      return hdd;
   }
   public em_ssd ssdspec(em_cho_gamespec ecgs) {
      System.out.println("ssd 스펙찾기 dao");
      em_ssd ssd=new em_ssd();
      
      String sql1="select * from (select rownum as rnum,a.* from ssd_all a where ssd_maker in('삼성','wd') order by price asc) where rnum=1 ";
      try {
      pstmt = con.prepareStatement(sql1);
      rs=pstmt.executeQuery();
      if(rs.next()) {
         
         ssd.setName(rs.getString("name"));
         ssd.setMaker(rs.getString("ssd_maker"));
         ssd.setKind(rs.getString("ssd_kind"));
         ssd.setRead(rs.getInt("ssd_read"));
         ssd.setWrite(rs.getInt("ssd_write"));
         ssd.setRead_iops(rs.getInt("ssd_read_iops"));
         ssd.setWrite_iops(rs.getInt("ssd_write_iops"));
         ssd.setDram(rs.getInt("ssd_dram"));
         ssd.setMemory(rs.getInt("ssd_memory"));
         ssd.setPrice(rs.getInt("price"));   
      }}catch(Exception e) {
         System.out.println("benchdao cpuspec오류"+e);
         e.printStackTrace();
         
      }finally {
         close(pstmt);
         close(rs);
         
      }
      return ssd;
   }
   public em_power power(em_cho_gamespec ecgs,double wat) {
      System.out.println("파워 스펙찾기 dao");
      em_power powerbean=new em_power();
      pstmt=null;
      rs=null;
   
      String sql1="select * from pow_info_m where pow_power>?";
   
      try {
      pstmt = con.prepareStatement(sql1);
      pstmt.setDouble(1,wat);
      rs=pstmt.executeQuery();
      if(rs.next()) {
         System.out.println("파워 받아옴");
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
}
   

