package day06;
import java.util.*;
public class ArrayListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Music[] musics = new Music[10];
		int size = 0;
		musics[size++] = new Music(1, "����");
		musics[size++] = new Music(2, "����֮��");
		musics[size++] = new Music(3, "�໨��");
		
		musics[3] = musics[2];
		musics[2] = musics[1];
		musics[1] = musics[0];
		musics[0] = new Music(4, "������");
		
		for(Music m : musics){
			System.out.println(m);
		}
		
		//ArrayList musicList = new ArrayList();
		//���͵�ʹ��
		ArrayList<Music> musicList = new ArrayList<Music>();
		//musicList.add("abc");
		musicList.add(new Music(1, "����"));
		musicList.add(new Music(2, "����֮��"));
		musicList.add(new Music(3, "�໨��"));
		musicList.add(0, new Music(4, "������"));
		musicList.remove(2);
		
		System.out.println(musicList);

		Music m = musicList.get(2);
		int position = musicList.indexOf(m);
		System.out.println(position);
		
		System.out.println(musicList.contains(m));
		Music m1 = new Music(3, "�໨��");
		System.out.println(musicList.contains(m1));
		
		for(Music mm : musicList){
			System.out.println(mm);
		}
		
	}

}

class Music{
	private int id;
	private String name;
	private String filename;
	
	public Music(int id, String name){
		this.id = id;
		this.name = name;
	}
	public String toString(){
		return name;
	}
	public boolean equals(Object obj){
		if (obj == null){
			return false;
		}
		if (obj instanceof Music){
			Music m = (Music)obj;
			return m.id == this.id;
		}
		return false;	
	}
	public int hashCode(){
		return id;
	}
}