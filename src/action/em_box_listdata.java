package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import been.*;
import methodcode.selectpartdata;
import service.boxservice;

public class em_box_listdata  implements Action{
	//관리자모드 관리자페이지로 이동안내
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("견적함 리스트");
		HttpSession session=request.getSession();
		
		selectpartdata spd=new selectpartdata();
		String id=(String)session.getAttribute("id");
		//모든 정보 조회를 위해 array list 2개 선언 1개는 작은 부분 나머지하나는 모두포함
		boxservice bsv=new boxservice();
		em_box_userinfo ebui;
		//서비스가 그런식으로 선언해놨고 처음부터 크게할경우 비효율적인부분도 생기며 메소드가 너무길어진다.
		ArrayList<em_box_main> eboxar=bsv.selectbox(id);
		System.out.println(eboxar.get(0).isMb());
		ArrayList<em_box_userinfo> eboxall=new ArrayList<em_box_userinfo>();
		for(int i=0;i<eboxar.size();i++) {
			ebui=new em_box_userinfo();
			//각 작은 부분에대한 모든 파츠정보를 가져옴 
			System.out.println(eboxar.get(i).getId());
			ebui.setBox(eboxar.get(i));
			System.out.println("roop1"+ebui.getBox().isMb());
			eboxall.add(bsv.selectboxpartall(ebui));
			System.out.println("roop2"+eboxall.get(i).getBox().isMb());
		}
		em_cpu cpu=new em_cpu();
		em_ram ram=new em_ram();
		em_mainboard mainboard=new em_mainboard();
		em_vga vga=new em_vga();
		em_power pow=new em_power();
		em_ssd ssd=new em_ssd();
		em_hdd hdd=new em_hdd();
		int i=0;
		for(i=0;i<eboxall.size();i++){
			System.out.println("check2:"+eboxall.get(i).getBox().isMb());
			System.out.println("check1:"+eboxall.get(i).getBox().getName());
		if(eboxall.get(i).getBox().isCpu()){ 
			
			cpu=new em_cpu();
			
			cpu=spd.selectcpu(eboxall.get(i).getCpu().getCpu_num());
	} 
	 if(eboxall.get(i).getBox().isRam()){
		ram=new em_ram();
		ram=spd.selectram(eboxall.get(i).getRam().getRam_num(),eboxall.get(i).getRam().getRam_mm());
	}
	 if(eboxall.get(i).getBox().isMb()){
		 mainboard=new em_mainboard();
		mainboard=spd.selectmainboard(eboxall.get(i).getMb().getMb_num());
	}
	 if(eboxall.get(i).getBox().isVga()){
		vga=new em_vga();
		vga=spd.selectvga(eboxall.get(i).getVga().getVga_num(),eboxall.get(i).getVga().getRam_mm());
	}
	if(eboxall.get(i).getBox().isPow()){
		pow=new em_power();
		pow=spd.selectpower(eboxall.get(i).getPow().getPower_num());
	}
	 if(eboxall.get(i).getBox().isSsd()){
		ssd=new em_ssd();
		ssd=spd.selectssd(eboxall.get(i).getSsd().getSsd_num(),eboxall.get(i).getSsd().getSsd_mm());
	}
	if(eboxall.get(i).getBox().isHdd()){
		hdd=new em_hdd();
		hdd=spd.selecthdd(eboxall.get(i).getHdd().getHdd_num(),eboxall.get(i).getHdd().getHdd_mm());
	}
		
		
		
		em_part_info epi=new em_part_info();
		epi.setCpu(cpu);
		epi.setMb(mainboard);
		epi.setPow(pow);
		epi.setHb(hdd);
		epi.setSb(ssd);
		epi.setRb(ram);
		epi.setVb(vga);
		
	
		request.setAttribute("part"+i,epi);
		System.out.println(epi.getCpu().getCodename());
	}
		
		request.setAttribute("arbox", eboxall);
		forward = new ActionForward();
		forward.setPath("em_first_main/em_box_main.jsp");
		
		
		return forward;
	}
	
}
	
