package com.lujianfei.taobao_alimama;

import java.util.ArrayList;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;


/**
 * @ClassName: TabHostActivity
 * @Description: 主界面TabHostActivity
 * @author hepengcheng
 * @date 2014-10-31 上午11:43:06
 * 
 */
public abstract class TabHostActivity extends TabActivity {
	// 控件
	public TabHost mTabHost;
	private TabWidget mTabWidget;
	private LayoutInflater mLayoutflater;

	/**
	 * @Fields tabItemTextViewList : TODO 存取底部Spec TextView ArrayList
	 */
	private ArrayList<TextView> tabItemTextViewList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// set theme because we do not want the shadow
		setTheme(R.style.Theme_Tabhost);
		setContentView(R.layout.activity_main);
		mLayoutflater = getLayoutInflater();
		mTabHost = getTabHost();
		mTabWidget = getTabWidget();
		// mTabWidget.setStripEnabled(false); // need android2.2
		prepare();
		initTabSpec();
		
		mTabHost.setOnTabChangedListener(new OnTabChangeListener() {

			@Override
			public void onTabChanged(String tabId) {
			}
		});
	}

	/** 在初始化界面之前调用 */
	protected void prepare() {
		// do nothing or you override it
	}

	/**
	 * @Title: getTabCount
	 * @Description: 获取TabWdiget 的Tab Count
	 * @return
	 * @return int
	 * @throws
	 */
	protected int getTabCount() {
		return mTabHost.getTabWidget().getTabCount();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mLayoutflater = null;
		mTabWidget = null;
		mTabHost = null;
		for (TextView tv : tabItemTextViewList) {
			tv.setCompoundDrawables(null, null, null, null);
			tv.setBackgroundResource(0);
			tv = null;
		}
		tabItemTextViewList.clear();
		tabItemTextViewList = null;
		System.gc();
	}

	/**
	 * @Title: setTabItemTextView
	 * @Description: 设置TabItem的图标和标题�?
	 * @param textView
	 * @param position
	 * @return void
	 * @throws
	 */
	abstract protected void setTabItemTextView(TextView textView, int position);

	/**
	 * @Title: getTabItemId
	 * @Description: 获取每个Tab item的Id
	 * @param position
	 * @return
	 * @return String
	 * @throws
	 */
	abstract protected String getTabItemId(int position);

	/**
	 * @Title: getTabItemIntent
	 * @Description: 获取每个Tab 要跳转的Intent
	 * @param position
	 * @return
	 * @return Intent
	 * @throws
	 */
	abstract protected Intent getTabItemIntent(int position);

	/**
	 * @Title: getTabItemCount
	 * @Description: 返回TabWidget 中Tab 的数�?
	 * @return
	 * @return int
	 * @throws
	 */
	abstract protected int getTabItemCount();

	/**
	 * @Title: setCurrentTab
	 * @Description: 设置当前切换到的Tab Spec
	 * @param index
	 * @return void
	 * @throws
	 */
	protected void setCurrentTab(int index) {
		mTabHost.setCurrentTab(index);
	}

	/**
	 * @Title: focusCurrentTab
	 * @Description: 设置当前获取焦点的Tab Spec
	 * @param index
	 * @return void
	 * @throws
	 */
	protected void focusCurrentTab(int index) {
		mTabWidget.focusCurrentTab(index);
	}


	/**
	 * @Title: initTabSpec
	 * @Description: 初始化每个Item Spec
	 * @return void
	 * @throws
	 */
	private void initTabSpec() {
		int count = getTabItemCount();
		View tabItem = null;
		TabSpec tabSpec = null;
		TextView tvTabItem = null;
		tabItemTextViewList = new ArrayList<TextView>();
		for (int i = 0; i < count; i++) {
			tabItem = mLayoutflater.inflate(R.layout.index_tab_item, null);
			tvTabItem = (TextView) tabItem.findViewById(R.id.tab_item_tv);
			setTabItemTextView(tvTabItem, i);
			tabItemTextViewList.add(tvTabItem);
			// set id
			String tabItemId = getTabItemId(i);
			// set tab spec
			tabSpec = mTabHost.newTabSpec(tabItemId);
			tabSpec.setIndicator(tabItem);
			tabSpec.setContent(getTabItemIntent(i));
			mTabHost.addTab(tabSpec);
		}
		tabItem = null;
		tabSpec = null;
		tvTabItem = null;
	}

}
