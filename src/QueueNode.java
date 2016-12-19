import java.util.Scanner;
public class QueueNode{
	long data;
	String s1;
	QueueNode link;

	public QueueNode(long data,String ss, QueueNode node){
		this.data = data;
		this.s1=ss;
		link = node;
	}
	public QueueNode(long amount2, String s12, Object node) {
		this.data = data;
		this.s1=s12;
		link = (QueueNode) node;
		// TODO Auto-generated constructor stub
	}
	public void setData(int data){
		this.data = data;
	}
	public long getData(){
		return data;
	}

	public void setNode(QueueNode node){
		link = node;
	}
	public QueueNode getNode(){
		return link;
	}
}