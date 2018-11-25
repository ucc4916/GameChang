package been;

public class em_vga_spec {
	private int ram_ck;
	private int ram_bus;
	private int ram_mm;
	private int kind;
	private int tdp;
	private int str;
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	private int price;
	
	private String num;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getRam_ck() {
		return ram_ck;
	}
	public int getRam_bus() {
		return ram_bus;
	}
	public int getRam_mm() {
		return ram_mm;
	}
	public int getKind() {
		return kind;
	}
	public int getTdp() {
		return tdp;
	}
	public int getPrice() {
		return price;
	}
	public void setRam_ck(int ram_ck) {
		this.ram_ck = ram_ck;
	}
	public void setRam_bus(int ram_bus) {
		this.ram_bus = ram_bus;
	}
	public void setRam_mm(int ram_mm) {
		this.ram_mm = ram_mm;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public void setTdp(int tdp) {
		this.tdp = tdp;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
