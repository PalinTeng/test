package test2;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
class Student implements Serializable{//定义一个Student类；
	  int id;
	  String name;
	  int score;
	  public Student(int id,String name,int score){
	//创建一个学号为id,姓名为name，成绩为score的学生对象；
	    setId(id);
	    setName(name);
	    setScore(score);
	  }
	  public void setId(int id){// 设置学生的学号；
	    this.id=id;
	  }
	  public int getId(){//得到学生的学号；
	    return this.id;
	  }
	  public void setName(String name){// 设置学生的姓名；
	    this.name=name;
	  }
	  public String getName(){//得到学生的姓名；
	    return name;
	  }
	  public void setScore(int score){// 设置学生的成绩；
	    this.score=score;
	  }
	  public int getScore(){//得到学生的成绩；
	    return score;
	  }
	}