package been;

public class em_box_vga {
	private int num;
	private String  vga_num;
	private int ram_mm;
	
	public int getRam_mm() {
		return ram_mm;
	}
	public void setRam_mm(int ram_mm) {
		this.ram_mm = ram_mm;
	}
	public int getNum() {
		return num;
	}
	public String  getVga_num() {
		return vga_num;
	}
	public int getCount() {
		return count;
	}
	public int getPrice() {
		return price;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setVga_num(String  vga_num) {
		this.vga_num = vga_num;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int count;
	private int price;
}
