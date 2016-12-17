
public class QueueNode{
	int data;
	QueueNode link;

	public QueueNode(int data, QueueNode node){
		this.data = data;
		link = node;
	}
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return data;
	}

	public void setNode(QueueNode node){
		link = node;
	}
	public QueueNode getNode(){
		return link;
	}
}