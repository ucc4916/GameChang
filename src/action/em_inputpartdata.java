package action;

import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import been.actionforward;
import been.em_cpu;
import been.em_vga;
import been.em_vga_spec;
import service.inputpartdatabase;
import been.*;
public class em_inputpartdata implements Action {

	@SuppressWarnings("null")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean result=false;
		em_part_info ep;
		ActionForward forward=null;
		System.out.println(request.getParameter("part"));
		inputpartdatabase ippdb;
		if("cpu".equals(request.getParameter("part"))) {
			ippdb=new inputpartdatabase();
			
			em_cpu cpubean=new em_cpu();
			
			System.out.println("cpu 입력 action");
			cpubean.setMaker((String)request.getParameter("maker"));
			cpubean.setCodename((String)request.getParameter("codename"));
			cpubean.setBrand((String)request.getParameter("brand"));
			cpubean.setName((String)request.getParameter("name"));
			cpubean.setOver((String)request.getParameter("over"));
			cpubean.setSize((String)request.getParameter("size"));
			cpubean.setPrice(Integer.parseInt(request.getParameter("price")));
			cpubean.setCore(Integer.parseInt(request.getParameter("core")));
			cpubean.setTd(Integer.parseInt(request.getParameter("td")));
			cpubean.setL2cashm(Integer.parseInt(request.getParameter("l2cashm")));
			cpubean.setL3cashm(Integer.parseInt(request.getParameter("l3cashm")));
			cpubean.setTdp(Integer.parseInt(request.getParameter("tdp")));
			cpubean.setCk(Double.parseDouble(request.getParameter("ck")));
			cpubean.setSysbus(Integer.parseInt(request.getParameter("sysbus")));
			cpubean.setMaxck(Double.parseDouble(request.getParameter("maxck")));
			
			cpubean.setGpu(Boolean.parseBoolean(request.getParameter("gpu")));
			
		result=ippdb.inputcpudata(cpubean);
			
		}
		else if("vga".equals(request.getParameter("part"))) {
			ippdb=new inputpartdatabase();
			ep=new em_part_info();
			ArrayList<em_vga_spec> ar=new ArrayList<>();
			
			em_vga vb=new em_vga();
			em_vga_spec vs=new em_vga_spec();
			System.out.println("vga 입력 action");
			vb.setMaker((String)request.getParameter("maker"));
			vb.setName((String)request.getParameter("name"));
			vb.setItf((String)request.getParameter("itf"));
			vb.setChip((String)request.getParameter("chip"));
			vb.setChipmaker((String)request.getParameter("chipmaker"));
			vb.setChipgroup((String)request.getParameter("chipgroup"));
			vb.setSupport((String)request.getParameter("support"));
			vb.setShaders(Integer.parseInt(request.getParameter("shaders")));
			vb.setTmus(Integer.parseInt(request.getParameter("tmus")));
			vb.setRops(Integer.parseInt(request.getParameter("rops")));
			vb.setKind((String)request.getParameter("kind"));
			vb.setHigh(Integer.parseInt(request.getParameter("high")));
			vb.setLength(Integer.parseInt(request.getParameter("length")));
			vb.setSize(Integer.parseInt(request.getParameter("size")));
			vb.setHdmi((String)request.getParameter("hdmi"));
			
			vb.setCk(Double.parseDouble(request.getParameter("ck")));
			vb.setMaxck(Double.parseDouble(request.getParameter("maxck")));
			
				
			for(int i=1;i<=Integer.parseInt(request.getParameter("option"));i++){	
			vs=new em_vga_spec();
			vs.setRam_ck(Integer.parseInt(request.getParameter("ram_ck"+i)));
			vs.setRam_bus(Integer.parseInt(request.getParameter("ram_bus"+i)));
			vs.setRam_mm(Integer.parseInt(request.getParameter("ram_mm"+i)));
			vs.setKind(Integer.parseInt(request.getParameter("kind"+i)));
			vs.setStr(Integer.parseInt(request.getParameter("str"+i)));
			vs.setPrice(Integer.parseInt(request.getParameter("price"+i)));
			vs.setTdp(Integer.parseInt(request.getParameter("tdp"+i)));
			ar.add( vs);}
			ep.setVb(vb);
			ep.setAr_v(ar);
			result=ippdb.inputvgadata(ep);
			if(result) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('입력성공')");
				out.println("self.close()</script>");
			}
			else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('입력실패')");
				out.println("history.back()</script>");
			}
		}
		else if("power".equals(request.getParameter("part"))) {
			em_power powerbean=new em_power();
			
			ippdb=new inputpartdatabase();
			System.out.println("power입력");
			powerbean.setNum((String)request.getParameter("num"));
			powerbean.setMaker((String)request.getParameter("maker"));
			powerbean.setKind((String)request.getParameter("kind"));
			powerbean.setEplus((String)request.getParameter("eplus"));
			powerbean.setPower(Integer.parseInt(request.getParameter("power")));
			powerbean.setFpinide_num(Integer.parseInt(request.getParameter("fpinide_num")));
			powerbean.setSata_num(Integer.parseInt(request.getParameter("sata_num")));
			powerbean.setPcie_num(Integer.parseInt(request.getParameter("pcie_num")));
			powerbean.setPrice(Integer.parseInt(request.getParameter("price")));
			result=ippdb.inputpowerdata(powerbean);
		
		
		}
		else if("mainboard".equals(request.getParameter("part"))) {
			ippdb=new inputpartdatabase();
			System.out.println("메인보드입력");
			em_mainboard mainboardbean=new em_mainboard();
			mainboardbean.setMaker((String)request.getParameter("maker"));
			mainboardbean.setName((String)request.getParameter("name"));
			mainboardbean.setBrand((String)request.getParameter("brand"));
			mainboardbean.setLan(Integer.parseInt(request.getParameter("lan")));
			mainboardbean.setCpu_size((String)request.getParameter("cpu_size"));
			mainboardbean.setChip_group((String)request.getParameter("chip_group"));
			mainboardbean.setChip_group_b((String)request.getParameter("chip_group_b"));
			mainboardbean.setRam_kind((String)request.getParameter("ram_kind"));
			mainboardbean.setPs2((String)request.getParameter("ps2"));
			mainboardbean.setPowertype(Integer.parseInt(request.getParameter("powertype")));
			mainboardbean.setPrice(Integer.parseInt(request.getParameter("price")));
			mainboardbean.setSata3(Integer.parseInt(request.getParameter("sata3")));
			mainboardbean.setSata2(Integer.parseInt(request.getParameter("sata2")));
			mainboardbean.setPcieslot_n(Integer.parseInt(request.getParameter("pcieslot_n")));
			mainboardbean.setPcie3x16_n(Integer.parseInt(request.getParameter("pcie3x16_n")));
			mainboardbean.setPcie3x8_n(Integer.parseInt(request.getParameter("pcie3x8_n")));
			mainboardbean.setPcie3x1_n(Integer.parseInt(request.getParameter("pcie3x1_n")));
			mainboardbean.setPciex6_n(Integer.parseInt(request.getParameter("pciex6_n")));
			mainboardbean.setPciex4_n(Integer.parseInt(request.getParameter("pciex4_n")));
			mainboardbean.setPciex1_n(Integer.parseInt(request.getParameter("pciex1_n")));
			mainboardbean.setRam_ck(Integer.parseInt(request.getParameter("ram_ck")));
			mainboardbean.setRam_mm(Integer.parseInt(request.getParameter("ram_mm")));
			mainboardbean.setRam_mnum(Integer.parseInt(request.getParameter("ram_mnum")));
			mainboardbean.setRam_ch(Integer.parseInt(request.getParameter("ram_ch")));
			mainboardbean.setM2_num(Integer.parseInt(request.getParameter("m2_num")));
			mainboardbean.setUsb1gen(Integer.parseInt(request.getParameter("usb1gen")));
			mainboardbean.setUsb2gen(Integer.parseInt(request.getParameter("usb2gen")));
			result=ippdb.inputmainboarddata(mainboardbean);
		
		}
		else if("ram".equals(request.getParameter("part"))) {
			ippdb=new inputpartdatabase();
			System.out.println("램입력");
			ep=new em_part_info();
			ArrayList<em_ram_mm> ar=new ArrayList<>();
			em_ram rb=new em_ram();
			em_ram_mm rm;
			rb.setMaker((String)request.getParameter("maker"));
			rb.setKind((String)request.getParameter("kind"));
			rb.setCk(Integer.parseInt(request.getParameter("ck")));
			for(int i=1;i<=Integer.parseInt(request.getParameter("option"));i++){	
			rm=new em_ram_mm();
			rm.setMemory(Integer.parseInt(request.getParameter("memory"+i)));
			rm.setPrice(Integer.parseInt(request.getParameter("price"+i)));
			ar.add(rm);
			System.out.println(ar.get(i-1));}
			ep.setRb(rb);
			ep.setAr_r(ar);
			result=ippdb.inputramdata(ep);
			
		}
		else if("hdd".equals(request.getParameter("part"))) {
			ippdb=new inputpartdatabase();
			System.out.println("하드입력");
			ep=new em_part_info();
			ArrayList<em_hdd_memory> ar=new ArrayList<>();
			em_hdd hb=new em_hdd();
			em_hdd_memory hm;
			hb.setMaker((String)request.getParameter("maker"));
			hb.setName((String)request.getParameter("name"));
			hb.setKind((String)request.getParameter("kind"));
			hb.setItf((String)request.getParameter("itf"));
			hb.setPlatter(Integer.parseInt(request.getParameter("platter")));
			hb.setDisk_num(Integer.parseInt(request.getParameter("disk_num")));
			hb.setBuffer_mm(Integer.parseInt(request.getParameter("buffer_mm")));
			hb.setSize(Double.parseDouble(request.getParameter("size")));
			for(int i=1;i<=Integer.parseInt(request.getParameter("option"));i++){	
				hm=new em_hdd_memory();
				hm.setMemory(Integer.parseInt(request.getParameter("memory"+i)));
			hm.setPrice(Integer.parseInt(request.getParameter("price"+i)));
			ar.add(hm);
			}
			
			ep.setHb(hb);
			ep.setAr_h(ar);
			result=ippdb.inputhdddata(ep);
			
		}
		else if("ssd".equals(request.getParameter("part"))) {
			ippdb=new inputpartdatabase();
			System.out.println("ssd입력");
			ep=new em_part_info();
			ArrayList<em_ssd_memory> ar=new ArrayList<>();
			em_ssd sb=new em_ssd();
			em_ssd_memory sm;
			sb.setMaker((String)request.getParameter("maker"));
			sb.setKind((String)request.getParameter("kind"));
			sb.setName((String)request.getParameter("name"));
			sb.setRead(Integer.parseInt(request.getParameter("read")));
			sb.setWrite(Integer.parseInt(request.getParameter("write")));
			sb.setRead_iops(Integer.parseInt(request.getParameter("read_iops")));
			sb.setWrite_iops(Integer.parseInt(request.getParameter("write_iops")));
			sb.setDram(Integer.parseInt(request.getParameter("dram")));
			for(int i=1;i<=Integer.parseInt(request.getParameter("option"));i++){	
			sm=new em_ssd_memory();
			sm.setMemory(Integer.parseInt(request.getParameter("memory"+i)));
			sm.setPrice(Integer.parseInt(request.getParameter("price"+i)));
			System.out.println("action"+sm.getMemory());
			ar.add(sm);}
			ep.setSb(sb);
			ep.setAr_s(ar);
			 result=ippdb.inputssddata(ep);
			
		}
		if(result) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('입력성공')");
			out.println("self.close()</script>");
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('DAO넘어오기실패')");
			out.println("history.back()</script>");
		}
	
		return forward;
	}
	}
