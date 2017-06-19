package cn.campsg.practical.bubble.entity;

import java.util.ArrayList;

import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.service.StarService;

/**
 * 
 * �����Ǽ����࣬����������ã�<br>
 * <ul>
 * 	<li>1. ���ڴ��б���������10 * 10���������У���Service����������������С�</li>
 * <li>2. ��������������֮��������ǽṹͨѶ��</li>
 * <li>3. Ϊ���������еļ��㡢�������޸��ṩ���ֹ��ܺ���
 *     <ul>
 *         <li>3-1. ����10 * 10�ڴ�������������ĳ�������ǵ����꣨�������ƶ�ʱʹ�ã���</li>
 *         <li>3-2. �ж�ĳ����������10 * 10�ڴ��������������Ƿ���ڡ�</li>
 *         <li>3-3. ��ĳ����������10 * 10�ڴ��������������滻��Null����Ǹ��������ѱ���������</li>
 *         <li>3-4. ���������10 * 10�ڴ�������������Ѱ�Ҷ�Ӧ�������Ƕ���</li>
 *         <li>3-5. ���������10 * 10�ڴ�������������Ѱ�Ҷ�Ӧ��������������</li>
 *     </ul>
 * </li>
 * </ul>
 * @see cn.campsg.practical.bubble.entity.Star
 * 
 * @author Frank.Chen
 * @version 1.0
 *
 */
public class StarList extends ArrayList<Star>{

	private static final long serialVersionUID = 1L;

	/**
	 * ���������10 * 10�ڴ�������������Ѱ�Ҷ�Ӧ�������Ƕ���
	 * 
	 * @param row			��Ѱ�ҵ��������к�
	 * @param column	��Ѱ�ҵ��������к�
	 */
	/*******PRJ-BU2-JAVA-011 Task1 ��1/3 Start��**********/
	public Star lookup(int row, int column){
		for(int i = 0;i<super.size();i++){
				if(super.get(i) == null){
					continue;
				}
				else if(super.get(i).getPosition().getRow() == row &&  super.get(i).getPosition().getColumn() == column ){
					
					return super.get(i);
					}
		}
		return null;
		}
		
	public static void main(String[] args){
		StarList starList = new StarList();
		Star star1 = new Star(new Position(0,0),StarType.BLUE);
		Star star2 = new Star(new Position(1,0),StarType.GREEN);
		Star star3 = new Star(new Position(2,0),StarType.BLUE);
		Star star4 = new Star(new Position(3,0),StarType.RED);
		Star star5 = new Star(new Position(4,0),StarType.BLUE);
		Star star6 = new Star(new Position(5,0),StarType.BLUE);
		Star star7 = new Star(new Position(6,0),StarType.BLUE);
		Star star8 = new Star(new Position(7,0),StarType.BLUE);
		Star star9 = new Star(new Position(8,0),StarType.BLUE);
		Star star10 = new Star(new Position(9,0),StarType.BLUE);
		starList.add(star1);	
		starList.add(star2);
		starList.add(star3);
		starList.add(star4);
		starList.add(star5);
		starList.add(star6);
		starList.add(star7);
		starList.add(star8);
		starList.add(star9);
		starList.add(star10);
		//Star preStar = starList.lookup(3,0);
		//Star pre1Star = starList.lookup(1,1);
		//System.out.println("(3,0)λ�õ������ǣ�" + preStar);
		//System.out.println("(1,1)λ�õ������ǣ�" + pre1Star);
		Star preStar = starList.lookup(new Position(3,0));
		Star pre1Star = starList.lookup(new Position(1,1));
		System.out.println("(3,0)λ�õ������ǣ�" + preStar);
		System.out.println("(1,1)λ�õ������ǣ�" + pre1Star);
	}
	
	
	
	
	
	
	
	/*******PRJ-BU2-JAVA-011 Task1 ��1/3 End��***********/
	
	/**
	 * ���������10 * 10�ڴ�������������Ѱ�Ҷ�Ӧ�������Ƕ���
	 * 
	 * @param position	��Ѱ�ҵ�������λ��
	 */
	/*******PRJ-BU2-JAVA-011 Task2 ��2/3 Start��**********/
	public Star lookup(Position position){
		int row = position.getRow();
		int column = position.getColumn();
		Star star = lookup(row,column);
		return star;
	}

	
	
	
	
	
	
