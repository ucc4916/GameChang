package been;

public class em_ssd {
	private String num;
	private String maker;
	private String kind;
	private int read=0;
	private int write=0;
	private int read_iops=0;
	private int write_iops=0;
	private int dram=0;
	private int life=0;
	private int memory=0;
	private int price=0;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNum() {
		return num;
	}
	
	public String getMaker() {
		return maker;
	}
	public String getKind() {
		return kind;
	}
	public int getRead() {
		return read;
	}
	public int getWrite() {
		return write;
	}
	public int getRead_iops() {
		return read_iops;
	}
	public int getWrite_iops() {
		return write_iops;
	}
	public int getDram() {
		return dram;
	}
	public int getLife() {
		return life;
	}
	public int getMemory() {
		return memory;
	}
	public int getPrice() {
		return price;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setRead(int read) {
		this.read = read;
	}
	public void setWrite(int write) {
		this.write = write;
	}
	public void setRead_iops(int read_iops) {
		this.read_iops = read_iops;
	}
	public void setWrite_iops(int write_iops) {
		this.write_iops = write_iops;
	}
	public void setDram(int dram) {
		this.dram = dram;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
