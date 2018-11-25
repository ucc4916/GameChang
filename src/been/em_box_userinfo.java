package been;

public class em_box_userinfo {
	private em_box_main box=new em_box_main();
	private em_box_ssd ssd=new em_box_ssd();
	private em_box_ram ram=new em_box_ram();
	private em_box_hdd hdd=new em_box_hdd();
	private em_box_power pow=new em_box_power();
	private em_box_cpu cpu=new em_box_cpu();
	private em_box_mainboard mb=new em_box_mainboard();
	private em_box_vga vga=new em_box_vga();
	public em_box_main getBox() {
		return box;
	}
	public em_box_ssd getSsd() {
		return ssd;
	}
	public em_box_ram getRam() {
		return ram;
	}
	public em_box_hdd getHdd() {
		return hdd;
	}
	public em_box_power getPow() {
		return pow;
	}
	public em_box_cpu getCpu() {
		return cpu;
	}
	public em_box_mainboard getMb() {
		return mb;
	}
	public em_box_vga getVga() {
		return vga;
	}
	public void setBox(em_box_main box) {
		this.box = box;
	}
	public void setSsd(em_box_ssd ssd) {
		this.ssd = ssd;
	}
	public void setRam(em_box_ram ram) {
		this.ram = ram;
	}
	public void setHdd(em_box_hdd hdd) {
		this.hdd = hdd;
	}
	public void setPow(em_box_power pow) {
		this.pow = pow;
	}
	public void setCpu(em_box_cpu cpu) {
		this.cpu = cpu;
	}
	public void setMb(em_box_mainboard mb) {
		this.mb = mb;
	}
	public void setVga(em_box_vga vga) {
		this.vga = vga;
	}
}
