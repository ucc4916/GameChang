package been;

import java.util.ArrayList;

public class em_part_info {
	
	private em_mainboard mb=new em_mainboard();
	private em_cpu cpu=new em_cpu();
	private em_power pow=new em_power();
	private em_hdd hb=new em_hdd();
	private em_ram rb=new em_ram();
	private em_ssd sb=new em_ssd();
	private em_vga vb=new em_vga();
	private ArrayList<em_vga_spec> ar_v=new ArrayList<em_vga_spec>();
	private ArrayList<em_ram_mm> ar_r=new ArrayList<em_ram_mm>();
	private ArrayList<em_hdd_memory> ar_h=new ArrayList<em_hdd_memory>();
	private ArrayList<em_ssd_memory> ar_s=new ArrayList<em_ssd_memory>();
	public em_hdd getHb() {
		return hb;
	}
	
	public em_mainboard getMb() {
		return mb;
	}

	public em_cpu getCpu() {
		return cpu;
	}

	public em_power getPow() {
		return pow;
	}

	public void setMb(em_mainboard mb) {
		this.mb = mb;
	}

	public void setCpu(em_cpu cpu) {
		this.cpu = cpu;
	}

	public void setPow(em_power pow) {
		this.pow = pow;
	}

	public em_ram getRb() {
		return rb;
	}
	public em_ssd getSb() {
		return sb;
	}


	public em_vga getVb() {
		return vb;
	}
	public ArrayList<em_vga_spec> getAr_v() {
		return ar_v;
	}
	public ArrayList<em_ram_mm> getAr_r() {
		return ar_r;
	}
	public ArrayList<em_hdd_memory> getAr_h() {
		return ar_h;
	}
	public ArrayList<em_ssd_memory> getAr_s() {
		return ar_s;
	}
	public void setHb(em_hdd hb) {
		this.hb = hb;
	}
	public void setRb(em_ram rb) {
		this.rb = rb;
	}
	public void setSb(em_ssd sb) {
		this.sb = sb;
	}
	
	public void setVb(em_vga vb) {
		this.vb = vb;
	}
	public void setAr_v(ArrayList<em_vga_spec> ar_v) {
		this.ar_v = ar_v;
	}
	public void setAr_r(ArrayList<em_ram_mm> ar_r) {
		this.ar_r = ar_r;
	}
	public void setAr_h(ArrayList<em_hdd_memory> ar_h) {
		this.ar_h = ar_h;
	}
	public void setAr_s(ArrayList<em_ssd_memory> ar_s) {
		this.ar_s = ar_s;
	}
	
}