	/*******PRJ-BU2-JAVA-011 Task2 ��2/3 End��***********/

	/**
	 * �ж�ĳ����������10 * 10�ڴ��������������Ƿ���ڡ�
	 * 
	 * @param star ���жϵ������Ƕ���
	 * @return true:���ڣ�false:������
	 */
	/*******PRJ-BU2-JAVA-011 Task3 ��3/3 Start��*********/
	public boolean existed(Star star){
		if(star == null){
			return false;
		}
		Star star0 = lookup(star.getPosition());
		return star0 == null ? false :true; 
	}

	
	
	
	
	
	
	
	
	/*******PRJ-BU2-JAVA-011 Task3 ��3/3 End��***********/

	/**
	 * �õ�10 * 10�ڴ����������������һ��������
	 * 
	 * @return ���һ��������
	 */
	public Star lastElement() {
		int size = size();

		if (size == 0)
			return null;

		return get(size - 1);
	}

	/**
	 * ���������10 * 10�ڴ�������������Ѱ�Ҷ�Ӧ��������������
	 * eg:
	 * 	0 1 2
	 *  3 4 5
	 *  6 7 8
	 * 
	 * @param row			��Ѱ�ҵ��������к�
	 * @param column	��Ѱ�ҵ��������к�
	 * @return					��������10 * 10�ڴ�����������������
	 */
	public int indexOf(int row, int column) {

		int base = (int) Math.sqrt(size());

		return row * base + column;
	}
	
	/**
	 * ��ĳ����������10 * 10�ڴ��������������滻��Null����Ǹ��������ѱ�������
	 * 
	 * @param row			���ΪNull���������к�
	 * @param column	���ΪNull���������к�
	 */
	public void setNull(int row, int column) {
		//��������Ѱ��������
		Star star = lookup(row, column);
		
		//��ȡ��������10 * 10�ڴ�������������������
		int seq = indexOf(star);

		if (seq < 0)
			return;
		
		//��10 * 10�ڴ������������ж�Ӧλ������ΪNull
		set(seq, null);
	}
	
	/**
	 * ����10 * 10�ڴ�������������ĳ�������ǵ����꣨�������ƶ�ʱʹ�ã�
	 * 
	 * @param orow			������ԭʼ�к�
	 * @param ocolumn		������ԭʼ�к�
	 * @param row				�����Ǵ����µ��к�
	 * @param column		�����Ǵ����µ��к�
	 */
	public void update(int orow, int ocolumn, int row, int column) {
		//�����к����кŻ�ȡ������ԭʼ����
		Star ostar = lookup(orow, ocolumn);
		//�����к����кŻ�ȡ������Ŀ�����
		Star star = lookup(row, column);

		//���Ŀ��������Ϊ�գ���ôΪ�������괴��һ��Ŀ��������
		if (star == null) {
			star = new Star();
			star.setPosition(new Position(row, column));
			//����������µ�Ŀ��λ��
			set(indexOf(row, column), star);
		}
		
		//����������ֻ��ֱ���滻��ɫ���ɣ���������仯��
		star.setType(ostar.getType());
		
		//ԭʼ������λ������ΪNull��ʾԭʼ�����Ѿ�������
		setNull(orow, ocolumn);

	}
	
	@Override
	public String toString() {

		StringBuffer date = new StringBuffer("��");
		for (int seq = 0; seq < size(); seq++) {
			Star star = get(seq);
			if (star != null) {

				if(star instanceof MovedStar){
					MovedStar movedStar = (MovedStar)star;
					int orowNum = movedStar.getPosition().getRow();
					int ocolNum = movedStar.getPosition().getColumn();
					int rowNum = movedStar.getMovedPosition().getRow();
					int colNum = movedStar.getMovedPosition().getColumn();
					date.append("(" + orowNum + "," + ocolNum + ")->"+"(" + rowNum + "," + colNum + ")"+"\t");
				}else{
					int rowNum = star.getPosition().getRow();
					int colNum = star.getPosition().getColumn();
					date.append("(" + rowNum + "," + colNum + "-" + star.getType()
							+ ") \t");
				}
			} else {
				date.append("(null) \t\t");
			}

			if ((seq + 1) % StarService.MAX_COLUMN_SIZE == 0) {
				date.append("\n");
			} else {
				date.append(" ,");
			}
		}
		date.deleteCharAt(date.length()-1);

		return date.toString();
	}
}