package test2;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
class Student implements Serializable{//����һ��Student�ࣻ
	  int id;
	  String name;
	  int score;
	  public Student(int id,String name,int score){
	//����һ��ѧ��Ϊid,����Ϊname���ɼ�Ϊscore��ѧ������
	    setId(id);
	    setName(name);
	    setScore(score);
	  }
	  public void setId(int id){// ����ѧ����ѧ�ţ�
	    this.id=id;
	  }
	  public int getId(){//�õ�ѧ����ѧ�ţ�
	    return this.id;
	  }
	  public void setName(String name){// ����ѧ����������
	    this.name=name;
	  }
	  public String getName(){//�õ�ѧ����������
	    return name;
	  }
	  public void setScore(int score){// ����ѧ���ĳɼ���
	    this.score=score;
	  }
	  public int getScore(){//�õ�ѧ���ĳɼ���
	    return score;
	  }
	}