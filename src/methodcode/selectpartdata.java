package methodcode;
import service.selectpartdataservice;
import been.*;
public class selectpartdata {
	selectpartdataservice sds=new selectpartdataservice();
	public em_ram selectram(String num,int mm){
		em_ram ram=new em_ram();
		em_part_info partinfo=new em_part_info();
		partinfo=sds.selectramdata(num);
		for(int i=0;i<partinfo.getAr_r().size();i++) {
			if(partinfo.getAr_r().get(i).getMemory()==mm) {
				ram=partinfo.getRb();
				ram.setPrice(partinfo.getAr_r().get(i).getPrice());
				ram.setMm(mm);
				
			}
		}		
		return ram;
	}
	public em_cpu selectcpu(String num){
		em_cpu cpu=new em_cpu();
		
		cpu=sds.selectcpudata(num);
		
		return cpu;
	}
public em_mainboard selectmainboard(String num){
		em_mainboard mainboard=new em_mainboard();
		mainboard=sds.selectmbdata(num);
		return mainboard;
	}

public em_power selectpower(String num){
		em_power power=new em_power();
		power=sds.selectpowerdata(num);
		return power;
	}
public em_vga selectvga(String num,int mm){
		em_vga vga=new em_vga();
		em_part_info partinfo=new em_part_info();
		partinfo=sds.selectvgadata(num);
		for(int i=0;i<partinfo.getAr_v().size();i++) {
			if(partinfo.getAr_v().get(i).getRam_mm()==mm) {
				vga=partinfo.getVb();
				vga.setPrice(partinfo.getAr_v().get(i).getPrice());
				vga.setRam_mm(mm);
				vga.setRam_ck(partinfo.getAr_v().get(i).getRam_bus());
				vga.setRam_bus(partinfo.getAr_v().get(i).getRam_mm());
				vga.setKind("gddr"+partinfo.getAr_v().get(i).getKind());
				vga.setTdp(partinfo.getAr_v().get(i).getTdp());
				vga.setStrp(partinfo.getAr_v().get(i).getStr());
				
				
				
			}
		}	
		return vga;
	}
public em_ssd selectssd(String num,int mm){
		em_ssd ssd=new em_ssd();
		em_part_info partinfo=new em_part_info();
		partinfo=sds.selectssddata(num);
		for(int i=0;i<partinfo.getAr_s().size();i++) {
			if(partinfo.getAr_s().get(i).getMemory()==mm) {
				ssd=partinfo.getSb();
				ssd.setPrice(partinfo.getAr_s().get(i).getPrice());
				ssd.setMemory(mm);
				
			}
		}		
		return ssd;
	}
public em_hdd selecthdd(String num,int mm){
		em_hdd hdd=new em_hdd();
		em_part_info partinfo=new em_part_info();
		partinfo=sds.selecthdddata(num);
		for(int i=0;i<partinfo.getAr_h().size();i++) {
			if(partinfo.getAr_h().get(i).getMemory()==mm) {
				hdd=partinfo.getHb();
				hdd.setPrice(partinfo.getAr_h().get(i).getPrice());
				hdd.setMemory(mm);
				
			}
		}		
		return hdd;
	}
	
	
	
	
}
