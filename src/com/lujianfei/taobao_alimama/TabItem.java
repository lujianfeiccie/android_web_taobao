package com.lujianfei.taobao_alimama;

import android.content.Intent;

/** 
* @ClassName: TabItem 
* @Description: TODO 主界面底部菜单实体类
* @author hepengcheng
* @date 2014-10-31 上午11:43:28 
*  
*/
public class TabItem {
	private String title; // tab item title
	private int icon; // tab item icon
	private int bg; // tab item background
	private Intent intent; // tab item intent
	private int textcolor; // tab item textcolor

	public TabItem(String title, int icon, int bg, Intent intent) {
		super();
		this.title = title;
		// this.textcolor = textColor;
		this.icon = icon;
		this.bg = bg;
		this.intent = intent;
	}

	public int getTextcolor() {
		return textcolor;
	}

	public void setTextcolor(int textcolor) {
		this.textcolor = textcolor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getBg() {
		return bg;
	}

	public void setBg(int bg) {
		this.bg = bg;
	}

	public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}
}
