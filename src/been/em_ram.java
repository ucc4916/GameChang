package been;

public class em_ram {
	private String num;
	private String maker;
	private String kind;
	private int mm=0;
	private int ck=0;
	private int price=0;
	private int count=0;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public int getMm() {
		return mm;
	}
	public int getCk() {
		return ck;
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
	public void setMm(int mm) {
		this.mm = mm;
	}
	public void setCk(int ck) {
		this.ck = ck;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
