package been;



public class em_cho_gamespec {
	private int g_num;
	private String gamekind;
	private String gamename;
	private int spec;// 1일경우 최하옵 2일경우 중옵 3일경우 최상옵  4일경우 합친거
	private int vga_shaders;
	private int vga_tmus;
	private int vga_rops;
	private int vga_ram;
	private int vga_ck;
	
	private int cpu_core;
	private double cpu_ck;
	private int cpu_td;
	
	public String getGamekind() {
		return gamekind;
	}
	public void setGamekind(String gamekind) {
		this.gamekind = gamekind;
	}
	public int getG_num() {
		return g_num;
	}
	public void setG_num(int g_num) {
		this.g_num = g_num;
	}
	private int ram_ck;
	private int ram_mm;
	public int getVga_ck() {
		return vga_ck;
	}
	public void setVga_ck(int vga_ck) {
		this.vga_ck = vga_ck;
	}
	public String getGamename() {
		return gamename;
	}
	public int getVga_ram() {
		return vga_ram;
	}
	public void setVga_ram(int vga_ram) {
		this.vga_ram = vga_ram;
	}
	public int getSpec() {
		return spec;
	}
	public int getVga_shaders() {
		return vga_shaders;
	}
	public int getVga_tmus() {
		return vga_tmus;
	}
	public int getVga_rops() {
		return vga_rops;
	}
	public void setVga_shaders(int vga_shaders) {
		this.vga_shaders = vga_shaders;
	}
	public void setVga_tmus(int vga_tmus) {
		this.vga_tmus = vga_tmus;
	}
	public void setVga_rops(int vga_rops) {
		this.vga_rops = vga_rops;
	}
	public int getCpu_core() {
		return cpu_core;
	}
	public double getCpu_ck() {
		return cpu_ck;
	}
	public int getCpu_td() {
		return cpu_td;
	}
	public int getRam_ck() {
		return ram_ck;
	}
	public int getRam_mm() {
		return ram_mm;
	}
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	public void setSpec(int spec) {
		this.spec = spec;
	}

	public void setCpu_core(int cpu_core) {
		this.cpu_core = cpu_core;
	}
	public void setCpu_ck(double cpu_ck) {
		this.cpu_ck = cpu_ck;
	}
	public void setCpu_td(int cpu_td) {
		this.cpu_td = cpu_td;
	}
	public void setRam_ck(int ram_ck) {
		this.ram_ck = ram_ck;
	}
	public void setRam_mm(int ram_mm) {
		this.ram_mm = ram_mm;
	}

	
	
	
	
}
