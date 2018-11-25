package been;

public class em_cpu {
	private String num;
	private String maker;
	private String codename;
	private String brand;
	private String size;
	private String name;
	private String over;
	public String getName() {
		return name;
	}
	public String getOver() {
		return over;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOver(String over) {
		this.over = over;
	}
	private int price=0;
	private int core=0;
	private int td=0;
	private int l2cashm=0;
	private int l3cashm=0;
	private int tdp=0;
	private int sysbus=0;
	private boolean gpu;

	private double ck=0;
	private double maxck=0;
	public String getNum() {
		return num;
	}
	public String getMaker() {
		return maker;
	}
	public String getCodename() {
		return codename;
	}
	public String getBrand() {
		return brand;
	}
	public String getSize() {
		return size;
	}
	public int getPrice() {
		return price;
	}
	public int getCore() {
		return core;
	}
	public int getTd() {
		return td;
	}
	public int getL2cashm() {
		return l2cashm;
	}
	public int getL3cashm() {
		return l3cashm;
	}
	public int getTdp() {
		return tdp;
	}
	public int getSysbus() {
		return sysbus;
	}
	public boolean isGpu() {
		return gpu;
	}
	public double getCk() {
		return ck;
	}
	public double getMaxck() {
		return maxck;
	}
	public double getTri() {
		return tri;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public void setCodename(String codename) {
		this.codename = codename;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setCore(int core) {
		this.core = core;
	}
	public void setTd(int td) {
		this.td = td;
	}
	public void setL2cashm(int l2cashm) {
		this.l2cashm = l2cashm;
	}
	public void setL3cashm(int l3cashm) {
		this.l3cashm = l3cashm;
	}
	public void setTdp(int tdp) {
		this.tdp = tdp;
	}
	public void setSysbus(int sysbus) {
		this.sysbus = sysbus;
	}
	public void setGpu(boolean gpu) {
		this.gpu = gpu;
	}
	public void setCk(double ck) {
		this.ck = ck;
	}
	public void setMaxck(double maxck) {
		this.maxck = maxck;
	}
	public void setTri(double tri) {
		this.tri = tri;
	}
	private double tri;
}
