package been;

public class em_box_hdd {
	private int num;
	private String  hdd_num;
	
	
	private int hdd_mm;
	public int getHdd_mm() {
		return hdd_mm;
	}
	public void setHdd_mm(int hdd_mm) {
		this.hdd_mm = hdd_mm;
	}
	
	public int getNum() {
		return num;
	}
	public String getHdd_num() {
		return hdd_num;
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
	public void setHdd_num(String hdd_num) {
		this.hdd_num = hdd_num;
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
