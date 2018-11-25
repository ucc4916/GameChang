package been;

public class em_box_ssd {
	private int num;
	private String  ssd_num;
	private int count;
	
	private int ssd_mm;
	public int getSsd_mm() {
		return ssd_mm;
	}
	public void setSsd_mm(int ssd_mm) {
		this.ssd_mm = ssd_mm;
	}
	
	public int getNum() {
		return num;
	}
	public String  getSsd_num() {
		return ssd_num;
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
	public void setSsd_num(String  ssd_num) {
		this.ssd_num = ssd_num;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int price;
}
