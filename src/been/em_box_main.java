package been;

public class em_box_main {
	private int num;
	private String id;
	private String name;
	private int price;
	private boolean cpu=false;
	private boolean ram=false;
	private boolean mb=false;
	private boolean vga=false;
	private boolean pow=false;
	private boolean ssd=false;
	private boolean hdd=false;
	public int getNum() {
		return num;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public boolean isCpu() {
		return cpu;
	}
	public boolean isRam() {
		return ram;
	}
	public boolean isMb() {
		return mb;
	}
	public boolean isVga() {
		return vga;
	}
	public boolean isPow() {
		return pow;
	}
	public boolean isSsd() {
		return ssd;
	}
	public boolean isHdd() {
		return hdd;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setCpu(boolean cpu) {
		this.cpu = cpu;
	}
	public void setRam(boolean ram) {
		this.ram = ram;
	}
	public void setMb(boolean mb) {
		this.mb = mb;
	}
	public void setVga(boolean vga) {
		this.vga = vga;
	}
	public void setPow(boolean pow) {
		this.pow = pow;
	}
	public void setSsd(boolean ssd) {
		this.ssd = ssd;
	}
	public void setHdd(boolean hdd) {
		this.hdd = hdd;
	}
}
