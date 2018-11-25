package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import been.*;
import bean.*;
import methodcode.*;
import service.*;
public class em_box_choinputdata implements Action{
	//관리자모드 관리자페이지로 이동안내
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	System.out.println("추천입력페이지");
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	HttpSession session=request.getSession();
	ActionForward forward=null;
	String id=(String)session.getAttribute("id");//정보를 입력하기위해 아이디값받아옴
	int num=Integer.parseInt(request.getParameter("boxnum"));
	selectpartdata mc=new selectpartdata();
	boxservice bsv=new boxservice(); 
	em_box_userinfo main= new em_box_userinfo();  
	
	
	//amd를 선택했는지 intel을 선택했는지 확인
	String cpucho=request.getParameter("cpu");
	String partnum[]=request.getParameterValues(cpucho);
	//해당 나눠지는 파트 번호가져옴
	String partcount[]=request.getParameterValues("partcount");
	//파츠수 가져옴
	
	int rammm=Integer.parseInt(request.getParameter(cpucho+"ram"));
	//램의 메모리가져옴
	int allprice=Integer.parseInt(request.getParameter(cpucho+"price"));
	String partelse[]=request.getParameterValues("elsepart");
	System.out.println(partelse.length);
	String elsenum[]=request.getParameterValues("elsecount");
	System.out.println(elsenum.length);
	int vgamm=Integer.parseInt(request.getParameter("elsepartvga"));
	int hddmm=0;
	int ssdmm=0;
	if(!(request.getParameter("elseparthdd").equals(""))) {
		hddmm=Integer.parseInt(request.getParameter("elseparthdd"));
	}
	if(!(request.getParameter("elsepartssd").equals(""))) {
	ssdmm=Integer.parseInt(request.getParameter("elsepartssd"));
	}

	
	//해당을 각부품별로 분류 
	//각 부품 인덱스 번호를 같게두었음 
	
	for(int i=0;i<partnum.length;i++) {
		if(partnum[i].substring(0,1).equals("c")) {
			String cpunum=partnum[i];
			if(!partcount[i].equals("0")) {
				main.getBox().setCpu(true);
				em_box_cpu cpu_box=new em_box_cpu();
				cpu_box.setNum(num);
				cpu_box.setCpu_num(cpunum);
				cpu_box.setCount(Integer.parseInt(partcount[i]));
				cpu_box.setPrice(cpu_box.getCount()*mc.selectcpu(partnum[i]).getPrice());
				main.setCpu(cpu_box);
			}
		}else if(partnum[i].substring(0,1).equals("m")) {
			String mainnum=partnum[i];
			if(!partcount[i].equals("0")) {
				main.getBox().setMb(true);
				em_box_mainboard mb_box=new em_box_mainboard();
				mb_box.setNum(num);
				mb_box.setMb_num(mainnum);
				mb_box.setCount(Integer.parseInt(partcount[i]));
				mb_box.setPrice(mb_box.getCount()*mc.selectmainboard(partnum[i]).getPrice());
				main.setMb(mb_box);
			}
		}else if(partnum[i].substring(0,1).equals("r")) {
			String ramnum=partnum[i];
			if(!(partcount[i].equals("0"))) {
				main.getBox().setRam(true);
				em_box_ram ram_box=new em_box_ram();
				ram_box.setNum(num);
				ram_box.setRam_num(ramnum);
				ram_box.setCount(Integer.parseInt(partcount[i]));
				ram_box.setPrice(mc.selectram(ramnum, rammm).getPrice()*ram_box.getCount());
				ram_box.setRam_mm(rammm);
				main.setRam(ram_box);
			}}
		}
	
	
	for(int i=0;i<partelse.length;i++) {
		System.out.println(partelse[i].substring(0,1));
		if(partelse[i].substring(0,1).equals("v")) {
		String vganum=partelse[i];
			if(!elsenum[i].equals("0")) {
			main.getBox().setVga(true);
			em_box_vga vga_box=new em_box_vga();
			vga_box.setNum(num);
			vga_box.setVga_num(vganum);
			vga_box.setCount(Integer.parseInt(elsenum[i]));
			vga_box.setPrice(mc.selectvga(vganum, vgamm).getPrice()*vga_box.getCount());
			vga_box.setRam_mm(vgamm);
			main.setVga(vga_box);
		}}
		else if(partelse[i].substring(0,1).equals("h")) {
			String hddnum=partelse[i];
			if(!(elsenum[i].equals("0"))) {
				main.getBox().setHdd(true);
				em_box_hdd hdd_box=new em_box_hdd();
				hdd_box.setNum(num);
				hdd_box.setHdd_num(hddnum);
				hdd_box.setCount(Integer.parseInt(elsenum[i]));
				hdd_box.setPrice(mc.selecthdd(hddnum, hddmm).getPrice()*hdd_box.getCount());
				hdd_box.setHdd_mm(hddmm);
				main.setHdd(hdd_box);
			}}
		else if(partelse[i].substring(0,1).equals("s")) {
			String ssdnum=partelse[i];
			if(!(elsenum[i].equals("0"))) {
				main.getBox().setSsd(true);
				em_box_ssd ssd_box=new em_box_ssd();
				ssd_box.setNum(num);
				ssd_box.setSsd_num(ssdnum);
				ssd_box.setCount(Integer.parseInt(elsenum[i]));
				ssd_box.setPrice(mc.selectssd(ssdnum, ssdmm).getPrice()*ssd_box.getCount());
				ssd_box.setSsd_mm(ssdmm);
				main.setSsd(ssd_box);
			}}
		else if(partelse[i].substring(0,1).equals("p")) {
		String powernum=partelse[i];
		if(!(elsenum[i].equals("0"))) {
			main.getBox().setPow(true);
			em_box_power pow_box=new em_box_power();
			pow_box.setNum(num);
			pow_box.setPower_num(powernum);
			pow_box.setCount(Integer.parseInt(elsenum[i]));
			pow_box.setPrice(pow_box.getCount()*mc.selectpower(partelse[i]).getPrice());
			main.setPow(pow_box);
		}
		}}
	main.getBox().setId(id);
	main.getBox().setNum(num);
	main.getBox().setPrice(allprice);
	boolean result=bsv.updateboxpart(main);
	
	if(result) {
		System.out.println("추천 받은 견적에 있는 정보 입력 성공");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('견적함에 입력성공')");
		out.println("history.back()</script>");
		
	}
	else {
		System.out.println("추천받은 견적 입력 실패");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('입력실패')");
		out.println("history.back()</script>");
	}
	
	
		
		
	
	
	return forward;
}

}
