package been;
import java.sql.Date;

public class em_vga {
	private String num;
	private String maker;
	private String name;
	private String itf;
	private String chip;
	private String chipmaker;
	private String chipgroup;
	private String support;
	private int shaders=0;
	private int tmus=0;
	private int rops=0;
	private	String kind;
	private int ram_bus=0;
	private int ram_ck=0;
	private int ram_mm=0;
	private int tdp=0;
	private int price=0;
	private int high=0;
	private int length=0;
	private int size=0;
	private String hdmi;
	private int strp=0;
	
	private double ck;
	private double maxck;
	private Date birth; 
	public int getStrp() {
		return strp;
	}
	public int getRam_mm() {
		return ram_mm;
	}
	public void setRam_mm(int ram_mm) {
		this.ram_mm = ram_mm;
	}
	public void setStrp(int strp) {
		this.strp = strp;
	}
	public String getNum() {
		return num;
	}
	public String getMaker() {
		return maker;
	}
	public String getName() {
		return name;
	}
	public String getItf() {
		return itf;
	}
	public String getChip() {
		return chip;
	}
	public String getChipmaker() {
		return chipmaker;
	}
	public String getChipgroup() {
		return chipgroup;
	}
	public String getSupport() {
		return support;
	}
	public int getShaders() {
		return shaders;
	}
	public int getTmus() {
		return tmus;
	}
	public int getRops() {
		return rops;
	}
	public String getKind() {
		return kind;
	}
	public int getRam_bus() {
		return ram_bus;
	}
	public int getRam_ck() {
		return ram_ck;
	}
	public int getTdp() {
		return tdp;
	}
	public int getPrice() {
		return price;
	}
	public int getHigh() {
		return high;
	}
	public int getLength() {
		return length;
	}
	public int getSize() {
		return size;
	}
	public String getHdmi() {
		return hdmi;
	}
	public double getCk() {
		return ck;
	}
	public double getMaxck() {
		return maxck;
	}
	public Date getBirth() {
		return birth;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setItf(String itf) {
		this.itf = itf;
	}
	public void setChip(String chip) {
		this.chip = chip;
	}
	public void setChipmaker(String chipmaker) {
		this.chipmaker = chipmaker;
	}
	public void setChipgroup(String chipgroup) {
		this.chipgroup = chipgroup;
	}
	public void setSupport(String support) {
		this.support = support;
	}
	public void setShaders(int shaders) {
		this.shaders = shaders;
	}
	public void setTmus(int tmus) {
		this.tmus = tmus;
	}
	public void setRops(int rops) {
		this.rops = rops;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setRam_bus(int ram_bus) {
		this.ram_bus = ram_bus;
	}
	public void setRam_ck(int ram_ck) {
		this.ram_ck = ram_ck;
	}
	public void setTdp(int tdp) {
		this.tdp = tdp;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setHdmi(String hdmi) {
		this.hdmi = hdmi;
	}
	public void setCk(double ck) {
		this.ck = ck;
	}
	public void setMaxck(double maxck) {
		this.maxck = maxck;
	}
	public void setBirth(Date date) {
		this.birth = date;
	}
	
}
