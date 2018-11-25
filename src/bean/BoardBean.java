package bean;

import java.sql.Date;

public class BoardBean {
	private int BOARD_NUM; //글 번호
	private String BOARD_ID; //문의한 아이디
	private String BOARD_PASS; //비밀번호
	private String BOARD_TYPE; //문의 유형
	private String BOARD_SUBJECT; //글 제목
	private String BOARD_CONTENT; //글 내용
	private String BOARD_FILE; //첨부파일명
	private int BOARD_RE_REF; //(답글) 원글 번호
	private int BOARD_RE_LEV; //답글 레벨
	private int BOARD_RE_SEQ; //답글의 출력순서
	private int BOARD_READCOUNT; //조회수
	private Date BOARD_DATE; //작성일자
	private String BOARD_ANSER;//답변자
	
	public String getBOARD_ANSER() {
		return BOARD_ANSER;
	}
	public void setBOARD_ANSER(String bOARD_ANSER) {
		BOARD_ANSER = bOARD_ANSER;
	}
	public int getBOARD_NUM() {
		return BOARD_NUM;
	}
	public void setBOARD_NUM(int bOARD_NUM) {
		BOARD_NUM = bOARD_NUM;
	}
	public String getBOARD_ID() {
		return BOARD_ID;
	}
	public void setBOARD_ID(String bOARD_ID) {
		BOARD_ID = bOARD_ID;
	}
	public String getBOARD_PASS() {
		return BOARD_PASS;
	}
	public void setBOARD_PASS(String bOARD_PASS) {
		BOARD_PASS = bOARD_PASS;
	}
	public String getBOARD_TYPE() {
		return BOARD_TYPE;
	}
	public void setBOARD_TYPE(String bOARD_TYPE) {
		BOARD_TYPE = bOARD_TYPE;
	}
	public String getBOARD_SUBJECT() {
		return BOARD_SUBJECT;
	}
	public void setBOARD_SUBJECT(String bOARD_SUBJECT) {
		BOARD_SUBJECT = bOARD_SUBJECT;
	}
	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}
	public void setBOARD_CONTENT(String bOARD_CONTENT) {
		BOARD_CONTENT = bOARD_CONTENT;
	}
	public String getBOARD_FILE() {
		return BOARD_FILE;
	}
	public void setBOARD_FILE(String bOARD_FILE) {
		BOARD_FILE = bOARD_FILE;
	}
	public int getBOARD_RE_REF() {
		return BOARD_RE_REF;
	}
	public void setBOARD_RE_REF(int bOARD_RE_REF) {
		BOARD_RE_REF = bOARD_RE_REF;
	}
	public int getBOARD_RE_LEV() {
		return BOARD_RE_LEV;
	}
	public void setBOARD_RE_LEV(int bOARD_RE_LEV) {
		BOARD_RE_LEV = bOARD_RE_LEV;
	}
	public int getBOARD_RE_SEQ() {
		return BOARD_RE_SEQ;
	}
	public void setBOARD_RE_SEQ(int bOARD_RE_SEQ) {
		BOARD_RE_SEQ = bOARD_RE_SEQ;
	}
	public int getBOARD_READCOUNT() {
		return BOARD_READCOUNT;
	}
	public void setBOARD_READCOUNT(int bOARD_READCOUNT) {
		BOARD_READCOUNT = bOARD_READCOUNT;
	}
	public Date getBOARD_DATE() {
		return BOARD_DATE;
	}
	public void setBOARD_DATE(Date bOARD_DATE) {
		BOARD_DATE = bOARD_DATE;
	}
	
	
	
	
}
